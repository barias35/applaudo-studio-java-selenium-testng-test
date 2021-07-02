package driver;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class DriverHandler {

    public WebDriver browser;

    private void browserInitializer(){
        this.browser = new ChromeDriver();
        this.browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        this.browser.manage().window().maximize();
    }
    public DriverHandler() {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium-drivers\\chromedriver.exe");

        if (isBrowserClosed(this.browser))
        browserInitializer();
    }

    public DriverHandler(WebDriver browser) {

        if (isBrowserClosed(browser))
            browserInitializer();
        else
        this.browser = browser;
    }

    public boolean isBrowserClosed(WebDriver browser)
    {
        boolean isClosed = false;
        try {
            if (browser != null) {
                browser.getTitle();
            }else {
                isClosed = true;
            }

        } catch(NoSuchSessionException ex) {
            isClosed = true;
        }
        return isClosed;
    }

    public void setUp(String url){
        this.browser.get(url);
    }

    public void tearDown(){
        this.browser.close();
        this.browser.quit();
    }
}
