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

public class FluentWaitHandler {

    public WebDriver browser;
    FluentWait<WebDriver> fluentWait;

    public FluentWaitHandler(WebDriver driver) {
        this.browser = driver;
        fluentWait = new FluentWait<>(this.browser);
        fluentWait.withTimeout(Duration.ofSeconds(10));
    }

    public WebElement waitUntil(By elementToWaitFor) {
        try {
            fluentWait.ignoring(NoSuchElementException.class);
            return fluentWait.until(ExpectedConditions.presenceOfElementLocated(elementToWaitFor));
        } catch (Exception ex) {

        }
        return null;
    }

    public boolean waitUntilVisibilityOfElement(By elementToWaitFor) {
        try {
            fluentWait.ignoring(NoSuchElementException.class);
            return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(elementToWaitFor)) != null;
        } catch (Exception ex) {
        }
        return false;
    }

    public boolean waitUntilVisibilityOfElement(WebElement elementToWaitFor) {
        try {
            fluentWait.ignoring(NoSuchElementException.class);
            return fluentWait.until(ExpectedConditions.visibilityOf(elementToWaitFor)) != null;
        } catch (Exception ex) {
        }
        return false;
    }

    public List<WebElement> waitUntilList(By elementsToWaitFor) {
        try {
            return fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementsToWaitFor));
        } catch (Exception ex) {
            System.out.println("An error has occured!: " + ex.getMessage());
        }
        return new ArrayList<>();
    }
}

