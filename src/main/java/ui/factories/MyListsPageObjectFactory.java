package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.MyListsPageObject;
import ui.android.AndroidMyListsPageObject;
import ui.ios.IOSMyListsPageObject;
import ui.ios.IOSNavifationUiPageObject;
import ui.mobile_web.MWMyListsPageObject;
import ui.mobile_web.MWNavigationUiPageObject;

public class MyListsPageObjectFactory {

    public static MyListsPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            System.out.println("Creating AndroidMyListsPageObject");
            return new AndroidMyListsPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            System.out.println("Creating IOSMyListsPageObject");
            return new IOSMyListsPageObject(driver);
        } else {
            System.out.println("Creating MWMyListsPageObject");
            return new MWMyListsPageObject(driver);
        }
    }
}
