package api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;



public class UsersApiTest extends UsersApi {

    UsersApi usersApi = new UsersApi();

    @Test(groups = {"api"})
    public void getUsersTest() {

        Response response = usersApi.getUsers(2);
        response.then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("data.email", notNullValue());
//
//        String email = response.jsonPath().getString("data[0].email");
//        Assert.assertTrue(email.contains("@"));
    }

    @Test(groups = {"api"})
    public void getSingleUserTest() {

        usersApi.getUserById(2)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", notNullValue());
    }

    @Test(groups = {"api"})
    public void createUserTest() {

        usersApi.createUser("John", "QA")
                .then()
                .log().ifValidationFails()
                .statusCode(201)
                .body("name", equalTo("John"))
                .body("job", equalTo("QA"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }
}