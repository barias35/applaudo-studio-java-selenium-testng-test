package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class AutomationPO extends BasePO {

    @FindBy(xpath = "//ul[contains(@class,'sf-menu clearfix')]")
    private WebElement mainMenu;
    @FindBy(id = "search_query_top")
    private WebElement searchTextBox;
    @FindBy(className = "ajax_cart_no_product")
    private WebElement shoppingCart;
    @FindBy(xpath = "//section[@id='block_contact_infos']/div[1]/ul[1]/li[1]")
    private WebElement footerLabelLocation;
    @FindBy(css = "section#block_contact_infos>div>ul>li:nth-of-type(2)>span")
    private WebElement footerLabelPhoneNumber;
    @FindBy(css = "section#block_contact_infos>div>ul>li:nth-of-type(3)>span>a")
    private WebElement footerLabelEmailAddress;

    private String addToCartXpath = "//img[@alt='%s']/ancestor::div[@class='product-container']/div/div[@class='button-container']/a[@title='Add to cart']";
    private final By listOfProductsXpath = By.xpath("//a[@class='product_img_link']//img");
    private final By buttonProcessToCheckOutXpath = By.xpath("//a[@title='Proceed to checkout']");
    private final By bannerAddedProductToShoppingCart = By.xpath("//div[contains(@class,'layer_cart_cart col-xs-12')]");
    private final int _verifyingBannerAddedShoppingCartRetries = 3;

    private ShoppingCartSummaryPO shoppingCartSummaryPO;

    public ShoppingCartSummaryPO getShoppingCartSummaryPO() {
        if (shoppingCartSummaryPO == null) {
            shoppingCartSummaryPO = new ShoppingCartSummaryPO(this.browser);
        }
        return shoppingCartSummaryPO;
    }

    public AutomationPO(WebDriver browser) {
        super(browser);
        PageFactory.initElements(this.browser, this);
    }

    public boolean isMainPageIsVisible() {
        return waitUntilVisibilityOfElement(this.mainMenu);
    }

    public List<WebElement> searchItems(String itemToSearch) {
        searchTextBox.sendKeys(itemToSearch);
        searchTextBox.sendKeys(Keys.ENTER);
        return waitUntilList(listOfProductsXpath);
    }

    public boolean isVisibleNotFoundItemsAlert() {
        WebElement alertNotFoundItems = waitUntil(By.xpath("//p[@class='alert alert-warning']"));
        System.out.println("Message from the page: " + alertNotFoundItems.getText());
        return alertNotFoundItems.isDisplayed();
    }

    public ShoppingCartSummaryPO addItemToShoppingCart(String itemToSearch) {
        return this.getShoppingCartSummaryPO();
    }

    public boolean validateStoreInformation(String address, String phoneNumber, String emailAddress) {
        scrollToVisibleElement(footerLabelEmailAddress);
        waitUntilVisibilityOfElement(footerLabelEmailAddress);
        return footerLabelLocation.getText().contains(address) &&
                footerLabelPhoneNumber.getText().equalsIgnoreCase(phoneNumber)&&
                footerLabelEmailAddress.getText().equalsIgnoreCase(emailAddress);
    }

    public WebElement selectRandomItem(String itemToSearch)  {

        List<WebElement> items = searchItems(itemToSearch);

        if (items.size() == 0)
            return null;

        Random random = new Random();
        int selectedItemIndex = random.nextInt(items.size());
        WebElement selectedProduct = items.get(selectedItemIndex);
        String productNameSelected = selectedProduct.getAttribute("alt");
        addToCartXpath = String.format(addToCartXpath, productNameSelected);
        return selectedProduct;
    }

    public ShoppingCartSummaryPO addToCartSelectedItem(WebElement selectedProduct) {
        tryAddItemToShoppingCart(selectedProduct);
        WebElement processToCheckOutButton = waitUntil(buttonProcessToCheckOutXpath);
        processToCheckOutButton.click();
        return this.getShoppingCartSummaryPO();
    }

    private void tryAddItemToShoppingCart(WebElement selectedProduct)  {
        WebElement addToCartButton = waitUntil(By.xpath(addToCartXpath));
        browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        for (int i = 0; i < _verifyingBannerAddedShoppingCartRetries; i++) {
            try {
                scrollAndHoverElement(selectedProduct);
                addToCartButton.click();
               if(waitUntilVisibilityOfElement(bannerAddedProductToShoppingCart))
                   break;

            } catch (Exception ex) {
            }
        }
    }
}


