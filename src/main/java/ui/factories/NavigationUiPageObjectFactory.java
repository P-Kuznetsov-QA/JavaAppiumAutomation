package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import ui.NavigationUiPageObject;
import ui.android.AndroidNavigationUiPageObject;
import ui.ios.IOSNavifationUiPageObject;

public class NavigationUiPageObjectFactory {
    public static NavigationUiPageObject get(AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            System.out.println("Creating AndroidNavigationUiPageObject");
            return new AndroidNavigationUiPageObject(driver);
        } else {
            System.out.println("Creating AndroidNavigationUiPageObject");
            return new IOSNavifationUiPageObject(driver);
        }
    }
}
