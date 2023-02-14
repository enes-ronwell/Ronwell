package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.basketPage;
import util.driverFactory;

public class basket {
    basketPage basketPage = new basketPage(driverFactory.getDriver());

    @Then("User is should see same Information on Product Page and on Basket Page")
    public void userIsShouldSeeSameInformationOnProductPageAndOnBasketPage() {
        basketPage.checkBasketProductSame();
    }

    @When("User is increase the quantity on Basket Page")
    public void userIsIncreaseTheQuantityOnBasketPage() {
        basketPage.increaseQuantity("2");
    }

    @Then("User is should see Product Quantity: {string} on Basket Page")
    public void userIsShouldSeeProductQuantityOnBasketPage(String quantity) {
        String expQuantity = basketPage.getQuantity();
        Assert.assertEquals(quantity,expQuantity,"Quantity Not Match");
    }

    @When("User is delete Basket Product on Basket Page")
    public void userIsDeleteBasketProductOnBasketPage() {
        basketPage.deleteBasket();
    }

    @Then("User is should see Empty Basket on Basket Page")
    public void userIsShouldSeeEmptyBasketOnBasketPage() {
        basketPage.checkEmptyBasket();

    }
}
