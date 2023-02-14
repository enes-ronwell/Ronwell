package stepDefinations;

import io.cucumber.java.en.When;
import pages.productPage;
import util.driverFactory;

public class product {
    productPage productPage = new productPage(driverFactory.getDriver());

    @When("User is add Information to txt file on Product Page")
    public void userIsAddInformationToTxtFileOnProductPage() {
        productPage.addInformationsToTxt();
    }

    @When("User is add to Basket on Product Page")
    public void userIsAddToBasketOnProductPage() {
        productPage.addBasket();
    }
}
