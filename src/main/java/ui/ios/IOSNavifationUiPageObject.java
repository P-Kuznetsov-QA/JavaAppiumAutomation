package ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUiPageObject;

public class IOSNavifationUiPageObject extends NavigationUiPageObject {
    static {
        MY_LISTS_LINK = "xpath://*[@text='Мои списки']";
    }

    public IOSNavifationUiPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

