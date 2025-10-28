package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class IOSTestCase extends TestCase {

    protected AppiumDriver driver;
    private static String AppiumURL = "http://localhost:4723";


    @Override
    protected void setUp() throws Exception {
        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("platformVersion", "17.2");
        capabilities.setCapability("deviceName", "iPhone 15");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", "/Users/petrkuznecov/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/Wikipedia.app");
        capabilities.setCapability("autoGrantPermissions", true); // настройка для авторазрешения пермишенинов

        driver = new IOSDriver(new URL(AppiumURL), capabilities);
    }


    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }


}
