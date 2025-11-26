package ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject {

    static {
        // на данный момент локаторы ArticlePage неактуальные, так как xcode не поддерживает web view
        TITLE_ARTICLE_TPL = "xpath://*";
        FOOTER_ELEMENT = "xpath://*";
        SAVE_BUTTON = "id://*";
        SAVE_ADD_IN_THE_LIST_BUTTON = "xpath://*";
        CREATE_NEW_LIST_BUTTON = "xpath://*";
        MY_LIST_NAME_INPUT = "xpath://*";
        MY_LIST_OK_BUTTON = "id://*";
        CREATED_LIST = "id://*";
        CREATED_LIST_BY_TITLE_TPL = "xpath://*";
        CLOSE_ARTICLE_BUTTON = "xpath://*";
    }

    public IOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
