package stepdefinitions;

import api.UsersApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.notNullValue;

public class UsersSteps {

    private final UsersApi usersApi = new UsersApi();
    private Response response;

    @Given("the users API is available")
    public void theUsersApiIsAvailable() {
        // Optional health/setup step
    }

    @When("I request users on page {int}")
    public void iRequestUsersOnPage(int page) {
        response = usersApi.getUsers(page);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain emails")
    public void theResponseShouldContainEmails() {
        response.then().body("data.email", notNullValue());
    }
}