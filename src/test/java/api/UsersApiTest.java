package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersApiTest {
    @Test
    public void getUsersTest() {
        String apiKey = System.getenv("API_KEY");
        Response response = RestAssured
                .given()
                .baseUri("https://reqres.in")
                .header("x-api-key", apiKey)
                .when()
                .get("/api/users?page=2");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.asString().contains("email"));
    }
}
