package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject{

    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            ARTICLE_BY_DESCRIPTION_TPL;

    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{ARTICLE_TITLE}", article_title);
    }

    private static String getSavedArticleXpathByDescription(String article_description)
    {
        return ARTICLE_BY_DESCRIPTION_TPL.replace("{ARTICLE_DESCRIPTION}", article_description);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find created folder by name " + name_of_folder,
                5
        );
    }

    public void swipeByArticleToDelete(String article_description)
    {
        String article_description_xpath = getSavedArticleXpathByDescription(article_description);
        this.swipeElementToLeft(
                article_description_xpath,
                "Cannot find article " + article_description
        );
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(article_title_xpath, "Saved article still present with title " + article_title, 5);
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementForPresent(article_title_xpath, "Saved article still present with title " + article_title, 5);
    }

    public void clickArticleTitleToOpen(String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementAndClick(article_title_xpath, "Saved article still present with title " + article_title, 5);
    }

}
