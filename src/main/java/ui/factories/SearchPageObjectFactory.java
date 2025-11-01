package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import ui.SearchPageObject;
import ui.android.AndroidSearchPageObject;
import ui.ios.IOSSearchPageObject;

public class SearchPageObjectFactory {

   public static SearchPageObject get(AppiumDriver driver)
   {
       if (Platform.getInstance().isAndroid()){
           System.out.println("Creating AndroidSearchPageObject");
           return new AndroidSearchPageObject(driver);
       } else {
           System.out.println("Creating IOSSearchPageObject");
           return new IOSSearchPageObject(driver);
       }
   }
}
