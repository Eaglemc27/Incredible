package com.yorel.incredible.core;

import org.openqa.selenium.WebElement;

public interface SmartElement extends WebElement {

    SmartElement should(Condition condition);
}
