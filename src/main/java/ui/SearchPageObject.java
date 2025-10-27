package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
            SEARCH_INIT_ELEMENT = "//*[contains(@text,'Поиск по Википедии')]",
            SEARCH_INPUT = "org.wikipedia:id/search_src_text",
            SEARCH_CLOSE_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/search_results_container']//*[@text='{SUBSTRING}']",
            SEARCH_RETURN_BUTTON = "//android.widget.ImageButton";

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }


    /* TEMPLATES METHODS */

    public void initSearchInput()
    {
        this.waitForElementForPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element", 5);
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
    }

    public void waitForCloseButtonToAppear()
    {
        this.waitForElementForPresent(By.id(SEARCH_CLOSE_BUTTON),"Cannot find search close button", 5);
    }

    public void waitForCloseButtonToDisappear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_CLOSE_BUTTON), "Search close button still present", 5);
    }

    public void clickCloseSearch()
    {
        this.waitForElementAndClick(By.id(SEARCH_CLOSE_BUTTON), "Cannot find and click search close button", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.id(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementForPresent(By.xpath(search_result_xpath), "Cannot find search result", 15);
    }



    public void checkContainsWordResultSearch(String substring, String expected_line)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.assertElementContainsText(By.xpath(search_result_xpath), "Search result", expected_line);
    }

    public void openArticleResultSearchWithSubstring(String substring_title)
    {
        String search_result_xpath = getResultSearchElement(substring_title);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click result search " + substring_title, 5);
    }

    public void newTypeSearchLine(String search_line)
    {
        this.waitForElementAndClear(By.id(SEARCH_INPUT),"Cannot find and clear search input",5);

        this.waitForElementAndSendKeys(By.id(SEARCH_INPUT), search_line, "Cannot find search input after return", 5);
    }

    public void returnMainPage()
    {
        this.waitForElementAndClick(By.xpath(SEARCH_RETURN_BUTTON), "Cannot find and click return button", 5);
    }

}
