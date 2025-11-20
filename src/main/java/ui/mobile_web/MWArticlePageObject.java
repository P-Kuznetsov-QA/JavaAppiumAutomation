package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.ArticlePageObject;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        TITLE_ARTICLE_TPL = "xpath://h1[@id='firstHeading']//span[contains(@class, 'mw-page-title-main') and text()='{TITLE}']";
        FOOTER_ELEMENT = "css:#footer-info";
        SAVE_BUTTON = "css:span.minerva-icon--star";
        REMOVE_SAVE_BUTTON = "css:span.minerva-icon--unStar";
        SAVE_ADD_IN_THE_LIST_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/snackbar_action']";
        CREATE_NEW_LIST_BUTTON = "xpath://*[@text='Создать новый']";
        MY_LIST_NAME_INPUT = "xpath://*[@resource-id='org.wikipedia:id/text_input']";
        MY_LIST_OK_BUTTON = "id:android:id/button1";
        CREATED_LIST = "id:org.wikipedia:id/item_title";
        CREATED_LIST_BY_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title' and @text='\"{TITLE}\"']";
        SEARCH_BUTTON = "css:#searchIcon";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
