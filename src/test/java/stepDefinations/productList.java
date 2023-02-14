package stepDefinations;

import io.cucumber.java.en.When;
import pages.productListPage;
import util.driverFactory;

public class productList {

    productListPage productListPage = new productListPage(driverFactory.getDriver());

    @When("User is tap Random Product on Product List Page")
    public void userIsTapRandomProductOnProductListPage() {
        productListPage.tapRandomProduct();
    }

}
