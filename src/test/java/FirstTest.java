import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

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
        capabilities.setCapability("autoGrantPermissions", true); // настройка для авторазрешения пермишенинов

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

    @Test
    public void testCancelSearch() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Cannot find Search input",
                5
        );

        waitForElementForPresent(
                By.xpath("//*[contains(@text,'язык программирования')]"),
                "Cannot find 'язык программирования' in result search",
                15);

        assertElementHasText(
                By.xpath("//*[contains(@resource-id,'org.wikipedia:id/page_list_item_title')]"),
                "Search result",
                "Java"
        );

        assertElementHasText(
                By.xpath("//*[contains(@text,'JavaScript')]"),
                "Search result",
                "JavaScript"
        );

        waitForElementAndClick(
                MobileBy.AccessibilityId("Удалить запрос"),
                "Cannot find button clear result search",
                5
        );

        waitForElementNotPresent(
                By.xpath("//*[contains(@text,'язык программирования')]"),
                "The search result is still displayed",
                15
        );
    }

    @Test
    public void testCheckWordsSearch() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Cannot find Search input",
                5
        );

        waitForElementForPresent(
                By.xpath("//*[contains(@text,'Java')]"),
                "Cannot find 'Java' in result search",
                15);

        assertElementContainsText(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='JavaScript']"),
                "As a result search",
                "Java"
        );

        assertElementContainsText(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='Java']"),
                "As a result search",
                "Java"
        );

        assertElementContainsText(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and contains(@text, 'JavaServer Pages')]"),
                "As a result search",
                "Java"
        );

        assertElementContainsText(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and contains(@text, 'Java Platform, Standard Edition')]"),
                "As a result search",
                "Java"
        );

        assertElementContainsText(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and contains(@text, 'JavaFX')]"),
                "As a result search",
                "Java"
        );

        assertElementContainsText(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and contains(@text, 'Java Virtual Machine')]"),
                "As a result search",
                "Java"
        );
    }

    @Test
    public void testSwipeSearchArticle() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Selenium",
                "Cannot find Search input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='Selenium']"),
                "Cannot find 'Java' in result search",
                10);

        waitForElementForPresent(
                By.xpath("//*[contains(@text, 'инструмент для автоматизации действий веб-браузера и тестирования веб-приложений')]"),
                "Cannot find article title",
                10
        );

        swipeUpToFindElement(
                By.xpath("//*[@content-desc='Просмотреть статью в браузере']"),
                "Cannot find footer page",
                30
        );

    }

    @Test
    public void testOnboardingSwipe() {
        swipeLeftToFindElement(
                By.xpath("//*[contains(@text, 'Новые способы исследований')]"),
                "Cannot find 2 page onboarding",
                2
        );

        swipeLeftToFindElement(
                By.xpath("//*[contains(@text, 'Списки для чтения с синхронизацией')]"),
                "Cannot find 2 page onboarding",
                2
        );

        swipeLeftToFindElement(
                By.xpath("//*[contains(@text, 'Отправлять отчёты об использовании')]"),
                "Cannot find 2 page onboarding",
                2
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_done_button"),
                "Cannot find button 'Начать",
                5
        );
    }

    @Test
    public void testSaveArticleToMyList() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Selenium",
                "Cannot find Search input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='Selenium']"),
                "Cannot find 'Selenium' in result search",
                10);

        waitForElementForPresent(
                By.xpath("//*[contains(@text, 'инструмент для автоматизации действий веб-браузера и тестирования веб-приложений')]"),
                "Cannot find article title",
                10);

        waitForElementAndClick(
                By.id("org.wikipedia:id/article_menu_bookmark"),
                "Cannot find button 'save'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.Button[@resource-id='org.wikipedia:id/snackbar_action']"),
                "Cannot find button 'Add in the List'",
                5
        );


        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='Создать новый']"),
                "Cannot find button 'Создать новый'",
                5
        );


        waitForElementAndSendKeys(
                By.xpath("//android.widget.EditText[@resource-id='org.wikipedia:id/text_input']"),
                "Test List",
                "Cannot find text input",
                5
        );

        waitForElementAndClick(
                By.id("android:id/button1"),
                "Cannot find button 'OK'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Перейти вверх']"),
                "Cannot find button 'back'",
                5
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search input after return",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Android",
                "Cannot find search input after return",
                5
        );


        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='Android']"),
                "Cannot find result search by Android",
                5
        );

        waitForElementForPresent(
                By.xpath("//*[@text='Android']"),
                "Cannot find article 'Android'",
                15
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/article_menu_bookmark"),
                "Cannot find button 'save'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.Button[@resource-id='org.wikipedia:id/snackbar_action']"),
                "Cannot find button 'Add in the List'",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/item_title"),
                "Cannot find title new create List",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Перейти вверх']"),
                "Cannot find button 'back'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton"),
                "Cannot find button 'back'",
                5
        );


        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@resource-id='org.wikipedia:id/largeLabel']"),
                "Cannot find navigation button 'My List'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@resource-id='org.wikipedia:id/smallLabel' and @text='Мои списки']"),
                "Cannot find created folder",
                5
        );

        waitForElementForPresent(
                By.xpath("//android.widget.TextView[@resource-id='org.wikipedia:id/item_title' and @text='Test List']"),
                "Cannot find save article in the list",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@resource-id='org.wikipedia:id/item_title' and @text='Test List']"),
                "Cannot find save article in the list",
                5
        );

        swipeElementToLeft(
                By.xpath("//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_description' and @text='инструмент для автоматизации действий веб-браузера и тестирования веб-приложений']"),
                "Cannot find article 'Selenium'"
        );

        waitForElementNotPresent(
                By.xpath("//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_description' and @text='инструмент для автоматизации действий веб-браузера и тестирования веб-приложений']"),
                "The saved article is still displayed",
                5
        );

        waitForElementForPresent(
                By.xpath("//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_description' and @text='бесплатная и открытая операционная система для мобильных устройств, разрабатываемая компанией Google']"),
                "Cannot find save article 'Android'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title' and @text='Android']"),
                "Cannot find title two save article",
                5
        );

        assertElementHasText(
                By.xpath("//*[contains(@text, 'Android')]"),
                "Title article 'Android'",
                "Android"
        );
    }

    @Test
    public void testAssertHasTitle() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Fifa",
                "Cannot find Search input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='FIFA (серия игр)']"),
                "Cannot find result search by 'Fifa'",
                10
        );

        assertElementPresent(
                By.xpath("//*[@text='FIFA (серия игр)']"),
                "The title article is not displayed"
        );
    }



    @Test
    public void testNumberResponsesSearch() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );

        String searchText = "Дискография Toxis";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                searchText,
                "Cannot find Search input",
                5
        );


        String search_result_locator = "//*[@resource-id='org.wikipedia:id/page_list_item_title']";
        waitForElementForPresent(
                By.xpath(search_result_locator),
                "Cannot find request " + searchText,
                15
        );

        int amountOfSearchResults = getAmountOfElements(
                By.xpath(search_result_locator)
        );

        Assert.assertTrue(
                "We found too few results",
                amountOfSearchResults > 0);

    }

    @Test
    public void testEmptyResultSearch() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );

        String searchText = "прпропропорпро";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                searchText,
                "Cannot find Search input",
                5
        );


        String resultSearch = "//*[@resource-id= 'org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_title']";
        String emptySearch = "//*[@text='Ничего не найдено']";

        waitForElementForPresent(
                By.xpath(emptySearch),
                "Cannot find text 'Ничего не найдено'",
                10
        );


        assertElementNotPresent(
                By.xpath(resultSearch),
                "We've found some results by result " + searchText
        );
    }

    @Test
    public void testChangeOrientationSearchResult() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );
        String search_line = "Java";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Cannot find Search input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='Java']"),
                "Cannot find 'Java' in result search by " + search_line,
                15);

        String title_before_rotation = waitForElementAndAttribute(
                By.xpath("(//android.widget.TextView[@text='Java'])[1]"),
                "text",
                "Cannot find description of article",
                15
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = waitForElementAndAttribute(
                By.xpath("(//android.widget.TextView[@text='Java'])[1]"),
                "text",
                "Cannot find description of article",
                15
        );

        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_rotation
        );
    }

    @Test
    public void testCheckSearchArticleInBackground() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );
        String search_line = "Java";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Cannot find Search input",
                5
        );

        waitForElementForPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='Java']"),
                "Cannot find 'Java' in result search by " + search_line,
                15);

        driver.runAppInBackground(Duration.ofSeconds(2));

        waitForElementForPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='Java']"),
                "Cannot find 'Java' after returning in background",
                15);

    }


    @After
    public void tearDown() {
        driver.rotate(ScreenOrientation.PORTRAIT);
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

    private void assertElementContainsText(By by, String error_element_message, String expected_text) {
        // Ждем появление элемента
        WebElement element = waitForElementForPresent(by, "Cannot find element", 10);
        String actual_text = element.getText();

        Assert.assertTrue(
                error_element_message + " - '" + actual_text + "' - does not contain - " + expected_text, // для удобства можно прописать только начало ошибки
                actual_text.contains(expected_text)
        );
    }

    protected void swipe(int startX, int startY, int endX, int endY, int timeOfSecond) {
        PointerInput touchDevice = new PointerInput(PointerInput.Kind.TOUCH, "touchDevice");
        Sequence swipe = new Sequence(touchDevice, 1);

        swipe.addAction(touchDevice.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(touchDevice.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(touchDevice.createPointerMove(Duration.ofMillis(timeOfSecond), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(touchDevice.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));
    }

    protected void swipeDown(int timeOfSecond) {
        Dimension size = driver.manage().window().getSize();
        int startY = (int) (size.height * 0.2);
        int endY = (int) (size.height * 0.8);
        int x = size.width / 2;

        swipe(x, startY, x, endY, timeOfSecond);


    }

    protected void swipeUp(int timeOfSecond) {
        Dimension size = driver.manage().window().getSize();
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        int x = size.width / 2;

        swipe(x, startY, x, endY, timeOfSecond);

    }

    protected void swipeLeft(int timeOfSeconds) {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.8);
        int endX = (int) (size.width * 0.2);
        int y = size.height / 2;

        swipe(startX, y, endX, y, timeOfSeconds);

    }

    protected void swipeRight(int timeOfSeconds) {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.2);
        int endX = (int) (size.width * 0.8);
        int y = size.height / 2;

        swipe(startX, y, endX, y, timeOfSeconds);
    }

    protected void swipeUpToFindElement(By by, String error_message, int swipeMax) {
        int already_swipe = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swipe > swipeMax) {
                waitForElementForPresent(by, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeUp(200);
            ++already_swipe;
        }
    }

    protected void swipeDownToFindElement(By by, String error_message, int swipeMax) {
        int already_swipe = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swipe > swipeMax) {
                waitForElementForPresent(by, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeDown(200);
            ++already_swipe;
        }
    }

    protected void swipeLeftToFindElement(By by, String error_message, int swipeMax) {
        int already_swipe = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swipe > swipeMax) {
                waitForElementForPresent(by, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeLeft(200);
            ++already_swipe;
        }
    }

    protected void swipeRightToFindElement(By by, String error_message, int swipeMax) {
        int already_swipe = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swipe > swipeMax) {
                waitForElementForPresent(by, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeRight(200);
            ++already_swipe;
        }
    }

    protected void swipeElementToLeft(By by, String error_message) {
        WebElement element = waitForElementForPresent(
                by,
                error_message,
                10);

        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        // Добавляем отступы от краев для более надежного свайпа, так как срабатывает жест системы
        int startX = rightX + 50;    // Начинаем не с самого края
        int endX = leftX - 20;     // Заканчиваем не у самого края

        swipe(startX, middleY, endX, middleY, 150);

    }

    protected void swipeElementToRight(By by, String error_message) {
        WebElement element = waitForElementForPresent(
                by,
                error_message,
                10);

        int leftX = element.getLocation().getX(); // крайняя верхняя левая точка
        int rightX = leftX + element.getSize().getWidth(); // крайняя правя точка
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        // Добавляем отступы от краев для более надежного свайпа, так как срабатывает жест системы
        int startX = leftX + 50;    // Начинаем не с самого края
        int endX = rightX - 20;     // Заканчиваем не у самого края

        swipe(startX, middleY, endX, middleY, 150);

    }

    private int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }

    private void assertElementNotPresent(By by, String error_message) {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements > 0) {
            String default_message = "An element '" + by.toString() + "' supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    private void assertElementPresent(By by, String error_message) {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements == 0) {
            String default_message = "An element '" + by.toString() + "' supposed to be present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    private String waitForElementAndAttribute(By by, String attribute, String error_message, long timeOfSeconds) {
        WebElement element = waitForElementForPresent(
                by,
                error_message,
                timeOfSeconds
        );
        return element.getAttribute(attribute);
    }


}
