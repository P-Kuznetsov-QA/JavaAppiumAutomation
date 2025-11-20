package ui.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.MyListsPageObject;

public class AndroidMyListsPageObject extends MyListsPageObject {

    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TPL = "xpath://android.widget.TextView[@resource-id=\"org.wikipedia:id/page_list_item_title\" and @text=\"{ARTICLE_TITLE}\"]";
        ARTICLE_BY_DESCRIPTION_TPL = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_description' and @text=\"{ARTICLE_DESCRIPTION}\"]";
    }

    public AndroidMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
