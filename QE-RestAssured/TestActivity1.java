package demos;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

public class TestActivity1 {

    String baseUrl = "https://petstore.swagger.io/v2/pet";
    int petId = 12038713;

    @Test(priority = 0)
    public void createPet() {

        HashMap<String, Object> petData = new HashMap<>();
        petData.put("id", petId);
        petData.put("name", "Tommy");
        petData.put("status", "available");
        Response response = given().contentType(ContentType.JSON)
        .body(petData)
        .post(baseUrl);
        response.prettyPrint();
        response.then().statusCode(200);
        response.then().body("id", equalTo(petId));
        response.then().body("name", equalTo("Tommy"));
        response.then().body("status", equalTo("available"));
    }

    @Test
    public void getPet() {

        Response response = given().contentType(ContentType.JSON)
        .pathParam("petId", petId)
        .get(baseUrl + "/{petId}");
        response.prettyPrint();
        response.then().statusCode(200);
        response.then().body("id", equalTo(petId));
    }

    @Test(priority = 2)
    public void deletePet() {
        
        Response response = given().contentType(ContentType.JSON)
        .pathParam("petId", petId)
        .delete(baseUrl + "/{petId}");
        response.prettyPrint();
        response.then().statusCode(200);
        response = given().contentType(ContentType.JSON)
        .pathParam("petId", petId)
        .get(baseUrl + "/{petId}");
        response.then().statusCode(404);
    }
}
