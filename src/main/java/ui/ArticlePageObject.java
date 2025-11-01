package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticlePageObject extends MainPageObject
{
    protected static String
            TITLE_ARTICLE_TPL,
            FOOTER_ELEMENT,
            SAVE_BUTTON,
            SAVE_ADD_IN_THE_LIST_BUTTON,
            CREATE_NEW_LIST_BUTTON,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CREATED_LIST,
            CREATED_LIST_BY_TITLE_TPL,
            CLOSE_ARTICLE_BUTTON;

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getTitleArticlePage(String title_element)
    {
        return TITLE_ARTICLE_TPL.replace("{TITLE}", title_element);
    }
    /* TEMPLATES METHODS */


    public void waitForTitleElement(String title_element)
    {
        String title_page_xpath = getTitleArticlePage(title_element);
        this.waitForElementForPresent(title_page_xpath, "Cannot find article title on page", 15);
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find the and of article", 15);
    }

    public void addArticleToMyList(String name_of_folder)
    {
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

    public void addNewArticleToAlreadyCreatedMyList()
    {
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
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON,"Cannot find and click close article button",5);
    }

    public void assertTitlePresent(String title_element)
    {
        String title_page_xpath = getTitleArticlePage(title_element);
        this.assertElementPresent(
                title_page_xpath,
                "The title article is not displayed"
        );
    }

}
