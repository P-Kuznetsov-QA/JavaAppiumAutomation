package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CoreTestCase extends TestCase {

    protected RemoteWebDriver driver;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.openWikiWebPageForMobileWeb();
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void openWikiWebPageForMobileWeb() {
        if (Platform.getInstance().isMobileWeb()) {
            driver.get("https://ru.m.wikipedia.org");
        } else {
            System.out.println("Method openWikiWebPageForMobileWeb() do nothing for platform ");
        }
    }
}
