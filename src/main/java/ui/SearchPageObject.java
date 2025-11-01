package ui;

import io.appium.java_client.AppiumDriver;

abstract public class SearchPageObject extends MainPageObject{

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CLOSE_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RETURN_BUTTON,
            SEARCH_EMPTY_RESULT_ELEMENT,
            SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL;

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    private static String getResultSearchElementByTitleAndDescription(String title, String description) {
        return SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL.replace("{TITLE}", title).replace("{DESCRIPTION}", description);
    }
    /* TEMPLATES METHODS */

    public void initSearchInput()
    {
        this.waitForElementForPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element", 5);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
    }

    public void waitForCloseButtonToAppear()
    {
        this.waitForElementForPresent(SEARCH_CLOSE_BUTTON,"Cannot find search close button", 5);
    }

    public void waitForCloseButtonToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CLOSE_BUTTON, "Search close button still present", 5);
    }

    public void clickCloseSearch()
    {
        this.waitForElementAndClick(SEARCH_CLOSE_BUTTON, "Cannot find and click search close button", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementForPresent(search_result_xpath, "Cannot find search result -" + search_result_xpath, 15);
    }

    public void waitForSearchResultByTitleAndDescription(String title, String description)
    {
        String search_result_xpath = getResultSearchElementByTitleAndDescription(title, description);
        this.waitForElementForPresent(search_result_xpath, "Cannot find search result by title - '" + title + "' and description - '" + description + "'", 15);
    }

    public void checkContainsWordResultSearch(String substring, String expected_line)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.assertElementContainsText(search_result_xpath, "Search result", expected_line);
    }

    public void openArticleResultSearchWithSubstring(String substring_title)
    {
        String search_result_xpath = getResultSearchElement(substring_title);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click result search " + substring_title, 5);
    }

    public void newTypeSearchLine(String search_line)
    {
        this.waitForElementAndClear(SEARCH_INPUT,"Cannot find and clear search input",5);

        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find search input after return", 5);
    }

    public void returnMainPage()
    {
        this.waitForElementAndClick(SEARCH_RETURN_BUTTON, "Cannot find and click return button", 5);
    }

}
