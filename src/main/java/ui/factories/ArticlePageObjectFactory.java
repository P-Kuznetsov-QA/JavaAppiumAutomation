package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import ui.ArticlePageObject;
import ui.OnboardingPageObject;
import ui.android.AndroidArticlePageObject;
import ui.android.AndroidOnboardingPageObject;
import ui.ios.IOSArticlePageObject;
import ui.ios.IOSOnboardingPageObject;

public class ArticlePageObjectFactory {

    public static ArticlePageObject get(AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            System.out.println("Creating AndroidArticlePageObject");
            return new AndroidArticlePageObject(driver);
        } else  {
            System.out.println("Creating IOSArticlePageObject");
            return new IOSArticlePageObject(driver);
        }
    }
}
