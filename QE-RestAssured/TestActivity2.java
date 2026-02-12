package demos;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestActivity2{

    static String username;

    @BeforeClass
    public void setup() {
        baseURI = "https://petstore.swagger.io/v2";
        username = "nandini_user";
    }
    @Test
    public void createUser() {
        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 101);
        requestBody.put("username", username);
        requestBody.put("firstName", "Nandini");
        requestBody.put("lastName", "Masetty");
        requestBody.put("email", "nandini@gmail.com");
        requestBody.put("password", "password123");
        requestBody.put("phone", "9999999999");
        requestBody.put("userStatus", 1);
        Response response =
            given()
                .header("Content-Type", "application/json")
                .body(requestBody)
            .when()
                .post("/user")
            .then()
                .statusCode(200)
                .extract().response();
        System.out.println("POST Response:");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.jsonPath().getInt("code"), 200);
    }
    @Test
    public void getUser() {
        Response response =
            given()
            .when()
                .get("/user/" + username)
            .then()
                .statusCode(200)
                .extract().response();

        System.out.println("GET Response:");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.jsonPath().getString("username"), username);
    }
    @Test
    public void deleteUser() {
        Response response =
            given()
            .when()
                .delete("/user/" + username)
            .then()
                .statusCode(404)
                .extract().response();

        System.out.println("DELETE Response:");
        System.out.println(response.asPrettyString());
        Assert.assertTrue(response.asString().contains(username));
    }
}
