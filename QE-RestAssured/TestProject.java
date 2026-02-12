package demos;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestProject {

    RequestSpecification requestSpec;
    String sshKey;
    int keyId;

    @BeforeClass
    public void setup() {

        sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIPXdbudP2oO6clLkoZIC6+n0e374hOMOBAm/ZUeohC92 masetty28nandini@gmail.com"; // replace with valid SSH key

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","token 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")
                .build();

        RestAssured.requestSpecification = requestSpec;
    }

    // ---------------- POST REQUEST ----------------
    @Test(priority = 1)
    public void addSSHKey() {

        String requestBody = "{\n" +
                "  \"title\": \"TestAPIKey\",\n" +
                "  \"key\": \"" + sshKey + "\"\n" +
                "}";

        Response response =
                RestAssured
                        .given()
                        .body(requestBody)
                        .when()
                        .post("/user/keys")
                        .then()
                        .extract()
                        .response();

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 201);

        keyId = response.jsonPath().getInt("id");
        Assert.assertTrue(keyId > 0);

        Reporter.log("SSH Key created with ID: " + keyId, true);
    }

    // ---------------- GET REQUEST ----------------
    @Test(priority = 2)
    public void getSSHKey() {

        Response response =
                RestAssured
                        .given()
                        .pathParam("keyId", keyId)
                        .when()
                        .get("/user/keys/{keyId}")
                        .then()
                        .extract()
                        .response();

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("id"), String.valueOf(keyId));

        Reporter.log("Fetched SSH Key with ID: " + keyId, true);
    }

    // ---------------- DELETE REQUEST ----------------
    @Test(priority = 3)
    public void deleteSSHKey() {

        Response response =
                RestAssured
                        .given()
                        .pathParam("keyId", keyId)
                        .when()
                        .delete("/user/keys/{keyId}")
                        .then()
                        .extract()
                        .response();

        Assert.assertEquals(response.getStatusCode(), 204);

        Reporter.log("Deleted SSH Key with ID: " + keyId, true);
    }
}
