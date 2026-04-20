package io.github.julianachavespalm.saucedemo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.julianachavespalm.saucedemo.page.LoginPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SaucedemoTest {
    LoginPage mainPage = new LoginPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://www.saucedemo.com/");
    }

    @Test
    @Tag("regression")
    public void testLoginWithCredentials() {
        mainPage.login();
        $(".app_logo").shouldBe(visible).shouldHave(exactText("Swag Labs"));
    }
}
