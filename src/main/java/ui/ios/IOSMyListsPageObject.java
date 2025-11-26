package ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.MyListsPageObject;

public class IOSMyListsPageObject extends MyListsPageObject {

    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@resource-id=\"org.wikipedia:id/item_title\" and @text=\"{FOLDER_NAME}\"]";
        ARTICLE_BY_TITLE_TPL = "xpath://android.widget.TextView[@resource-id=\"org.wikipedia:id/page_list_item_title\" and @text=\"{ARTICLE_TITLE}\"]";
        ARTICLE_BY_DESCRIPTION_TPL = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_description' and @text=\"{ARTICLE_DESCRIPTION}\"]";
    }

    public IOSMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
