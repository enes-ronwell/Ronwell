package stepDefinations;

import pages.homePage;
import pages.loginPage;
import util.driverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {

    loginPage loginPage = new loginPage(driverFactory.getDriver());
    homePage homePage = new homePage(driverFactory.getDriver());


    @Then("user should see the Login Page")
    public void userShouldSeeTheLoginPage() {
    }

    @Given("user is on the Login Page")
    public void userIsOnTheLoginPage() {
        homePage.scrolAcilanLoginButton();
        homePage.clickLoginButton();
        loginPage.checkLogo();
    }

    @When("user senkeys Email: {string} on Login Page")
    public void userSenkeysEmailOnLoginPage(String text) {
        loginPage.sendKeyEmailTextbox(text);
    }

    @When("user taps to Login Button on Login Page")
    public void userTapsToLoginButtonOnLoginPage() {
        loginPage.clickLoginButton();
    }

    @Then("user should see Failed Mail Message: {string} on Login Page")
    public void userShouldSeeFailedMailMessageOnLoginPage(String text) {
        loginPage.checkTextFailedMessage(text);
    }

}
