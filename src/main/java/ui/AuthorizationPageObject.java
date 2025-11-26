package ui;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject{
    private static final String
            LOGIN_BUTTON = "css:a.cdx-button.cdx-button--fake-button.cdx-button--action-progressive",
            LOGIN_INPUT = "css:#wpName1",
            PASSWORD_INPUT = "css:#wpPassword1",
            SUBMIT_BUTTON = "css:button#wpLoginAttempt";

    public AuthorizationPageObject(RemoteWebDriver driver){
        super(driver);
    }

    @Step("Clicks for user Login")
    public void clickAuthButton() {
        this.waitForElementForPresent(LOGIN_BUTTON, "Cannot find auth button", 5);
        this.waitForElementAndClickWithJS(LOGIN_BUTTON, "Cannot find and click auth button", 5);
    }

    @Step("Entering username and password")
    public void enterLoginData(String login, String password){
        this.waitForElementAndSendKeys(LOGIN_INPUT, login, "Cannot find and put a login to the login input", 5);
        this.waitForElementAndSendKeys(PASSWORD_INPUT, password, "Cannot find and put a password to the password input", 5);
    }

    @Step("User authorization")
    public void submitForm() {
        this.waitForElementAndClick(SUBMIT_BUTTON, "Cannot find and click submit auth button", 5);
    }
}
