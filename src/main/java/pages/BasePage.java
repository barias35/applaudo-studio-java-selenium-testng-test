package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.FluentWaitHandler;


public class BasePage extends FluentWaitHandler {

    public BasePage() {
        super();
    }

    public BasePage(WebDriver browser) {
        super(browser);
    }

    public void hoverToElement(WebElement webElement){
        Actions actions = new Actions(browser);
        actions.moveToElement(webElement).perform();
    }

    public void scrollToVisibleElement(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void scrollAndHoverElement(WebElement webElement)  {
        try {
            scrollToVisibleElement(webElement);
            Thread.sleep(500);
            hoverToElement(webElement);
        }catch (Exception ex){

        }
    }
}
