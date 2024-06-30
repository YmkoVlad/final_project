package by.vek.api_test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthorizationAPI {

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://www.21vek.by/";
    }

    @Test
    public void postLogin() {
        given().log().all()
                .header("content-type", "application/json")
                .body("{\"User\":{\"email\":\"wfloorballd^@gmail.com\",\"password\":\"1qaz^!QAZ\"}}")
                .when().post("https://www.21vek.by/users/action/login/")
                .then().log().all().statusCode(200);
    }


}
