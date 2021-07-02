import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationPO;
import utils.Config;

public class TestNG_ValidateFooterStoreInformation extends BaseTest {

    AutomationPO mainPage = null;

    @BeforeMethod
    private void setUp() {
        this.browserInitializer();
        this.setUp(Config.BASE_URI);
        mainPage = new AutomationPO(this.browser);
    }

    @Test
    public void testValidatingFooterStoreInformation() {
        final String address = "Selenium Framework, Research Triangle Park, North Carolina, USA";
        final String phoneNumber = "(347) 466-7432";
        final String emailAddress = "support@seleniumframework.com";
        try {
            Assert.assertTrue(mainPage.isMainPageIsVisible(), "Automation page doesn't shows correctly");
            Assert.assertTrue(mainPage.validateStoreInformation(address, phoneNumber, emailAddress),
                    "The information of store didn't match!");
        } catch (AssertionError ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @AfterMethod
    private void cleanUp() {
        tearDown();
    }
}
