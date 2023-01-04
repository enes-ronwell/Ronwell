package stepDefinations;

import io.cucumber.java.en.Then;
import pages.landingPage;
import pages.loginPage;
import util.driverFactory;

public class landing {
    landingPage landingPage = new landingPage(driverFactory.getDriver());
    @Then("user should see the Landing Page")
    public void userShouldSeeTheLandingPage() {
        landingPage.checkLogo();
    }
}
