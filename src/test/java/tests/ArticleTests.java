package tests;

import lib.CoreTestCase;
import lib.Platform;
import org.junit.Test;
import ui.ArticlePageObject;
import ui.OnboardingPageObject;
import ui.SearchPageObject;
import ui.factories.ArticlePageObjectFactory;
import ui.factories.OnboardingPageObjectFactory;
import ui.factories.SearchPageObjectFactory;

public class ArticleTests extends CoreTestCase {

    // Ex6: Тест: assert title
    @Test
    public void testAssertHasTitle() {
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();
        } else {
            System.out.println("Skip onboarding page");
        }

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Ozon");
        SearchPageObject.openArticleResultSearchWithSubstring("Ozon");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.assertTitlePresent("Ozon");
    }

    @Test
    public void testSwipeFooterSearchArticle() {
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();
        } else {
            System.out.println("Skip onboarding page");
        }

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Selenium");
        SearchPageObject.openArticleResultSearchWithSubstring("Selenium");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement("Selenium");
        ArticlePageObject.swipeToFooter();
    }


}
