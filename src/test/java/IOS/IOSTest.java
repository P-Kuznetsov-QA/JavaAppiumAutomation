package IOS;

import lib.IOSTestCase;
import org.junit.Test;
import ui.OnboardingPageObject;

public class IOSTest extends IOSTestCase {

    @Test
    public void testPassOnboarding()
    {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.clickNextPageOnboardingIOS();
        OnboardingPageObject.clickNextPageOnboardingIOS();
        OnboardingPageObject.clickNextPageOnboardingIOS();
        OnboardingPageObject.clickStartOnboardingIOS();
    }
}
