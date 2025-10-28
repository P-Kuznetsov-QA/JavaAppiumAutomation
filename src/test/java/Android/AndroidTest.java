package Android;

import lib.CoreTestCase;
import org.junit.Test;
import ui.*;



public class AndroidTest extends CoreTestCase {


    // Ex3: Тест: отмена поиска
    @Test
    public void testCancelSearch() {

        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("язык программирования");
        SearchPageObject.waitForSearchResult("JavaScript");
        SearchPageObject.clickCloseSearch();
        SearchPageObject.waitForCloseButtonToDisappear();

    }

    // Ex4*: Тест: проверка слов в поиске
    @Test
    public void testCheckWordsSearch() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
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



    // Ex5: Тест: Сохранение двух статей
    @Test
    public void testSaveArticleToMyList() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Selenium");
        SearchPageObject.openArticleResultSearchWithSubstring("Selenium");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement("Selenium");
        String name_of_folder = "Test List";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        SearchPageObject.newTypeSearchLine("Android");
        SearchPageObject.openArticleResultSearchWithSubstring("Android");
        ArticlePageObject.waitForTitleElement("Android");
        ArticlePageObject.addNewArticleToAlreadyCreatedMyList();
        ArticlePageObject.closeArticle();

        SearchPageObject.returnMainPage();


        NavigationUi NavigationUI = new NavigationUi(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);


        MyListsPageObject.swipeByArticleToDelete("инструмент для автоматизации действий веб-браузера и тестирования веб-приложений");
        MyListsPageObject.waitForArticleToDisappearByTitle("Selenium");
        MyListsPageObject.waitForArticleToAppearByTitle("Android");
        MyListsPageObject.clickArticleTitleToOpen("Android");

        ArticlePageObject.waitForTitleElement("Android");
    }

    // Ex6: Тест: assert title
    @Test
    public void testAssertHasTitle() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Fifa");
        SearchPageObject.openArticleResultSearchWithSubstring("FIFA (серия игр)");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.assertTitlePresent("FIFA (серия игр)");

    }

    // Ex9*: Рефакторинг темплейта
    @Test
    public void testSearchResultWithTitleAndDescription() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("c");
        SearchPageObject.waitForSearchResultByTitleAndDescription("C", "страница значений в проекте Викимедиа");
        SearchPageObject.waitForSearchResultByTitleAndDescription("Call of Duty", "серия компьютерных игр");
        SearchPageObject.waitForSearchResultByTitleAndDescription("Creative Commons", "огранизация, создатель свободных лицензий");


    }


}
