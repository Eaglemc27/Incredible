package core;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

class ElementFinder {
    private SearchContext parent;
    private By locator;
    private int index;

    ElementFinder(SearchContext parent, By locator, int index){
        this.parent = parent;
        this.locator = locator;
        this.index = index;
    }

    WebElement getWebElement() {
        return parent.findElement(locator);
    }

}
