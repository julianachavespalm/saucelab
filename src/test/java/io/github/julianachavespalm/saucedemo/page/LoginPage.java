package io.github.julianachavespalm.saucedemo.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private String STANDARD_USER = getEnvOrDefault("STANDARD_USER", "standard_user");
    private String STANDARD_PASSWORD = getEnvOrDefault("STANDARD_PASSWORD", "secret_sauce");

    SelenideElement btnLogin = $("#login-button");

    /**
     * Pega variável de ambiente ou retorna valor padrão
     * Funciona em desenvolvimento local, GitHub Actions e GitLab CI
     */
    private String getEnvOrDefault(String varName, String defaultValue) {
        String value = System.getenv(varName);
        return value != null && !value.isEmpty() ? value : defaultValue;
    }
}
