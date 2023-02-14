package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.elementHelper;

public class productListPage {

    elementHelper helper;

    public productListPage(WebDriver driver){
        this.helper = new elementHelper(driver);
    }

    By products = By.cssSelector("#productList>div img");

    public void tapRandomProduct() {
        helper.clickListRandom(products);
    }

}
