package com.yorel.incredible.core;

import org.openqa.selenium.WebElement;

abstract class Command<T> {

    abstract T execute(SmartElement element, ElementFinder finder, Object[] args);

    static Command<Void> click(){
        return new Command<Void>() {
            @Override
            Void execute(SmartElement element, ElementFinder finder, Object[] args) {
                finder.getWebElement().click();
                return null;
            }
        };
    }

    static Command<SmartElement> sendKeys(){
        return new Command<SmartElement>() {
            @Override
            SmartElement execute(SmartElement element, ElementFinder finder, Object[] args) {
                finder.getWebElement().sendKeys((CharSequence[]) args[0]);
                return element;
            }
        };
    }

    static Command<SmartElement> should() {
        return new Command<SmartElement>() {
            @Override
            public SmartElement execute(SmartElement element, ElementFinder finder, Object[] args) {
                WebElement webElement = finder.getWebElement();
                checkCondition(webElement, (Condition) args[0]);
                return element;
            }

            void checkCondition(WebElement webElement, Condition condition) {
                boolean IsSatisfied = condition.apply(webElement);

                if(!IsSatisfied){
                    throw new RuntimeException("Condition " + condition + " is not met");
                }
            }
        };


    }


}
