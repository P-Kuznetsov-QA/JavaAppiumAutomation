package tests;

import lib.CoreTestCase;
import lib.Platform;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.*;
import ui.factories.*;

public class MyListsTests extends CoreTestCase {
    private static final String
            login = "Topping88",
            password = "stop02egor";

    // Ex5: Тест: Сохранение двух статей
    @Test
    public void testSaveArticleToMyList() {
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Selenium");
        SearchPageObject.openArticleResultSearchWithSubstring("Selenium");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement("Selenium");
        String name_of_folder = "Test List";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        if (Platform.getInstance().isMobileWeb()) {
            AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
            AuthorizationPageObject.clickAuthButton();
            AuthorizationPageObject.enterLoginData(login, password);
            AuthorizationPageObject.submitForm();
            ArticlePageObject.waitForTitleElement("Selenium");
            Assert.assertEquals("The title of the article does not match", "Selenium", "Selenium");
        }
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            ArticlePageObject.closeArticle();
        } else {
            ArticlePageObject.openSearchInput();
        }


        SearchPageObject.newTypeSearchLine("Android");
        SearchPageObject.openArticleResultSearchWithSubstring("Android");
        ArticlePageObject.waitForTitleElement("Android");

        ArticlePageObject.addNewArticleToAlreadyCreatedMyList();
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            ArticlePageObject.closeArticle();
            SearchPageObject.returnMainPage();
        }


        NavigationUiPageObject NavigationUI = NavigationUiPageObjectFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        MyListsPageObject.openFolderByName(name_of_folder);


        MyListsPageObject.swipeByArticleToDelete("Selenium"); // инструмент для автоматизации действий веб-браузера и тестирования веб-приложений
        MyListsPageObject.waitForArticleToDisappearByTitle("Selenium");
        MyListsPageObject.waitForArticleToAppearByTitle("Android");
        MyListsPageObject.clickArticleTitleToOpen("Android");
        ArticlePageObject.waitForTitleElement("Android");
        if (Platform.getInstance().isMobileWeb()) {
            Assert.assertTrue("The remove article button to My list should be displayed", ArticlePageObject.isRemoveSaveButtonPresent());
        }

    }

}
