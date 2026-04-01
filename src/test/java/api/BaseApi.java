package api;

import config.Config;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApi {
    protected RequestSpecification request() {
        return given()
                .baseUri(Config.get("BASE_URL"))
                .header("x-api-key", Config.get("API_KEY"))
                .contentType("application/json");
    }
}