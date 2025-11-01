package ui.android;

import io.appium.java_client.AppiumDriver;
import ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
        TITLE_ARTICLE_TPL = "xpath://*[@text=\"{TITLE}\"]";
        FOOTER_ELEMENT = "xpath://*[@content-desc='Просмотреть статью в браузере']";
        SAVE_BUTTON = "id:org.wikipedia:id/article_menu_bookmark";
        SAVE_ADD_IN_THE_LIST_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/snackbar_action']";
        CREATE_NEW_LIST_BUTTON = "xpath://*[@text='Создать новый']";
        MY_LIST_NAME_INPUT = "xpath://*[@resource-id='org.wikipedia:id/text_input']";
        MY_LIST_OK_BUTTON = "id:android:id/button1";
        CREATED_LIST = "id:org.wikipedia:id/item_title";
        CREATED_LIST_BY_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title' and @text='\"{TITLE}\"']";
        CLOSE_ARTICLE_BUTTON = "xpath://*[@content-desc='Перейти вверх']";
    }

    public AndroidArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
