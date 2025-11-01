package ui.android;

import io.appium.java_client.AppiumDriver;
import ui.NavigationUiPageObject;

public class AndroidNavigationUiPageObject extends NavigationUiPageObject {

    static {
        MY_LISTS_LINK = "xpath://*[@text='Мои списки']";
    }

    public AndroidNavigationUiPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
