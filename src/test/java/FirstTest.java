import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "main.MainActivity");
        capabilities.setCapability("app", "/Users/petrkuznecov/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/wikipedia-2-7-50.apk");

        driver = new AndroidDriver<>(new URL("http://localhost:4723"), capabilities);
    }

    @Test
    public void testSearchInputHasText() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        ); // из-за более новой версии при запуске приложения открывается onboarding, поэтому требуется дополнительно его пропускать

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );

        assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Search input",
                "Поиск по Википедии"
        );
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    // функции для написания тестов
    private WebElement waitForElementForPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }


    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementForPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementForPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }


    private Boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementForPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    private void assertElementHasText(By by, String error_element_message, String expected_text) {
        // ждем появление элемента
        WebElement element = waitForElementForPresent(by, "Cannot find element", 10);
        String actual_text = element.getText();
        Assert.assertEquals(
                error_element_message + " does not have the expected text available", // для удобства можно прописать названия элемента, а ассерт уже в ошибке покажет ожидаемый и фактический результат
                expected_text,
                actual_text
        );
    }


}
