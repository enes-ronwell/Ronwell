package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.elementHelper;


public class loginPage {
    elementHelper helper;

    public loginPage(WebDriver driver) {
        this.helper = new elementHelper(driver);
    }

    By loginButton = By.id("btnLogin");
    By emailTextbox = By.id("txtUserName");
    By failedMessage = By.cssSelector("form>div>div>div:nth-child(3)");


    public void checkLogo() {
    }

    public void clickLoginButton() {
        helper.click(loginButton);
    }

    public void sendKeyEmailTextbox(String text) {
        helper.sendKey(emailTextbox,text);
    }

    public void checkTextFailedMessage(String expectedText) {
        String actualText = helper.getText(failedMessage);
        Assert.assertEquals(expectedText, actualText);
    }


}
