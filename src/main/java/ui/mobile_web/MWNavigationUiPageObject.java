package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUiPageObject;

public class MWNavigationUiPageObject extends NavigationUiPageObject {
    static {
        MY_LISTS_LINK = "css:a.menu__item--watchlist";
        OPEN_NAVIGATION = "css:label[for='main-menu-input']";
    }

    public MWNavigationUiPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

