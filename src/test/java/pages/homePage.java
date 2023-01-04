package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.elementHelper;
import util.propertiesFactory;

public class homePage {

    elementHelper helper;

    public homePage(WebDriver driver){
        this.helper = new elementHelper(driver);
    }

    By logo = By.xpath("//*[@alt=\"Desktop-Logo\"]");
    By acilanLoginButton = By.id("myAccount");
    By loginButton = By.id("login");



    public void checkLogo() {
        helper.checkElementPresence(logo);
    }

    public void scrolAcilanLoginButton() {
        helper.scrollElement(acilanLoginButton);
    }

    public void clickLoginButton() {
        helper.click(loginButton);
    }

}
