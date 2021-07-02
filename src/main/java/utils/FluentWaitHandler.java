package utils;

import driver.DriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FluentWaitHandler extends DriverHandler {

    FluentWait<WebDriver> fluentWait;

    public FluentWaitHandler() {
        super();
        fluentWait = new FluentWait<WebDriver>(this.browser);
        fluentWait.withTimeout(Duration.ofSeconds(5));
    }

    public FluentWaitHandler(WebDriver browser) {
        super(browser);
        fluentWait = new FluentWait<WebDriver>(this.browser);
        fluentWait.withTimeout(Duration.ofSeconds(10));
    }

    public WebElement waitUntil(By elementToWaitFor) {
        fluentWait.ignoring(NoSuchElementException.class);
        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(elementToWaitFor));
    }

    public boolean waitUntilVisibilityOfElement(By elementToWaitFor) {
        fluentWait.ignoring(NoSuchElementException.class);
        return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(elementToWaitFor))!=null;
    }

    public boolean waitUntilVisibilityOfElement(WebElement elementToWaitFor) {
        fluentWait.ignoring(NoSuchElementException.class);
        return fluentWait.until(ExpectedConditions.visibilityOf(elementToWaitFor))!=null;
    }

    public List<WebElement> waitUntilList(By elementsToWaitFor) {
        try{
            return fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementsToWaitFor));
        }catch (Exception ex){
            System.out.println("An error has occured!: " + ex.getMessage());
        }
        return new ArrayList<WebElement>();
    }
}

