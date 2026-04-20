package io.github.julianachavespalm.saucedemo.page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static io.github.julianachavespalm.saucedemo.utils.GetUtils.getVariable;

public class LoginPage {
    public static final String STANDARD_USER = "STANDARD_USER";
    public static final String STANDARD_PASSWORD = "STANDARD_PASSWORD";

    private SelenideElement btnLogin() {
        return $("#login-button");
    }

    private SelenideElement cmpUsername() {
        return $("#user-name");
    }

    private SelenideElement cmpPassword() {
        return $("#password");
    }

    public void login() {
        String user = getVariable(STANDARD_USER);
        String pass = getVariable(STANDARD_PASSWORD);

        if (user == null || user.isEmpty() || pass == null || pass.isEmpty()) {
            throw new IllegalArgumentException("Variáveis `STANDARD_USER` e `STANDARD_PASSWORD` não configuradas ou vazias!");
        }

        cmpUsername().setValue(user);
        cmpPassword().setValue(pass);
        btnLogin().click();
    }
}
