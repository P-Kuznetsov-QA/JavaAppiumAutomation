import lib.CoreTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import ui.ArticlePageObject;
import ui.MainPageObject;
import ui.OnboardingPageObject;
import ui.SearchPageObject;

import java.time.Duration;

public class OtherTest extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp () throws Exception
    {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testOnboardingSwipe() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);

        OnboardingPageObject.clickNextPageOnboarding();
        OnboardingPageObject.swipeLeftToPrimaryPage("Списки для чтения с синхронизацией");
        OnboardingPageObject.swipeLeftToPrimaryPage("Отправлять отчёты об использовании");
        OnboardingPageObject.clickStartOnboarding();

    }

    @Test
    public void testSearch()
    {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.clickSkipOnboarding();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("язык программирования");

    }

    @Test
    public void testSearchInputHasText() {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        ); // из-за более новой версии при запуске приложения открывается onboarding, поэтому требуется дополнительно его пропускать

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );

        MainPageObject.assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Search input",
                "Поиск по Википедии"
        );
    }


    @Test
    public void testSwipeSearchArticle() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Selenium");
        SearchPageObject.openArticleResultSearchWithSubstring("Selenium");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement("Selenium");
        ArticlePageObject.swipeToFooter();

    }



    @Test
    public void testNumberResponsesSearch() {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );

        String searchText = "Дискография Toxis";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                searchText,
                "Cannot find Search input",
                5
        );


        String search_result_locator = "//*[@resource-id='org.wikipedia:id/page_list_item_title']";
        MainPageObject.waitForElementForPresent(
                By.xpath(search_result_locator),
                "Cannot find request " + searchText,
                15
        );

        int amountOfSearchResults = MainPageObject.getAmountOfElements(
                By.xpath(search_result_locator)
        );

        Assert.assertTrue(
                "We found too few results",
                amountOfSearchResults > 0);

    }

    @Test
    public void testEmptyResultSearch() {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );

        String searchText = "прпропропорпро";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                searchText,
                "Cannot find Search input",
                5
        );


        String resultSearch = "//*[@resource-id= 'org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_title']";
        String emptySearch = "//*[@text='Ничего не найдено']";

        MainPageObject.waitForElementForPresent(
                By.xpath(emptySearch),
                "Cannot find text 'Ничего не найдено'",
                10
        );


        MainPageObject.assertElementNotPresent(
                By.xpath(resultSearch),
                "We've found some results by result " + searchText
        );
    }

    @Test
    public void testChangeOrientationSearchResult() {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );
        String search_line = "Java";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Cannot find Search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='Java']"),
                "Cannot find 'Java' in result search by " + search_line,
                15);

        String title_before_rotation = MainPageObject.waitForElementAndAttribute(
                By.xpath("(//android.widget.TextView[@text='Java'])[1]"),
                "text",
                "Cannot find description of article",
                15
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = MainPageObject.waitForElementAndAttribute(
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
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'ПРОПУСТИТЬ')]"),
                "Cannot find Skip onboarding",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
                "Cannot find Search input",
                5
        );
        String search_line = "Java";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Cannot find Search input",
                5
        );

        MainPageObject.waitForElementForPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='Java']"),
                "Cannot find 'Java' in result search by " + search_line,
                15);

        driver.runAppInBackground(Duration.ofSeconds(2));

        MainPageObject.waitForElementForPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='Java']"),
                "Cannot find 'Java' after returning in background",
                15);

    }



}
