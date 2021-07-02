package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.FluentWaitHandler;
import utils.ThreadSleepHelper;


public class BasePO extends FluentWaitHandler {

    public BasePO(WebDriver browser) {
        super(browser);
    }

    public void hoverToElement(WebElement webElement){
        try {
            Actions actions = new Actions(this.browser);
            actions.moveToElement(webElement).perform();
        }catch (Exception ex){

        }

    }

    public void scrollToVisibleElement(WebElement webElement){
        try{
            JavascriptExecutor js = (JavascriptExecutor)this.browser;
            js.executeScript("arguments[0].scrollIntoView();", webElement);
            ThreadSleepHelper.threadSleep(1000);
        }catch (Exception ex){

        }
    }

    public void scrollAndHoverElement(WebElement webElement)  {
        try {
            scrollToVisibleElement(webElement);
            ThreadSleepHelper.threadSleep(1000);
            hoverToElement(webElement);
        }catch (Exception ex){

        }
    }
}
