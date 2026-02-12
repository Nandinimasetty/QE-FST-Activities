package demos;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import java.io.File; 

public class TestActvity22 {

    String baseUrl = "https://petstore.swagger.io/v2/user";

    @Test(priority = 0)
    public void createUser() {
        File input=new File("src/test/resources/input.json");
       

        Response response = given().contentType(ContentType.JSON)
        .body(input).when().post(baseUrl);

        response.prettyPrint();

        response.then().statusCode(200);
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("12038713"));
    }

    @Test (priority = 1)
    public void getUser() {
        Response response = given().contentType(ContentType.JSON)
        .pathParam("username", "nandini")
        .when().get(baseUrl + "/{username}");

        response.prettyPrint();

        response.then().statusCode(200);
    }

    @Test (priority = 2)
    public void deleteUser() {
        Response response = given().contentType(ContentType.JSON)
        .pathParam("username", "nandini")
        .when().delete(baseUrl + "/{username}");

        response = given().contentType(ContentType.JSON)
        .pathParam("username", "nandini")
        .when().get(baseUrl + "/{username}");

        response.then().statusCode(404);
    }

}