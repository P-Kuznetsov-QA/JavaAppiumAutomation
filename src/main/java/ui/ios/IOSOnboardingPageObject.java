package ui.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.OnboardingPageObject;

public class IOSOnboardingPageObject extends OnboardingPageObject {
    static {
        SKIP_ONBOARDING_BUTTON = "xpath://XCUIElementTypeButton[@name='Пропустить']";
        NEXT_ONBOARDING_BUTTON = "xpath://XCUIElementTypeButton[@name='Далее']";
        DONE_ONBOARDING_BUTTON = "xpath://XCUIElementTypeButton[@name='Начать']";
        PRIMARY_TEXT_PAGE_1 = "xpath://XCUIElementTypeStaticText[contains(@name, 'Свободная энциклопедия')]";
        PRIMARY_TEXT_PAGE_2 = "xpath://XCUIElementTypeStaticText[contains(@name, 'Новые способы изучения')]";
        PRIMARY_TEXT_PAGE_3 = "xpath://XCUIElementTypeStaticText[contains(@name, 'Искать на почти 300 языках')]";
        PRIMARY_TEXT_PAGE_4 = "xpath://XCUIElementTypeStaticText[contains(@name, 'Помогите сделать это приложение лучше')]";
        PRIMARY_TEXT_PAGE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name, \"{TITLE}\")]";
        SECONDARY_TEXT_PAGE_BY_TEXT_TPL = "xpath://XCUIElementTypeStaticText[@name=\"{TEXT}\"]";
        STEP_ADD_OR_REMOVE = "xpath://XCUIElementTypeStaticText[@name=\"Узнать подробнее о Википедии\"]";
        STEP_SEND_USAGE_REPORTS = "xpath://XCUIElementTypeButton[@name=\"Узнать подробнее о сборе данных\"]";
    }

    public IOSOnboardingPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
