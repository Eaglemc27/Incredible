package com.yorel.incredible.core;

import org.openqa.selenium.By;

public class Selectors {

    public static By byText(String text){
        return new ByText(text);
    }

    static class ByText extends By.ByXPath {
        String text;
        private ByText(String text) {
            super(".//*[contains(text(), '"+text+"')]");
            this.text = text;
        }

        @Override
        public String toString() {
            return "by text: " + text;
        }
    }
}
