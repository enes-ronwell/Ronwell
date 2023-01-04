package util;

import io.cucumber.core.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementHelper {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    propertiesFactory propertiesFactory = new propertiesFactory();


    public elementHelper(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, propertiesFactory.getWait());
    }

    public void click(By by) {
        scrollElement(by).click();
    }

    public void sendKey(By by, String text) {
        scrollElement(by).sendKeys(text);
    }

    public String getText(By by) {
        String text = scrollElement(by).getText();
        return text;
    }


    public void checkElementPresence(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public WebElement scrollElement(By by) {
        checkElementPresence(by);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).build().perform();
        return element;
    }

}
