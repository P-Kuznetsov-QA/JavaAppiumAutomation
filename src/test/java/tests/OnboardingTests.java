package tests;

import lib.CoreTestCase;
import lib.Platform;
import org.junit.Test;
import ui.OnboardingPageObject;
import ui.factories.OnboardingPageObjectFactory;

public class OnboardingTests extends CoreTestCase {

    @Test
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
