package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.elementHelper;

public class landingPage {

    elementHelper helper;

    public landingPage(WebDriver driver) {
        this.helper = new elementHelper(driver);
    }

    By logo = By.id("btnLogin");


    public void checkLogo(){
        helper.checkElementPresence(logo);
    }

}
