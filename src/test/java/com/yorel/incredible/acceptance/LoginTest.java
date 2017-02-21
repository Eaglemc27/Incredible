package com.yorel.incredible.acceptance;

import com.yorel.incredible.API;
import com.yorel.incredible.core.Config;
import com.yorel.incredible.testApp.pages.LoginPage;
import com.yorel.incredible.testApp.pages.MainPage;
import org.junit.Test;

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

    //TODO fix lags on FF which occur sometimes
    @Test
    public void shouldTerminateSessionAfterLogout(){
        LoginPage.open();
        LoginPage.login("admin", "admin");
        API.openNewTab(Config.BASE_URL);
            MainPage.open();
            MainPage.logout();
        API.closeTab();
        MainPage.openMyApplications();
        LoginPage.linkToRegistrationShouldAppear();
    }

}
