package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import org.junit.Test;
import ui.OnboardingPageObject;
import ui.SearchPageObject;
import ui.factories.OnboardingPageObjectFactory;
import ui.factories.SearchPageObjectFactory;

@Epic("Tests for searches")
public class SearchTests extends CoreTestCase {

    // Ex3: Тест: отмена поиска
    @Test
    @Features(value = {@Feature(value = "Onboarding"), @Feature(value = "Search")})
    @DisplayName("Cancel search")
    @Description("We check the deletion of the input field and the results after clicking on the 'cancel' button")
    @Step("Starting test testCancelSearch")
    public void testCancelSearch() {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();
        } else {
            System.out.println("Skip onboarding page");
        }
        String search_line = "Java";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult("зык программирования");
        SearchPageObject.waitForSearchResult("JavaScript");
        SearchPageObject.clickCloseSearch();
        SearchPageObject.waitForCloseButtonToDisappear();
//        SearchPageObject.takeScreenshot("search_page");
    }

    // Ex4*: Тест: проверка слов в поиске
    @Test
    @Features(value = {@Feature(value = "Onboarding"), @Feature(value = "Search")})
    @DisplayName("Check words in search result")
    @Description("We check the search results by keyword")
    @Step("Starting test testCheckWordsSearch")
    public void testCheckWordsSearch() {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();
        } else {
            System.out.println("Skip onboarding page");
        }
        String search_line = "Java";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult("зык программирования");
        SearchPageObject.checkContainsWordResultSearch("Java", search_line);
        SearchPageObject.checkContainsWordResultSearch("JavaScript", search_line);
        SearchPageObject.checkContainsWordResultSearch("JavaServer Pages", search_line);
        SearchPageObject.checkContainsWordResultSearch("Java Platform, Standard Edition", search_line);
        SearchPageObject.checkContainsWordResultSearch("JavaFX", search_line);
        SearchPageObject.checkContainsWordResultSearch("Java Virtual Machine", search_line);
    }

    // Ex9*: Рефакторинг темплейта
    @Test
    @Features(value = {@Feature(value = "Onboarding"), @Feature(value = "Search")})
    @DisplayName("Check result with title and description")
    @Description("We enter the value 'c' in the search and check the results based on the title and description.")
    @Step("Starting test testSearchResultWithTitleAndDescription")
    public void testSearchResultWithTitleAndDescription() {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();
        } else {
            System.out.println("Skip onboarding page");
        }
        String search_line = "c";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResultByTitleAndDescription("C", "Страница значений в проекте Викимедиа");
        SearchPageObject.waitForSearchResultByTitleAndDescription("Call of Duty", "серия компьютерных игр");
        SearchPageObject.waitForSearchResultByTitleAndDescription("Creative Commons", "Огранизация, создатель свободных лицензий");
    }

    @Test
    @Features(value = {@Feature(value = "Onboarding"), @Feature(value = "Search")})
    @DisplayName("Check empty result search")
    @Description("We are checking an empty search result")
    @Step("Starting test testSearchEmptyResult")
    public void testSearchEmptyResult() {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();
        } else {
            System.out.println("Skip onboarding page");
        }
        String search_line = "cdssdfsdfsdfsd";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.emptyResult();
    }

}
