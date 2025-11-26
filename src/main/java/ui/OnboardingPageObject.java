package ui;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

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



    public OnboardingPageObject (RemoteWebDriver driver)
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

    @Step("Waiting primary text first screen onboarding")
    public void waitForFirstScreen()
    {
        this.waitForElementForPresent(PRIMARY_TEXT_PAGE_1, "Cannot find primary text first screen onboarding", 5);
    }

    @Step("Waiting primary text second screen onboarding")
    public void waitForSecondScreen()
    {
        this.waitForElementForPresent(PRIMARY_TEXT_PAGE_2, "Cannot find primary text second screen onboarding", 5);
    }

    @Step("Waiting primary text third screen onboarding")
    public void waitForThirdScreen()
    {
        this.waitForElementForPresent(PRIMARY_TEXT_PAGE_3, "Cannot find primary text third screen onboarding", 5);
    }

    @Step("Waiting primary text four screen onboarding")
    public void waitForFourthScreen()
    {
        this.waitForElementForPresent(PRIMARY_TEXT_PAGE_4, "Cannot find primary text four screen onboarding", 5);
    }

    @Step("Waiting '{title}' Onboarding page")
    public void waitForTitleOnboardingPage(String title)
    {
        String title_page_xpath = getSecondaryTextPageByTextTpl(title);
        this.waitForElementForPresent(title_page_xpath, "Cannot find title text Onboarding page", 5);
    }
    @Step("Waiting title Onboarding page is not displayed")
    public void waitForDescriptionOnboardingPage(String text)
    {
        String description_page_xpath = getSecondaryTextPageByTextTpl(text);
        this.waitForElementForPresent(description_page_xpath, "Cannot find description text Onboarding page", 5);
    }
    @Step("Clicking 'Skip' button")
    public void clickSkipOnboarding()
    {
        this.waitForElementAndClick(SKIP_ONBOARDING_BUTTON, "Cannot find and click skip onboarding element " + SKIP_ONBOARDING_BUTTON, 5);
    }
    @Step("Clicking 'Next' button")
    public void clickNextPageOnboarding()
    {
        this.waitForElementAndClick(NEXT_ONBOARDING_BUTTON, "Cannot find and click skip onboarding element " + NEXT_ONBOARDING_BUTTON, 5);
    }
    @Step("Clicking 'Start' button")
    public void clickStartOnboarding()
    {
        this.waitForElementAndClick(DONE_ONBOARDING_BUTTON, "Cannot find and click start Onboarding " + DONE_ONBOARDING_BUTTON, 5);
    }
    @Step("Left swiping to second screen onboarding")
    public void swipeLeftToSecondScreen()
    {
        this.swipeLeftToFindElement(PRIMARY_TEXT_PAGE_2, "Cannot find primary text 2 page", 2);
    }
    @Step("Left swiping to third screen onboarding")
    public void swipeLeftToThirdScreen()
    {
        this.swipeLeftToFindElement(PRIMARY_TEXT_PAGE_3, "Cannot find primary 3 text page", 2);
    }
    @Step("Left swiping to four screen onboarding")
    public void swipeLeftToFourScreen()
    {
        this.swipeLeftToFindElement(PRIMARY_TEXT_PAGE_4, "Cannot find primary 4 text page", 2);
    }

    @Step("Left swiping the onboarding page with the '{title}'")
    public void swipeLeftToPrimaryPageByTitle(String title)
    {
        String title_page_xpath = getTitleOnboardingPage(title);
        this.swipeLeftToFindElement(title_page_xpath, "Cannot find primary text page", 2);
    }
    @Step("Right swiping to first screen onboarding")
    public void swipeRightToFirstScreen()
    {
        this.swipeRightToFindElement(PRIMARY_TEXT_PAGE_1, "Cannot find primary text 1 page", 2);
    }
    @Step("Right swiping to second screen onboarding")
    public void swipeRightToSecondScreen()
    {
        this.swipeRightToFindElement(PRIMARY_TEXT_PAGE_2, "Cannot find primary text 1 page", 2);
    }
    @Step("Right swiping to third screen onboarding")
    public void swipeRightToThirdScreen()
    {
        this.swipeRightToFindElement(PRIMARY_TEXT_PAGE_3, "Cannot find primary text 1 page", 2);
    }
    @Step("Right swiping the onboarding page with the '{title}'")
    public void swipeRightPrimaryPage(String title)
    {
        String title_page_xpath = getTitleOnboardingPage(title);
        this.swipeRightToFindElement(title_page_xpath, "Cannot find primary text page", 2);
    }
    @Step("Wait element by 'Add or Remove language'")
    public void waitForAddOrRemoveLanguage()
    {
        this.waitForElementForPresent(STEP_ADD_OR_REMOVE,"Cannot find 'ДОБАВИТЬ ИЛИ УДАЛИТЬ ЯЗЫК' link", 5);
    }

    @Step("Wait element by 'Send usage reports'")
    public void waitForSendUsageReports()
    {
        this.waitForElementForPresent(STEP_SEND_USAGE_REPORTS, "Cannot find 'Отправлять отчёты об использовании'", 5);
    }
}
