package com.yorel.incredible.testApp.pages;

import com.yorel.incredible.API;
import com.yorel.incredible.core.Config;
import com.yorel.incredible.core.SmartElement;
import org.openqa.selenium.By;

import static com.yorel.incredible.API.s;
import static com.yorel.incredible.core.Condition.beVisible;

public class MainPage {

    public static SmartElement greetingShouldAppear(){
        return s(".welcome").should(beVisible());
    }

    public static void logout(){
        s(By.xpath("//*[text()='Logout']")).click();
    }

    public static void openMyApplications(){
        s(By.xpath("//*[text()='My applications']")).click();
    }

    public static void open() {
        API.open(Config.BASE_URL);
    }
}
