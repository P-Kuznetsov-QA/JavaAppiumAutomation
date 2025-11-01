package ui.android;

import io.appium.java_client.AppiumDriver;
import ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {
     static {
         SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Поиск по Википедии')]";
                 SEARCH_INPUT = "id:org.wikipedia:id/search_src_text";
                 SEARCH_CLOSE_BUTTON = "id:org.wikipedia:id/search_close_btn";
                 SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_container']//*[@text='{SUBSTRING}']";
                 SEARCH_RETURN_BUTTON = "xpath://android.widget.ImageButton";
                 SEARCH_EMPTY_RESULT_ELEMENT = "id:org.wikipedia:id/results_text";
                 SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://android.view.ViewGroup[.//*[@text='{TITLE}'] and .//*[@text='{DESCRIPTION}']]";
     }

    public AndroidSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
