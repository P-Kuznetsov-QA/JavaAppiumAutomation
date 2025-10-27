package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    private static String AppiumURL = "http://localhost:4723";


    @Override
    protected void setUp() throws Exception {
        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "main.MainActivity");
        capabilities.setCapability("app", "/Users/petrkuznecov/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/wikipedia-2-7-50.apk");
        capabilities.setCapability("autoGrantPermissions", true); // настройка для авторазрешения пермишенинов

        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
    }


    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }


}
