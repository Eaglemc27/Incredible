package com.yorel.incredible.testApp.pages;

import com.yorel.incredible.core.SmartElement;

import static com.yorel.incredible.API.s;
import static com.yorel.incredible.core.Condition.beVisible;

public class MainPage {

    public static SmartElement greetingShouldAppear(){
        return s(".welcome").should(beVisible());
    }
}
