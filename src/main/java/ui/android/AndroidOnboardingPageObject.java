package ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.OnboardingPageObject;

public class AndroidOnboardingPageObject extends OnboardingPageObject {
    static {
        SKIP_ONBOARDING_BUTTON = "id:org.wikipedia:id/fragment_onboarding_skip_button";
        NEXT_ONBOARDING_BUTTON = "id:org.wikipedia:id/fragment_onboarding_forward_button";
        DONE_ONBOARDING_BUTTON = "id:org.wikipedia:id/fragment_onboarding_done_button";
        PRIMARY_TEXT_PAGE_1 = "xpath://*[@text='Свободная энциклопедия\n…более, чем на 300 языках']";
        PRIMARY_TEXT_PAGE_2 = "xpath://*[@text='Новые способы исследований']";
        PRIMARY_TEXT_PAGE_3 = "xpath://*[@text='Списки для чтения с синхронизацией']";
        PRIMARY_TEXT_PAGE_4 = "xpath://*[@text='Отправлять отчёты об использовании']";
        PRIMARY_TEXT_PAGE_BY_TITLE_TPL = "xpath://*[contains(@text,'{TITLE}')]";
        SECONDARY_TEXT_PAGE_BY_TEXT_TPL = "xpath://*[contains(@text, \"{TEXT}\")]";
        STEP_ADD_OR_REMOVE = "xpath://*[@text=\"ДОБАВИТЬ ИЛИ УДАЛИТЬ ЯЗЫК\"]";
        STEP_SEND_USAGE_REPORTS = "id:org.wikipedia:id/switchView";
    }

    public AndroidOnboardingPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
