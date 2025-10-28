package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUi extends MainPageObject{

    private static final String
            MY_LISTS_LINK = "xpath://*[@text='Мои списки']";

    public NavigationUi(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyLists()
    {
        this.waitForElementAndClick(MY_LISTS_LINK, "Cannot find navigation button to My Lists", 5);
    }
}
