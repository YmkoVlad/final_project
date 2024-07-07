package by.vek.api_test;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class AuthorizationAPI {

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://www.21vek.by/";
    }

    @Test
    public void postLoginValidDataTest() {
        File userData= new File("src/test/resources/json/user.json");
        given().log().all()
                .header("content-type", "application/json")
                .header("accept", "application/json;version=1.1")
                .body(userData)
                .when().post("users/action/login/")
                .then().log().all().statusCode(302);
    }

    @Test
    public void postLoginNotValidEmail() {
        File userNotValidEmailData = new File("src/test/resources/json/notValidEmailUser.json");
        given().log().all()
                .header("content-type", "application/json")
                .body(userNotValidEmailData)
                .when().post("users/action/login/")
                .then().log().all().statusCode(200);
    }

    @Test
    public void postLoginNotValidPassword() {
        File userNotValidPasswordData = new File("src/test/resources/json/notValidPasswordUser.json");
        given().log().all()
                .header("content-type", "application/json")
                .header("accept", "application/json;version=1.1")
                .body(userNotValidPasswordData)
                .when().post("users/action/login/")
                .then().log().all().statusCode(200);
    }

    @Test
    public void postLoginNotValidEmailAndPassword() {
        File notValidUser = new File("src/test/resources/json/notValidUser.json");
        given().log().all()
                .header("content-type", "application/json")
                .header("accept", "application/json;version=1.1")
                .body(notValidUser)
                .when().post("users/action/login/")
                .then().log().all().statusCode(200);
    }

}
