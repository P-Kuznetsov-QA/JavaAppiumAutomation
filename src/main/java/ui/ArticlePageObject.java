package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticlePageObject extends MainPageObject
{
    private static final String
            TITLE_ARTICLE_TPL = "//*[@text=\"{TITLE}\"]",
          FOOTER_ELEMENT = "//*[@content-desc='Просмотреть статью в браузере']",
          SAVE_BUTTON = "org.wikipedia:id/article_menu_bookmark",
          SAVE_ADD_IN_THE_LIST_BUTTON = "//*[@resource-id='org.wikipedia:id/snackbar_action']",
          CREATE_NEW_LIST_BUTTON = "//*[@text='Создать новый']",
          MY_LIST_NAME_INPUT = "//*[@resource-id='org.wikipedia:id/text_input']",
          MY_LIST_OK_BUTTON = "android:id/button1",
          CREATED_LIST_BY_TITLE_TPL = "//*[@resource-id='org.wikipedia:id/item_title' and @text='\"{TITLE}\"']",
          CLOSE_ARTICLE_BUTTON = "//*[@content-desc='Перейти вверх']";






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
        this.waitForElementForPresent(By.xpath(title_page_xpath), "Cannot find article title on page", 15);
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(By.xpath(FOOTER_ELEMENT), "Cannot find the and of article", 15);
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.id(SAVE_BUTTON),
                "Cannot find button 'save'",
                5
        );

        this.waitForElementAndClick(
                By.xpath(SAVE_ADD_IN_THE_LIST_BUTTON),
                "Cannot find button 'Add in the List'",
                5
        );


        this.waitForElementAndClick(
                By.xpath(CREATE_NEW_LIST_BUTTON),
                "Cannot find button 'Создать новый'",
                5
        );


        this.waitForElementAndSendKeys(
                By.xpath(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot find text input",
                5
        );

            this.waitForElementAndClick(
                By.id(MY_LIST_OK_BUTTON),
                "Cannot find button 'OK'",
                5
        );
    }

    public void addNewArticleToAlreadyCreatedMyList()
    {
        this.waitForElementAndClick(
                By.id(SAVE_BUTTON),
                "Cannot find button 'save'",
                5
        );

        this.waitForElementAndClick(
                By.xpath(SAVE_ADD_IN_THE_LIST_BUTTON),
                "Cannot find button 'Add in the List'",
                5
        );

        /* можно улучшить с помощью TEMPLATES METHODS и  */
        this.waitForElementAndClick(
                By.id("org.wikipedia:id/item_title"),
                "Cannot find title new create List",
                5
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(By.xpath(CLOSE_ARTICLE_BUTTON),"Cannot find and click close article button",5
        );
    }

    public void assertTitlePresent(String title_element)
    {
        String title_page_xpath = getTitleArticlePage(title_element);
        this.assertElementPresent(
                By.xpath(title_page_xpath),
                "The title article is not displayed"
        );
    }

}
