package core;

import com.google.common.base.Predicate;
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
}
