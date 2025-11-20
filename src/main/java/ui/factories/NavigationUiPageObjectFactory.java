package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUiPageObject;
import ui.android.AndroidNavigationUiPageObject;
import ui.ios.IOSNavifationUiPageObject;
import ui.ios.IOSSearchPageObject;
import ui.mobile_web.MWNavigationUiPageObject;
import ui.mobile_web.MWSearchPageObject;

public class NavigationUiPageObjectFactory {
    public static NavigationUiPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            System.out.println("Creating AndroidNavigationUiPageObject");
            return new AndroidNavigationUiPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            System.out.println("Creating IOSNavigationUiPageObject");
            return new IOSNavifationUiPageObject(driver);
        } else {
            System.out.println("Creating MWNavigationUiPageObject");
            return new MWNavigationUiPageObject(driver);
        }
    }
}
