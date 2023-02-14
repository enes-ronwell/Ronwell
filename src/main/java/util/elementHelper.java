package util;

import io.cucumber.core.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

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

    public void clickListRandom(By by) {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        Random rand = new Random();
        int size = rand.nextInt(elements.size());
        actions.moveToElement(elements.get(size)).build().perform();
    }

    public void sendKey(By by, String text) {
        scrollElement(by).sendKeys(text);
    }

    public void clear(By by) {
        scrollElement(by).clear();
    }

    public String getText(By by) {
        String text = scrollElement(by).getText();
        return text;
    }

    public void checkElementPresence(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void select(By by, String count) {
        Select dropdown = new Select(scrollElement(by));
        dropdown.selectByIndex(Integer.parseInt(count));
    }

    public String getSelectedText(By by) {
        Select dropdown = new Select(scrollElement(by));
        return dropdown.getFirstSelectedOption().getText();
    }


    public WebElement scrollElement(By by) {
        checkElementPresence(by);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).build().perform();
        return element;
    }


}
