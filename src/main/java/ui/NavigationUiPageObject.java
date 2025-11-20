package ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUiPageObject extends MainPageObject {

    protected static String
            MY_LISTS_LINK,
            OPEN_NAVIGATION;

    public NavigationUiPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void openNavigation() {
        this.waitForElementAndClickWithJS(
                OPEN_NAVIGATION,
                "Cannot find navigation menu button",
                11
        );
    }

    public void clickMyLists() {
        if (Platform.getInstance().isMobileWeb()) {
            openNavigation();
            WebElement myListsLink = waitForElementForPresent(
                    MY_LISTS_LINK,
                    "Cannot find My lists link",
                    5
            );
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", myListsLink);
        } else {
            this.waitForElementAndClick(MY_LISTS_LINK, "Cannot find navigation button to My Lists", 5);
        }

    }


}
