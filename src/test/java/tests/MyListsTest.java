package tests;

import lib.CoreTestCase;
import org.junit.Test;
import ui.*;
import ui.factories.*;

public class MyListsTest extends CoreTestCase {

    // Ex5: Тест: Сохранение двух статей
    @Test
    public void testSaveArticleToMyList() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Selenium");
        SearchPageObject.openArticleResultSearchWithSubstring("Selenium");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
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


        NavigationUiPageObject NavigationUI = NavigationUiPageObjectFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        MyListsPageObject.openFolderByName(name_of_folder);


        MyListsPageObject.swipeByArticleToDelete("инструмент для автоматизации действий веб-браузера и тестирования веб-приложений");
        MyListsPageObject.waitForArticleToDisappearByTitle("Selenium");
        MyListsPageObject.waitForArticleToAppearByTitle("Android");
        MyListsPageObject.clickArticleTitleToOpen("Android");

        ArticlePageObject.waitForTitleElement("Android");
    }

}
