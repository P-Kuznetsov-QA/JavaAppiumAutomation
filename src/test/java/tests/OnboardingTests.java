package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import org.junit.Test;
import ui.OnboardingPageObject;
import ui.factories.OnboardingPageObjectFactory;

public class OnboardingTests extends CoreTestCase {

    @Test
    @DisplayName("Start onboarding button")
    @Description("We check the full flow of onboarding by clicking on the start button")
    public void testPassOnboarding() {
        if (Platform.getInstance().isMobileWeb()){
            return;
        }
        OnboardingPageObject onboardingPageObject = OnboardingPageObjectFactory.get(driver);
        onboardingPageObject.waitForFirstScreen();
        onboardingPageObject.clickNextPageOnboarding();
        onboardingPageObject.waitForSecondScreen();
        onboardingPageObject.clickNextPageOnboarding();
        onboardingPageObject.waitForThirdScreen();
        onboardingPageObject.clickNextPageOnboarding();
        onboardingPageObject.waitForFourthScreen();
        onboardingPageObject.clickStartOnboarding();
    }

    // Ex5
    @Test
    @DisplayName("Swipe onboarding flow")
    @Description("We check the full flow of onboarding by swiping and the start button")
    public void testSwipeFlowOnboarding() {
        if (Platform.getInstance().isMobileWeb()){
            return;
        }
        OnboardingPageObject onboardingPageObject = OnboardingPageObjectFactory.get(driver);
        onboardingPageObject.waitForAddOrRemoveLanguage();
        onboardingPageObject.swipeLeftToSecondScreen();
        onboardingPageObject.swipeLeftToThirdScreen();
        onboardingPageObject.swipeLeftToFourScreen();
        onboardingPageObject.waitForSendUsageReports();
        onboardingPageObject.clickStartOnboarding();
    }

}
