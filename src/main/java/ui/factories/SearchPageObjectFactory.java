package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.SearchPageObject;
import ui.android.AndroidSearchPageObject;
import ui.ios.IOSSearchPageObject;
import ui.mobile_web.MWSearchPageObject;

public class SearchPageObjectFactory {

    public static SearchPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            System.out.println("Creating AndroidSearchPageObject");
            return new AndroidSearchPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            System.out.println("Creating IOSSearchPageObject");
            return new IOSSearchPageObject(driver);
        } else {
            System.out.println("Creating MWSearchPageObject");
            return new MWSearchPageObject(driver);
        }
    }
}
