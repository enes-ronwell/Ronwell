package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.elementHelper;
import util.txtHelper;

public class basketPage {

    elementHelper helper;
    txtHelper txtHelper;

    public basketPage(WebDriver driver){
        this.helper = new elementHelper(driver);
        this.txtHelper = new txtHelper();
    }

    By delete = By.id("removeCartItemBtn0-key-0");
    By emptyBasket = By.id("emtyCart");
    By name = By.cssSelector(".m-basket__productInfoName");
    By fee = By.cssSelector(".m-productPrice__salePrice");
    By dropdown = By.id("quantitySelect0-key-0");

    public void deleteBasket() {
        helper.click(delete);
    }

    public void checkEmptyBasket() {
        helper.checkElementPresence(emptyBasket);
    }

    public void increaseQuantity(String count) {
        helper.select(dropdown,count);
    }

    public String getQuantity() {
       return helper.getSelectedText(emptyBasket);
    }

    public void checkBasketProductSame() {
        String value = txtHelper.getTxtValue();
        String desc = helper.getText(name);
        String price = helper.getText(fee);
        Assert.assertSame(value,desc,"Informations not same");
        Assert.assertSame(value,price,"Informations not same");
    }



}
