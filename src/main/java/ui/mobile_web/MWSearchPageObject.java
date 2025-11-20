package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.SearchPageObject;

public class MWSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "css:#searchIcon";
        SEARCH_INPUT = "css:header.cdx-dialog__header input[name='search']"; // "xpath://XCUIElementTypeSearchField[@name="Поиск по Википедии"]"
        SEARCH_CLOSE_BUTTON = "css:span.cdx-text-input__clear-icon";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://li[contains(@class, 'cdx-menu-item--enabled')]//bdi[contains(text(), '{SUBSTRING}')]";
        SEARCH_RETURN_BUTTON = "css:button[aria-label='Закрыть окно поиска']";
        SEARCH_MAIN_PAGE = "css:.branding-box > a";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:span.cdx-typeahead-search__search-footer__text";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://li[contains(@class, 'cdx-menu-item--enabled')]" +
                "[.//bdi[text()='{TITLE}'] and .//bdi[contains(text(), '{DESCRIPTION}')]]";
    }

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
