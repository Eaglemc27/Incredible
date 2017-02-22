package com.yorel.incredible.testApp.pages;

import com.yorel.incredible.API;

import static com.yorel.incredible.API.s;
import static com.yorel.incredible.core.Condition.beVisible;
import static com.yorel.incredible.core.Selectors.byText;

public class LoginPage {
    public static void login(String username, String password) {
        s("#j_username").sendKeys(username);
        s("#j_password").sendKeys(password);
        s("[type=submit]").click();
    }

    public static void linkToRegistrationShouldAppear(){
        s(byText("Register as a new user")).should(beVisible());
    }

    public static void open() {
        API.open("auth/login");
    }

    public static void errorMessageShouldAppear(){
         s(".flash").should(beVisible());
    }
}
