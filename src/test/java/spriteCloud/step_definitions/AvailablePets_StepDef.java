package spriteCloud.step_definitions;

import io.cucumber.java.en.*;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.*;

public class AvailablePets_StepDef {

    Response response;


    @Given("User retrieves the list of all pets in the store")
    public void user_retrieves_the_list_of_all_pets_in_the_store() {
        response = given().headers("Content-Type", "application/json",
                        "Accept", "*/*")
                .queryParam("status", "available")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus");

    }

    @Then("all pets in the response should have the status {string}")
    public void all_pets_in_the_response_should_have_the_status(String string) {
        List<String> status = response.body().jsonPath().getList("status");

        for (String eachStatus : status) {
            Assert.assertEquals("available", eachStatus);
        }
    }


}
