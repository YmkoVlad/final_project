package by.vek.api_test;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthorizationAPI {

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://www.21vek.by/";
    }

    @Test
    public void postLoginValidDataTest() {
        given().log().all()
                .header("content-type", "application/json")
                .header("accept", "application/json;version=1.1")
                .body("{\"User\":{\"email\":\"Kukharevich.vlad@gmail.com\",\"password\":\"19ae43ba\"}}")
                .when().post("users/action/login/")
                .then().log().all().statusCode(302);
    }

    @Test
    public void postLoginNotValidEmail() {
        given().log().all()
                .header("content-type", "application/json")
                .body("{\"User\":{\"email\":\"wflo^@gmail.com\",\"password\":\"1qaz^!QAZ\"}}")
                .when().post("users/action/login/")
                .then().log().all().statusCode(200);
    }

    @Test
    public void postLoginNotValidPassword() {
        given().log().all()
                .header("content-type", "application/json")
                .header("accept", "application/json;version=1.1")
                .body("{\"User\":{\"email\":\"wfloorballd^@gmail.com\",\"password\":\"Qq35\"}}")
                .when().post("users/action/login/")
                .then().log().all().statusCode(200);
    }

    @Test
    public void postLoginNotValidEmailAndPassword() {
        given().log().all()
                .header("content-type", "application/json")
                .header("accept", "application/json;version=1.1")
                .body("{\"User\":{\"email\":\"alld^@gmail.com\",\"password\":\"1q\"}}")
                .when().post("users/action/login/")
                .then().log().all().statusCode(200);
    }

}
