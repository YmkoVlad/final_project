package by.vek.pages;

import by.vek.utils.DriverManager;
import by.vek.utils.Waiters;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    @FindBy(css = "#login-email")
    private WebElement emailInputField;
    @FindBy(css = "#login-password")
    private WebElement passwordInputField;
    @FindBy(css = "button[data-testid='loginSubmit']")
    private WebElement submitBtn;
    @FindBy(css = "div[class='FieldWrapper-module__wrapper styles_email__BTXT4'] .ErrorMessage-module__message")
    private WebElement emailErrorMessage;
    @FindBy(css = "div[class='FieldWrapper-module__wrapper'] .ErrorMessage-module__message")
    private WebElement passwordErrorMessage;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void typeEmailByInputField(String login) {
        Waiters.waitElementIsVisible(emailInputField);
        emailInputField.click();
        emailInputField.sendKeys(login);
    }

    public void typePasswordByInputField(String password) {
        Waiters.waitElementIsVisible(passwordInputField);
        passwordInputField.click();
        passwordInputField.sendKeys(password);
    }

    public StartPage clickBySubmitBtn() {
        Waiters.waitElementIsClickable(submitBtn);
        submitBtn.click();
        return new StartPage();
    }


    public Boolean isEmailErrorMessageEqual(String emailMessage) {
        Waiters.waitElementIsVisible(emailErrorMessage);
        String emaailString = emailErrorMessage.getText();
        return emaailString.equals(emailMessage);
    }

    public Boolean isPasswordErrorMessageEqual(String passwordMessage) {
        Waiters.waitElementIsVisible(passwordErrorMessage);
        String passwordString = passwordErrorMessage.getText();
        return passwordString.equals(passwordMessage);
    }

    public Boolean isPresentWebElementEmailErrorMessage() {
        try {
            Waiters.waitElementIsVisible(emailErrorMessage);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public Boolean isPresentWebElementPasswordErrorMessage() {
        try {
            Waiters.waitElementIsVisible(passwordErrorMessage);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

}

