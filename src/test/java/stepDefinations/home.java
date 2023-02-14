package stepDefinations;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.homePage;
import util.driverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class home {
    homePage homePage = new homePage(driverFactory.getDriver());
    WebDriverWait wait = new WebDriverWait(driverFactory.getDriver(),10);

    @Given("User is on Home Page")
    public void userIsOnHomePage() {
        wait.until(ExpectedConditions.urlToBe("https://www.beymen.com/"));
        homePage.clickAllCookie();
        homePage.clickMan();
    }

    @When("User is type Sort in SearchBox on Home Page")
    public void userIsTypeSortInSearchBoxOnHomePage() {
        String key = homePage.getSortOnExcel();
        homePage.typeSearchBox(key);
    }

    @When("User is clear in SearchBox on Home Page")
    public void userIsClearInSearchBoxOnHomePage() {
        homePage.clearSearchBox();
    }

    @When("User is type Shirt in SearchBox on Home Page")
    public void userIsTypeShirtInSearchBoxOnHomePage() {
        String key = homePage.getShirtOnExcel();
        homePage.typeSearchBox(key);
    }

    @When("User is tap Search on Home Page")
    public void userIsTapSearchOnHomePage() {
        homePage.clickSearch();
    }
}
