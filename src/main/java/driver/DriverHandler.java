package driver;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.BeforeClass;
import utils.Config;

import java.util.concurrent.TimeUnit;

public class DriverHandler {

    public WebDriver browser;

    private void browserInstance(ChromeOptions options){
        this.browser = new ChromeDriver(options);
        this.browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        this.browser.manage().window().maximize();
    }
    public void browserInitializer(){
        if (isBrowserClosed(this.browser))
        browserInstance(new ChromeOptions());
    }

    public void browserInitializer(ChromeOptions options){
        if (isBrowserClosed(this.browser))
        browserInstance(options);
    }

    public DriverHandler() {
        System.setProperty(Config.DRIVER, Config.DRIVER_EXE_PATH);
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
