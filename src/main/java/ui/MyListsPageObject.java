package ui;

import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsPageObject extends MainPageObject{

    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            REMOVE_FROM_SAVED_BUTTON,
            ARTICLE_BY_DESCRIPTION_TPL;

    public MyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getRemoveButtonByTitle(String article_title)
    {
        return REMOVE_FROM_SAVED_BUTTON.replace("{ARTICLE_TITLE}", article_title);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{ARTICLE_TITLE}", article_title);
    }

    private static String getSavedArticleXpathByDescription(String article_description)
    {
        return ARTICLE_BY_DESCRIPTION_TPL.replace("{ARTICLE_DESCRIPTION}", article_description);
    }

    @Step("Opening folder by name")
    public void openFolderByName(String name_of_folder)
    {
        if (Platform.getInstance().isMobileWeb()){
            return;
        }
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find created folder by name " + name_of_folder,
                5
        );


    }

    @Step("Removing article by swipe")
    public void swipeByArticleToDelete(String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            this.swipeElementToLeft(
                    article_title_xpath,
                    "Cannot find article " + article_title_xpath
            );
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title_xpath);
            this.waitForElementAndClick(remove_locator, "Cannot click button to remove article from save", 10);

        }
        if (Platform.getInstance().isMobileWeb()){
            driver.navigate().refresh();
            String remove_locator = getRemoveButtonByTitle(article_title_xpath);
            waitForElementNotPresent(
                    remove_locator,
                    "Article still present after deletion and refresh",
                    10
            );
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Step("Waiting article will no longer be displayed")
    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(article_title_xpath, "Saved article still present with title " + article_title, 5);
    }

    @Step("Waiting for the article to be displayed")
    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementForPresent(article_title_xpath, "Saved article  present with title " + article_title, 5);
    }

    @Step("Opening the article")
    public void clickArticleTitleToOpen(String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementAndClick(article_title_xpath, "Cannot find and click open article title -" + article_title, 5);
    }

}
