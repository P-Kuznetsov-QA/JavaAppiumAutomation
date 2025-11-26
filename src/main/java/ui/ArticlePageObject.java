package ui;

import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObject extends MainPageObject {
    protected static String
            TITLE_ARTICLE_TPL,
            FOOTER_ELEMENT,
            SAVE_BUTTON,
            REMOVE_SAVE_BUTTON,
            SAVE_ADD_IN_THE_LIST_BUTTON,
            CREATE_NEW_LIST_BUTTON,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CREATED_LIST,
            CREATED_LIST_BY_TITLE_TPL,
            CLOSE_ARTICLE_BUTTON,
            SEARCH_BUTTON;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getTitleArticlePage(String title_element) {
        return TITLE_ARTICLE_TPL.replace("{TITLE}", title_element);
    }
    /* TEMPLATES METHODS */

    @Step("Waiting for the title of the article")
    public void waitForTitleElement(String title_element) {
        String title_page_xpath = getTitleArticlePage(title_element);
        this.waitForElementForPresent(title_page_xpath, "Cannot find article title on page", 15);
    }

//    public String getArticleTitle()
//    {
//        WebElement title_element = waitForTitleElement();
//        if (Platform.getInstance().isAndroid()){
//            return title_element.getAttribute("text");
//        } else if (Platform.getInstance().isIOS()){
//            return title_element.getAttribute("name");
//        } else {
//            return title_element.getText();
//        }
//    }

    @Step("Swiping article to the footer page")
    public void swipeToFooter() {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find the and of article", 15);
        } else {
            this.scrollWebPageTitleElementNotVisible(FOOTER_ELEMENT, "Cannot find the end of article", 15);
        }
    }
    @Step("Saving article to My List")
    public void addArticleToMyList(String name_of_folder) {
        if (Platform.getInstance().isMobileWeb()) {
            this.removeArticleFromSavedIfItAdded();
        }
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find button 'save'",
                5
        );

        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {

            this.waitForElementAndClick(
                    SAVE_ADD_IN_THE_LIST_BUTTON,
                    "Cannot find button 'Add in the List'",
                    5
            );


            this.waitForElementAndClick(
                    CREATE_NEW_LIST_BUTTON,
                    "Cannot find button 'Создать новый'",
                    5
            );


            this.waitForElementAndSendKeys(
                    MY_LIST_NAME_INPUT,
                    name_of_folder,
                    "Cannot find text input",
                    5
            );

            this.waitForElementAndClick(
                    MY_LIST_OK_BUTTON,
                    "Cannot find button 'OK'",
                    5
            );
        }
    }

    @Step("Saving an article to the created my list")
    public void addNewArticleToAlreadyCreatedMyList() {
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            this.waitForElementAndClick(
                    SAVE_BUTTON,
                    "Cannot find button 'save'",
                    5
            );

            this.waitForElementAndClick(
                    SAVE_ADD_IN_THE_LIST_BUTTON,
                    "Cannot find button 'Add in the List'",
                    5
            );

            /* можно улучшить с помощью TEMPLATES METHODS и  */
            this.waitForElementAndClick(
                    CREATED_LIST,
                    "Cannot find title new create List",
                    5
            );
        } else {
            this.removeArticleFromSavedIfItAdded();
            this.waitForElementAndClick(
                    SAVE_BUTTON,
                    "Cannot find button 'save'",
                    5
            );
        }
    }
    @Step("Removing an article from the Mobile Web ")
    public void removeArticleFromSavedIfItAdded() {
        if (this.isElementPresent(REMOVE_SAVE_BUTTON)) {
            this.waitForElementAndClick(REMOVE_SAVE_BUTTON, "Cannot click button to remove an article from saved", 1);
            this.waitForElementForPresent(SAVE_BUTTON, "Cannot find button to add an article to saved list after removing it from this list before", 5);
        }
    }

    @Step("Closing the article")
    public void closeArticle() {
        this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON, "Cannot find and click close article button", 5);
    }

    @Step("Opening the article search")
    public void openSearchInput() {
        this.waitForElementAndClick(SEARCH_BUTTON, "Cannot find and click open search button", 5);
    }
    @Step("Checking the opening of the article title")
    public void assertTitlePresent(String title_element) {
        String title_page_xpath = getTitleArticlePage(title_element);
        this.assertElementPresent(
                title_page_xpath,
                "The title article is not displayed"
        );
    }

    @Step("Checking the display of the 'Save' button")
    public boolean isSaveButtonPresent() {
        return isElementPresent(SAVE_BUTTON);
    }

    @Step("Checking the display of the 'Remove' button")
    public boolean isRemoveSaveButtonPresent() {
        return isElementPresent(REMOVE_SAVE_BUTTON);
    }

}
