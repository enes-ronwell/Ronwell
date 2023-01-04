package stepDefinations;

import pages.homePage;
import util.driverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class home {
   homePage homePage = new homePage(driverFactory.getDriver());


    @Given("user is on the Home Page")
    public void userIsOnTheHomePage() {
        homePage.checkLogo();
    }

    @When("user taps to Login Button on Home Page")
    public void userTapsToLoginButtonOnHomePage() {
        homePage.scrolAcilanLoginButton();
        homePage.clickLoginButton();
    }


}
