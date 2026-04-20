package io.github.julianachavespalm.saucedemo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.julianachavespalm.saucedemo.page.LoginPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SaucedemoTest {
    LoginPage mainPage = new LoginPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x800";

        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--remote-allow-origins=*",
                "--window-size=1280,800",
                "--disable-gpu",
                "--headless=new"
        );
        Configuration.browserCapabilities = options;

        System.setProperty("webdriver.chrome.verboseLogging", "true");
        System.setProperty("webdriver.chrome.logfile", "target/chromedriver.log");

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://www.saucedemo.com/");
    }

    @Test
    @Tag("regressive")
    public void testLoginWithCredentials() {
        mainPage.login();
        $(".app_logo").shouldBe(visible).shouldHave(exactText("Swag Labs"));
    }
}
