package by.vek.api_test;

import by.vek.enums.ErrorMesageAPI;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
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
        Response response = given().log().all()
                .header("content-type", "application/json")
                .header("accept", "application/json;version=1.1")
                .header("x-requested-with", "XMLHttpRequest")
                .body(userData)
                .when().post("users/action/login/")
                .then().log().all().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json/authorizationScheme.json"))
                .extract().response();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code != 200");
    }

    @Test
    public void postLoginNotValidEmail() {
        File userNotValidEmailData = new File("src/test/resources/json/notValidEmailUser.json");
        Response response =  given().log().all()
                .header("content-type", "application/json")
                .header("accept", "application/json;version=1.1")
                .header("x-requested-with", "XMLHttpRequest")
                .body(userNotValidEmailData)
                .when().post("users/action/login/")
                .then().log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code != 200");
        JsonPath jsonPath = response.jsonPath();
        String error = jsonPath.get("error");
        Assert.assertEquals(error, ErrorMesageAPI.CHECKEMAIL.getMessage(), "Error message not equals expected result");
    }

    @Test
    public void postLoginNotValidPassword() {
        File userNotValidPasswordData = new File("src/test/resources/json/notValidPasswordUser.json");
        Response response = given().log().all()
                .header("content-type", "application/json")
                .header("accept", "application/json;version=1.1")
                .body(userNotValidPasswordData)
                .when().post("users/action/login/")
                .then().log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code != 200");
        JsonPath jsonPath = response.jsonPath();
        String error = jsonPath.get("error");
        Assert.assertEquals(error, ErrorMesageAPI.WRONGPASSWORD.getMessage(), "Error message not equals expected result");
    }

    @Test
    public void postLoginNotValidEmailAndPassword() {
        File notValidUser = new File("src/test/resources/json/notValidUser.json");
        Response response = given().log().all()
                .header("content-type", "application/json")
                .header("accept", "application/json;version=1.1")
                .body(notValidUser)
                .when().post("users/action/login/")
                .then().log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code != 200");
        JsonPath jsonPath = response.jsonPath();
        String error = jsonPath.get("error");
        Assert.assertEquals(error, ErrorMesageAPI.CHECKEMAIL.getMessage(), "Error message not equals expected result");
    }

}
