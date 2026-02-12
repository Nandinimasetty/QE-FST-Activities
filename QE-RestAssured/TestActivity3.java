package demos;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;

public class TestActivity3 {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    
    @BeforeClass
    public void setup() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .setContentType(ContentType.JSON)
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("status", equalTo("alive"))
                .build();
    }
    @Test(priority = 0)
    public void addPets() {
        HashMap<String, Object> pet1 = new HashMap<>();
        pet1.put("id", 77232);
        pet1.put("name", "Riley");
        pet1.put("status", "alive");
        Response response = given()
                .spec(requestSpec)
                .body(pet1)
                .post();
        System.out.println("POST RESPONSE - Riley");
        response.prettyPrint();
        response.then().spec(responseSpec);
        HashMap<String, Object> pet2 = new HashMap<>();
        pet2.put("id", 77233);
        pet2.put("name", "Hansel");
        pet2.put("status", "alive");
        response = given()
                .spec(requestSpec)
                .body(pet2)
                .post();
        System.out.println("POST RESPONSE - Hansel");
        response.prettyPrint();
        response.then().spec(responseSpec);
    }
    @DataProvider(name = "petData")
    public Object[][] getPetData() {
        return new Object[][] {
            { 77232, "Riley", "alive" },
            { 77233, "Hansel", "alive" }
        };
    }
    @Test(priority = 1, dataProvider = "petData")
    public void getPet(int id, String name, String status) {
        Response response = given()
                .spec(requestSpec)
                .pathParam("petId", id)
                .get("/{petId}");
        System.out.println("GET RESPONSE - Pet ID : " + id);
        response.prettyPrint();
        response.then()
                .spec(responseSpec)
                .body("id", equalTo(id))
                .body("name", equalTo(name))
                .body("status", equalTo(status));
    }
    @Test(priority = 2, dataProvider = "petData")
    public void deletePet(int id, String name, String status) {
        Response response = given()
                .spec(requestSpec)
                .pathParam("petId", id)
                .delete("/{petId}");
        System.out.println("DELETE RESPONSE - Pet ID : " + id);
        response.prettyPrint();
        response.then()
                .statusCode(200)
                .body("message", equalTo(String.valueOf(id)));
    }
}



