package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";

    protected AppiumDriver driver;
    private static String AppiumURL = "http://localhost:4723";


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = this.getPlatformDriver();
    }


    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    private AppiumDriver getPlatformDriver() throws Exception
    {
        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = getCapabilitiesByPlatformEnv();

        if(platform.equals(PLATFORM_ANDROID)){
            return new AndroidDriver(new URL(AppiumURL), capabilities);
        } else if (platform.equals(PLATFORM_IOS)){
            return new IOSDriver(new URL(AppiumURL), capabilities);
        } else {
            throw new Exception("Cannot get run platform from env variable. Platform value: " + platform);
        }
    }

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform.equals(PLATFORM_ANDROID)) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "13.0");
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("automationName", "UIAutomator2");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", "main.MainActivity");
            capabilities.setCapability("app", "/Users/petrkuznecov/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/wikipedia-2-7-50.apk");
            capabilities.setCapability("autoGrantPermissions", true); // настройка для авторазрешения пермишенинов
        } else if (platform.equals(PLATFORM_IOS)) {

            capabilities.setCapability("platformName", "IOS");
            capabilities.setCapability("platformVersion", "17.2");
            capabilities.setCapability("deviceName", "iPhone 15");
            capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("app", "/Users/petrkuznecov/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/Wikipedia.app");
        } else {
            throw new Exception("Cannot get run  platform from env variable. Platform value " + platform);
        }

        return capabilities;
    }

}
