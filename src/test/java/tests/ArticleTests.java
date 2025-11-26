package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.junit4.DisplayName;
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
    @DisplayName("Checking the article title")
    @Description("We open articles from the search and check if the article title matches")
    public void testAssertHasTitle() {
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();
        } else {
            System.out.println("Skip onboarding page");
        }
        String article_title = "Ozon";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(article_title);
        SearchPageObject.openArticleResultSearchWithSubstring(article_title);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement(article_title);
        ArticlePageObject.assertTitlePresent(article_title);
    }

    @Test
    @DisplayName("Scrolling through the footer of an article")
    @Description("We open the article from the search and check that the article scrolls to the footer")
    public void testSwipeFooterSearchArticle() {
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();
        } else {
            System.out.println("Skip onboarding page");
        }
        String article_title = "Selenium";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(article_title);
        SearchPageObject.openArticleResultSearchWithSubstring(article_title);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement(article_title);
        ArticlePageObject.swipeToFooter();
    }
}
