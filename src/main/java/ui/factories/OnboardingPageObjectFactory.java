package ui.factories;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.OnboardingPageObject;
import ui.android.AndroidOnboardingPageObject;
import ui.ios.IOSOnboardingPageObject;


public class OnboardingPageObjectFactory {

    public static OnboardingPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            System.out.println("Creating AndroidOnboardingPageObject");
            return new AndroidOnboardingPageObject(driver);
        } else {
            System.out.println("Creating IOSOnboardingPageObject");
            return new IOSOnboardingPageObject(driver);
        }
    }
}
