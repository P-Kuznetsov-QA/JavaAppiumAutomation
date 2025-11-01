package ui;

import io.appium.java_client.AppiumDriver;

public class NavigationUiPageObject extends MainPageObject{

    protected static String
            MY_LISTS_LINK = "xpath://*[@text='Мои списки']";

    public NavigationUiPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyLists()
    {
        this.waitForElementAndClick(MY_LISTS_LINK, "Cannot find navigation button to My Lists", 5);
    }
}
