package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPO extends BasePO {

    @FindBy(xpath = "//table[@id='cart_summary']/tbody/tr[1]/td[@class='cart_description']/p/a")
    private WebElement columnProductName;
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement dropDownMyShoppingCart;
    @FindBy(className = "ajax_cart_block_remove_link")
    private WebElement iconButtonRemoveItemFromShoppingCart;

    private By bannerEmptyCartXpath = By.xpath("//p[text()='Your shopping cart is empty.']");

    public ShoppingCartSummaryPO(WebDriver browser){
        super(browser);
        PageFactory.initElements(browser, this);
    }

    public boolean isAddedSelectedItem(String itemName){
        scrollToVisibleElement(this.columnProductName);
        if(waitUntilVisibilityOfElement(this.columnProductName))
           return this.columnProductName.getText().equalsIgnoreCase(itemName);

        return false;
    }

    public void deleteAddedItem(){
        hoverToElement(this.dropDownMyShoppingCart);
        this.iconButtonRemoveItemFromShoppingCart.click();
    }

    public boolean isAddedItemDeleted(){
        return waitUntilVisibilityOfElement(this.bannerEmptyCartXpath);
    }
}
