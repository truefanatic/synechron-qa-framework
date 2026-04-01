package api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import models.CreateUserRequest;

public class UsersApi extends BaseApi{

    public Response getUsers(int page) {
        return request()
                .when()
                .get("/api/users?page=" + page);
    }

    public Response getUserById(int id) {
        return request()
                .when()
                .get("/api/users/" + id);
    }

    public Response createUser(String name, String job) {
        CreateUserRequest body = new CreateUserRequest(name, job);

        return request()
                .body(body)
                .when()
                .post("/api/users");
    }
}
