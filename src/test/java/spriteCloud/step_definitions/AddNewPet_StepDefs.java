package spriteCloud.step_definitions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import io.cucumber.java.en.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import spriteCloud.pojo.Pet;

import static io.restassured.RestAssured.*;

public class AddNewPet_StepDefs {

   // this allows to use response in following steps
    Response response;


     String petString;
     Pet pet;

     // below this lines will generate unique id
     private Faker faker = new Faker();
     int id = faker.random().nextInt(10000);


    @Given("the pet data to be added")
    public void the_pet_data_to_be_added() throws JsonProcessingException {


        petString ="{\n" +
                "  \"id\": " +id+",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"TayyipcikVeSusluSulo\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        ObjectMapper objectMapper=new ObjectMapper();
        pet=objectMapper.readValue(petString, Pet.class);

                System.out.println("pet = " + pet);


    }
    @When("user add a new pet is to the store")
    public void user_add_a_new_pet_is_to_the_store() {

         response = given().headers("Content-Type","application/json",
                         "Accept","*/*")
                .body(pet)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .prettyPeek();

    }
    @Then("the response should indicate a successful addition of the pet")
    public void the_response_should_indicate_a_successful_addition_of_the_pet() {
     response
             .then().contentType(ContentType.JSON)
             .statusCode(200);

     long actualID = (response.body().jsonPath().getLong("id"));
     Assert.assertEquals(id,actualID);

    }


}
