package acceptance;

import core.WebDriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static core.API.open;
import static core.API.s;
import static core.Condition.containText;

public class Login {

    @Test
    public void login(){
        open("http://localhost:8080");
        s("#j_username").sendKeys("admin");
        s("#j_password").sendKeys("admin");
        s("[type=submit]").click();
        s(".welcome").should(containText("Ivan Petrov"));
    }

    @AfterAll
    public static void tearDown(){
        WebDriverFactory.closeDrvier();
    }


}
