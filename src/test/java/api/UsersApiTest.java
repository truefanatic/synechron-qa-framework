package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersApiTest {
    @Test
    public void getUsersTest() {
        Response response = RestAssured
                .given()
                .baseUri("https://reqres.in")
                .when()
                .get("/api/users?page=2");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.asString().contains("email"));
    }
}
