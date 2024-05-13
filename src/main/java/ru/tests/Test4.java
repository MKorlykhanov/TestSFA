package ru.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Test4 {

    @BeforeAll
    public static void browserSetUp() {
        Configuration.browser = "chrome";
    }

    @Test
    public void loginToPegaSFA() {
        open("http://test/prweb/PRServlet/"); // подменил
        $(byXpath("//input[@id='txtUserID']")).val("Login"); // вин-логин оператора
        $(byXpath("//input[@id='txtPassword']")).val("Password"); // стандартный пароль
        $(byXpath("//button[@class='loginButton']")).click();
        $(byXpath("//a[contains(@data-test-id, 'SFAPortalHeader_Link_OperatorID')]")).shouldHave(text("ФИО оператора")); // ФИО тестового оператора реальное
    }
}