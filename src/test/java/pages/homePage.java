package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.elementHelper;
import util.excelHelper;

public class homePage {

    elementHelper helper;
    excelHelper excelHelper;

    public homePage(WebDriver driver) {
        this.helper = new elementHelper(driver);
        this.excelHelper = new excelHelper();
    }

    By searchBox = By.cssSelector(".default-input.o-header__search--input");
    By allCookie = By.id("onetrust-accept-btn-handler");
    By man = By.id("genderManButton");
    By search = By.cssSelector(".o-header__search.bwi-search-o use");

    public String getSortOnExcel() {
        return excelHelper.getValue(0, 0);
    }

    public String getShirtOnExcel() {
        return excelHelper.getValue(1, 0);
    }

    public void typeSearchBox(String key) {
        helper.sendKey(searchBox, key);
    }
    public void clickSearch() {
        helper.click(search);
    }

    public void clearSearchBox() {
        helper.clear(searchBox);
    }

    public void clickAllCookie() {
        helper.click(allCookie);
    }

    public void clickMan() {
        helper.click(man);
    }

}
