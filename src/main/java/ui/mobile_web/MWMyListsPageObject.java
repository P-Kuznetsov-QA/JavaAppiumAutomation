package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.MyListsPageObject;

public class MWMyListsPageObject extends MyListsPageObject {
    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@resource-id=\"org.wikipedia:id/item_title\" and @text=\"{FOLDER_NAME}\"]";
        ARTICLE_BY_TITLE_TPL = "xpath://h3[text()='{ARTICLE_TITLE}']";
        REMOVE_FROM_SAVED_BUTTON = "xpath://li[@title='{ARTICLE_TITLE}']//span[contains(@class, 'mf-icon-unStar-progressive')]";
        ARTICLE_BY_DESCRIPTION_TPL = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_description' and @text=\"{ARTICLE_DESCRIPTION}\"]";
    }

    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

