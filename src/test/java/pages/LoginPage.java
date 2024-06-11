package pages;

import static com.codeborne.selenide.Condition.text;
import static locators.AccountLoginLocators.*;


public class LoginPage {

    public void openPage(String value) {
        headerText.shouldHave(text(value));
    }

    public void fillName(String value) {
        userNameInput.setValue(value);
    }

    public void fillPassword(String value) {
        userPasswordInput.setValue(value);
    }

    public void sendForm() {
        sendFormButton.click();
    }

    public void verifySuccessfulLogin(String inn) {
//        userFullNameText.shouldHave(text(fullName));
        userINNText.shouldHave(text(inn));
    }

    public void verifyUnsuccessfulLogin(String value) {
        unsuccessfulLoginText.shouldHave(text(value));
    }
}
