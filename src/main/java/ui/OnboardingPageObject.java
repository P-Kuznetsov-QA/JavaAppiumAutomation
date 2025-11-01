package ui;

import io.appium.java_client.AppiumDriver;

abstract public class OnboardingPageObject extends MainPageObject {

    protected static String
            SKIP_ONBOARDING_BUTTON,
            NEXT_ONBOARDING_BUTTON,
            DONE_ONBOARDING_BUTTON,
            PRIMARY_TEXT_PAGE_1,
            PRIMARY_TEXT_PAGE_2,
            PRIMARY_TEXT_PAGE_3,
            PRIMARY_TEXT_PAGE_4,
            PRIMARY_TEXT_PAGE_BY_TITLE_TPL,
            SECONDARY_TEXT_PAGE_BY_TEXT_TPL,
            STEP_ADD_OR_REMOVE,
            STEP_SEND_USAGE_REPORTS;



    public OnboardingPageObject (AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getTitleOnboardingPage(String title)
    {
        return PRIMARY_TEXT_PAGE_BY_TITLE_TPL.replace("{TITLE}", title);
    }

    private static String getSecondaryTextPageByTextTpl(String text)
    {
        return SECONDARY_TEXT_PAGE_BY_TEXT_TPL.replace("{TEXT}", text);
    }
    /* TEMPLATES METHODS */

    public void waitForFirstScreen()
    {
        this.waitForElementForPresent(PRIMARY_TEXT_PAGE_1, "", 5);
    }

    public void waitForSecondScreen()
    {
        this.waitForElementForPresent(PRIMARY_TEXT_PAGE_2, "", 5);
    }

    public void waitForThirdScreen()
    {
        this.waitForElementForPresent(PRIMARY_TEXT_PAGE_3, "", 5);
    }

    public void waitForFourthScreen()
    {
        this.waitForElementForPresent(PRIMARY_TEXT_PAGE_4, "", 5);
    }

    public void waitForTitleOnboardingPage(String title)
    {
        String title_page_xpath = getSecondaryTextPageByTextTpl(title);
        this.waitForElementForPresent(title_page_xpath, "Cannot find title text Onboarding page", 5);
    }

    public void waitForDescriptionOnboardingPage(String text)
    {
        String description_page_xpath = getSecondaryTextPageByTextTpl(text);
        this.waitForElementForPresent(description_page_xpath, "Cannot find description text Onboarding page", 5);
    }
    public void clickSkipOnboarding()
    {
        this.waitForElementAndClick(SKIP_ONBOARDING_BUTTON, "Cannot find and click skip onboarding element " + SKIP_ONBOARDING_BUTTON, 5);
    }

    public void clickNextPageOnboarding()
    {
        this.waitForElementAndClick(NEXT_ONBOARDING_BUTTON, "Cannot find and click skip onboarding element " + NEXT_ONBOARDING_BUTTON, 5);
    }

    public void clickStartOnboarding()
    {
        this.waitForElementAndClick(DONE_ONBOARDING_BUTTON, "Cannot find and click start Onboarding " + DONE_ONBOARDING_BUTTON, 5);
    }

    public void swipeLeftToSecondScreen()
    {
        this.swipeLeftToFindElement(PRIMARY_TEXT_PAGE_2, "Cannot find primary text 2 page", 2);
    }

    public void swipeLeftToThirdScreen()
    {
        this.swipeLeftToFindElement(PRIMARY_TEXT_PAGE_3, "Cannot find primary 3 text page", 2);
    }

    public void swipeLeftToFourScreen()
    {
        this.swipeLeftToFindElement(PRIMARY_TEXT_PAGE_4, "Cannot find primary 4 text page", 2);
    }

    public void swipeLeftToPrimaryPageByTitle(String title)
    {
        String title_page_xpath = getTitleOnboardingPage(title);
        this.swipeLeftToFindElement(title_page_xpath, "Cannot find primary text page", 2);
    }

    public void swipeRightToFirstScreen()
    {
        this.swipeRightToFindElement(PRIMARY_TEXT_PAGE_1, "Cannot find primary text 1 page", 2);
    }

    public void swipeRightToSecondScreen()
    {
        this.swipeRightToFindElement(PRIMARY_TEXT_PAGE_2, "Cannot find primary text 1 page", 2);
    }

    public void swipeRightToThirdScreen()
    {
        this.swipeRightToFindElement(PRIMARY_TEXT_PAGE_3, "Cannot find primary text 1 page", 2);
    }

    public void swipeRightPrimaryPage(String title)
    {
        String title_page_xpath = getTitleOnboardingPage(title);
        this.swipeRightToFindElement(title_page_xpath, "Cannot find primary text page", 2);
    }

    public void waitForAddOrRemoveLanguage()
    {
        this.waitForElementForPresent(STEP_ADD_OR_REMOVE,"Cannot find 'ДОБАВИТЬ ИЛИ УДАЛИТЬ ЯЗЫК' link", 5);
    }

    public void waitForSendUsageReports()
    {
        this.waitForElementForPresent(STEP_SEND_USAGE_REPORTS, "Cannot find 'Отправлять отчёты об использовании'", 5);
    }


}
