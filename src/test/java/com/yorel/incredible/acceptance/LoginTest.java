package com.yorel.incredible.acceptance;

import com.yorel.incredible.testApp.pages.LoginPage;
import com.yorel.incredible.testApp.pages.MainPage;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{

    @Test
    public void shouldLogin(){
        LoginPage.open();
        LoginPage.login("admin", "admin");
        MainPage.greetingShouldAppear();
    }

    @Test
    public void shouldNotLogin(){
        LoginPage.open();
        LoginPage.login("admin", "123");
        LoginPage.errorMessageShouldAppear();
    }

}
