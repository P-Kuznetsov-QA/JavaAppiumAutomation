package tests;

import lib.CoreTestCase;
import lib.Platform;
import org.junit.Test;
import ui.OnboardingPageObject;
import ui.SearchPageObject;
import ui.factories.OnboardingPageObjectFactory;
import ui.factories.SearchPageObjectFactory;

public class SearchTests extends CoreTestCase {

    // Ex3: Тест: отмена поиска
    @Test
    public void testCancelSearch() {
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();
        } else {
            System.out.println("Skip onboarding page");
        }


        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("зык программирования");
        SearchPageObject.waitForSearchResult("JavaScript");
        SearchPageObject.clickCloseSearch();
        SearchPageObject.waitForCloseButtonToDisappear();
    }

    // Ex4*: Тест: проверка слов в поиске
    @Test
    public void testCheckWordsSearch() {
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();
        } else {
            System.out.println("Skip onboarding page");
        }

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("зык программирования");
        SearchPageObject.checkContainsWordResultSearch("Java", "Java");
        SearchPageObject.checkContainsWordResultSearch("JavaScript", "Java");
        SearchPageObject.checkContainsWordResultSearch("JavaServer Pages", "Java");
        SearchPageObject.checkContainsWordResultSearch("Java Platform, Standard Edition", "Java");
        SearchPageObject.checkContainsWordResultSearch("JavaFX", "Java");
        SearchPageObject.checkContainsWordResultSearch("Java Cryptography Extension", "Java");
    }

    // Ex9*: Рефакторинг темплейта
    @Test
    public void testSearchResultWithTitleAndDescription() {
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();
        } else {
            System.out.println("Skip onboarding page");
        }

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("c");
        SearchPageObject.waitForSearchResultByTitleAndDescription("C", "страница значений в проекте Викимедиа");
        SearchPageObject.waitForSearchResultByTitleAndDescription("Call of Duty", "серия компьютерных игр");
        SearchPageObject.waitForSearchResultByTitleAndDescription("Creative Commons", "огранизация, создатель свободных лицензий");
    }

    @Test
    public void testSearchEmptyResult() {
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();
        } else {
            System.out.println("Skip onboarding page");
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("cdssdfsdfsdfsd");
        SearchPageObject.emptyResult();
    }
}
