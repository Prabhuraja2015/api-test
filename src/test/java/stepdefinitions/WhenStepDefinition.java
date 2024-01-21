package stepdefinitions;

import com.pojo.collection.CollectionResponse;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import utils.ApiResources;
import utils.Reusable;

import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class WhenStepDefinition extends Reusable {
    RequestSpecification reqAct;
    static Response response;
    static CollectionResponse collectionresponse = new CollectionResponse();

    @When("user call get method on {string} api")
    public void user_call_get_method_on_api(String resource)  throws IOException {
        // Write code here that turns the phrase above into concrete actions
        try {
            ApiResources resources = ApiResources.valueOf(resource);
            reqAct = given().spec(requestSpecification());
            response = reqAct
                    .when()
                    .get(resources.getResource())
                    .then()
                    .spec(responseSpecification())
                    .extract()
                    .response();
            collectionresponse = response.as(CollectionResponse.class);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
