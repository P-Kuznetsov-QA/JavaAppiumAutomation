package ui.ios;

import io.appium.java_client.AppiumDriver;
import ui.NavigationUiPageObject;

public class IOSNavifationUiPageObject extends NavigationUiPageObject {
    static {
        MY_LISTS_LINK = "xpath://*[@text='Мои списки']";
    }

    public IOSNavifationUiPageObject (AppiumDriver driver)
    {
        super(driver);
    }
}

