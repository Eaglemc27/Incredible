package com.yorel.incredible.core;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ElementFinder {
    private SearchContext parent;
    private By locator;
    private int index;

    public ElementFinder(SearchContext parent, By locator, int index){
        this.parent = parent;
        this.locator = locator;
        this.index = index;
    }

    WebElement getWebElement() {
        return parent.findElement(locator);
    }

}
