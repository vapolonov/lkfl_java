package tests;

import config.AuthConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AccountLoginTest extends TestBase {

    @Test
    void successfulAccountLoginTest() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
        $(".flex-shrink-0").shouldHave(text("Личный кабинет\nналогоплательщика"));
        $("#username_1").setValue(config.username());
        $("#password_2").setValue(config.password());
        $(".m-button_fill").click();
        $(".text-right").shouldHave(text("АПОЛОНОВ ВАСИЛИЙ ВЯЧЕСЛАВОВИЧ"));
        $(".items-end.mr-4").shouldHave(text(config.username()));
    }

    @Test
    void unsuccessfulAccountLoginTest() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
        $(".flex-shrink-0").shouldHave(text("Личный кабинет\nналогоплательщика"));
        $("#username_1").setValue(config.username());
        $("#password_2").setValue(config.wrongPassword());
        $(".m-button_fill").click();
        $(".pt-4").shouldHave(text("Неверный ИНН/пароль"));
    }
}
