package tests;

import config.AuthConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class AccountLoginPageObjectTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    String header = "Личный кабинет\nналогоплательщика";
    String wrongNameOrPassword = "Неверный ИНН/пароль";
    AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @Test
    void successfulAccountLoginTest() {
        loginPage.openPage(header);
        loginPage.fillName(config.username());
        loginPage.fillPassword(config.password());
        loginPage.sendForm();
        loginPage.verifySuccessfulLogin(config.username());
    }

    @Test
    void unsuccessfulAccountLoginTest() {
        loginPage.openPage(header);
        loginPage.fillName(config.username());
        loginPage.fillPassword(config.wrongPassword());
        loginPage.sendForm();
        loginPage.verifyUnsuccessfulLogin(wrongNameOrPassword);
    }
}
