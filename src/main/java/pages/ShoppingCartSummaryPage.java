package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage extends BasePage {

    @FindBy(xpath = "//table[@id='cart_summary']/tbody/tr[1]/td[@class='cart_description']/p/a")
    private WebElement columnProductName;
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement dropDownMyShoppingCart;
    @FindBy(className = "ajax_cart_block_remove_link")
    private WebElement iconButtonRemoveItemFromShoppingCart;

    private By bannerEmptyCartXpath = By.xpath("//p[text()='Your shopping cart is empty.']");

    public ShoppingCartSummaryPage(WebDriver browser){
        super(browser);
        PageFactory.initElements(browser, this);
    }

    public boolean isAddedSelectedProduct(String productName){
        scrollToVisibleElement(columnProductName);
        return columnProductName.getText().equalsIgnoreCase(productName);
    }

    public boolean deleteAddedProduct(){
        hoverToElement(dropDownMyShoppingCart);
        iconButtonRemoveItemFromShoppingCart.click();
        return waitUntilVisibilityOfElement(bannerEmptyCartXpath);
    }

}
