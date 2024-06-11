package locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AccountLoginLocators {

    public static SelenideElement
    headerText = $(".flex-shrink-0"),
    userNameInput = $("#username_1"),
    userPasswordInput = $("#password_2"),
    sendFormButton = $(".m-button_fill"),
    userFullNameText = $(".text-right"),
    userINNText = $(".items-end.mr-4"),
    unsuccessfulLoginText = $(".pt-4");
}
