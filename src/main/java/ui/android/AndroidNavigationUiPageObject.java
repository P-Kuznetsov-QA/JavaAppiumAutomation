package ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUiPageObject;

public class AndroidNavigationUiPageObject extends NavigationUiPageObject {

    static {
        MY_LISTS_LINK = "xpath://*[@text='Мои списки']";
    }

    public AndroidNavigationUiPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
