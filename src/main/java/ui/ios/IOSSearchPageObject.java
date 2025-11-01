package ui.ios;

import io.appium.java_client.AppiumDriver;
import ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "id:Поиск по Википедии";
        SEARCH_INPUT = "id:Поиск по Википедии"; // "xpath://XCUIElementTypeSearchField[@name="Поиск по Википедии"]"
        SEARCH_CLOSE_BUTTON = "xpath://XCUIElementTypeButton[@name=\"Очистить текст\"]";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[@name=\"{SUBSTRING}\"]";
        SEARCH_RETURN_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Отменить']";
        SEARCH_EMPTY_RESULT_ELEMENT = "id:Ничего не найдено";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://*[@name='{TITLE}' and /*[@value='{DESCRIPTION}']";
    }

    public IOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

}
