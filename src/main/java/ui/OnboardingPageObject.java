package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class OnboardingPageObject extends MainPageObject {

    private static final String
            SKIP_ONBOARDING_BUTTON = "id:org.wikipedia:id/fragment_onboarding_skip_button",
            SKIP_ONBOARDING_IOS_BUTTON = "xpath://*[@name='Пропустить']",
            NEXT_ONBOARDING_BUTTON = "id:org.wikipedia:id/fragment_onboarding_forward_button",
            NEXT_ONBOARDING_IOS_BUTTON = "xpath://*[@name='Далее']",
            DONE_ONBOARDING_BUTTON = "id:org.wikipedia:id/fragment_onboarding_done_button",
            DONE_ONBOARDING_IOS_BUTTON = "xpath://*[@name='Начать']",
            PRIMARY_TEXT_PAGE_BY_TITLE_TPL = "xpath://*[contains(@text, \"{TITLE}\")]",
            SECONDARY_TEXT_PAGE = "id:org.wikipedia:id/secondaryTextView";


    public OnboardingPageObject (AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getTitleOnboardingPage(String title)
    {
        return PRIMARY_TEXT_PAGE_BY_TITLE_TPL.replace("{TITLE}", title);
    }
    /* TEMPLATES METHODS */

    public void clickSkipOnboarding()
    {
        this.waitForElementAndClick(SKIP_ONBOARDING_BUTTON, "Cannot find and click skip onboarding element", 5);
    }

    public void clickSkipOnboardingIOS()
    {
        this.waitForElementAndClick(SKIP_ONBOARDING_IOS_BUTTON, "Cannot find and click skip onboarding element", 5);
    }

    public void clickNextPageOnboarding()
    {
        this.waitForElementAndClick(NEXT_ONBOARDING_BUTTON, "Cannot find and click skip onboarding element", 5);
    }

    public void clickNextPageOnboardingIOS()
    {
        this.waitForElementAndClick(NEXT_ONBOARDING_IOS_BUTTON, "Cannot find and click skip onboarding element", 5);
    }

    public void clickStartOnboarding()
    {
        this.waitForElementAndClick(DONE_ONBOARDING_BUTTON, "Cannot find and click start Onboarding", 5);
    }

    public void clickStartOnboardingIOS()
    {
        this.waitForElementAndClick(DONE_ONBOARDING_IOS_BUTTON, "Cannot find and click start Onboarding", 5);
    }

    public void swipeLeftToPrimaryPage(String title)
    {
        String title_page_xpath = getTitleOnboardingPage(title);
        this.swipeLeftToFindElement(title_page_xpath, "Cannot find primary text page", 2);
    }


}
