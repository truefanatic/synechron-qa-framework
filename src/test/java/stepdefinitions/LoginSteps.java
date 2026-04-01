package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    @Given("user opens the login page")
    public void userOpensTheLoginPage() {
        System.out.println("Open login page");
    }

    @When("user logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        System.out.println("Perform login");
    }

    @Then("products page is displayed")
    public void productsPageIsDisplayed() {
        System.out.println("Verify products page");
    }
}
