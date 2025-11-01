package tests;

import lib.CoreTestCase;
import org.junit.Test;
import ui.OnboardingPageObject;
import ui.SearchPageObject;
import ui.factories.OnboardingPageObjectFactory;
import ui.factories.SearchPageObjectFactory;

public class SearchTest extends CoreTestCase {

    // Ex3: Тест: отмена поиска
    @Test
    public void testCancelSearch() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("язык программирования"); // если IOS - то substring 'Язык программирования'
        SearchPageObject.waitForSearchResult("JavaScript");
        SearchPageObject.clickCloseSearch();
        SearchPageObject.waitForCloseButtonToDisappear();
    }

    // Ex4*: Тест: проверка слов в поиске
    @Test
    public void testCheckWordsSearch() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("язык программирования");
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
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("c");
        SearchPageObject.waitForSearchResultByTitleAndDescription("C", "страница значений в проекте Викимедиа");
        SearchPageObject.waitForSearchResultByTitleAndDescription("Call of Duty", "серия компьютерных игр");
        SearchPageObject.waitForSearchResultByTitleAndDescription("Creative Commons", "огранизация, создатель свободных лицензий");
    }
}
