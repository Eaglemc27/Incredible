package com.yorel.incredible.core;

import com.google.common.base.Predicate;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public abstract class Condition implements Predicate<WebElement> {

    public static Condition containText(String text){
        return new Condition() {
            @Override
            public boolean apply(WebElement webElement) {
                return webElement.getText().contains(text);
            }

            @Override
            public String toString(){
                return "should contain text " + text;
            }
        };
    }

    public static Condition beVisible(){
        return new Condition() {
            @Override
            public boolean apply(WebElement input) {
                boolean isVisible = false;
                try{
                    isVisible = input.isDisplayed();
                }catch (NoSuchElementException ex){
                    ex.printStackTrace();
                }
                return isVisible;
            }
        };
    }
}
