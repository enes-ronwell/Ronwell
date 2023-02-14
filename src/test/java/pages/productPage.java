package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.elementHelper;
import util.txtHelper;

public class productPage {

    elementHelper helper;
    txtHelper txtHelper;

    public productPage(WebDriver driver) {
        this.helper = new elementHelper(driver);
        this.txtHelper = new txtHelper();
    }

    By addBasketButton = By.id("addBasket");
    By name = By.cssSelector(".o-productDetail__description");
    By fee = By.id("priceNew");
    By variation = By.cssSelector("m-variation__item");
    By goBasket = By.cssSelector(".m-notification__button.btn");


    public void addBasket() {
        helper.click(variation);
        helper.click(addBasketButton);
        helper.click(goBasket);
    }

    public void addInformationsToTxt() {
        String desc = helper.getText(name);
        String price = helper.getText(fee);
        txtHelper.printToTxt(desc + price);
    }

}
