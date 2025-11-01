package tests;

import lib.CoreTestCase;
import org.junit.Test;
import ui.ArticlePageObject;
import ui.OnboardingPageObject;
import ui.SearchPageObject;
import ui.factories.ArticlePageObjectFactory;
import ui.factories.OnboardingPageObjectFactory;
import ui.factories.SearchPageObjectFactory;

public class ArticleTest extends CoreTestCase {

    // Ex6: Тест: assert title
    @Test
    public void testAssertHasTitle() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Fifa");
        SearchPageObject.openArticleResultSearchWithSubstring("FIFA (серия игр)");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.assertTitlePresent("FIFA (серия игр)");
    }

    @Test
    public void testSwipeFooterSearchArticle() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Selenium");
        SearchPageObject.openArticleResultSearchWithSubstring("Selenium");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement("Selenium");
        ArticlePageObject.swipeToFooter();
    }


}
