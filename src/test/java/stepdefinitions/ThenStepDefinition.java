package stepdefinitions;

import apivalidation.CollectionApi;
import com.pojo.collection.CollectionResponse;
import com.pojo.collection.CountFacets;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import utils.Reusable;

import java.util.List;
import java.util.Map;

public class ThenStepDefinition extends Reusable {
    CollectionApi collect = new CollectionApi();

    @Then("check the countFacets object values in the response")
    public void check_the_countFacets_object_values_in_the_response(DataTable table) {
        // Write code here that turns the phrase above into concrete actions
        try {
            List<Map<String, String>> dt = table.asMaps();
            int hasExpected = Integer.parseInt(dt.get(0).get("hasimage"));
            int ondispExpected = Integer.parseInt(dt.get(0).get("ondisplay"));
            collect.verifyCountFacets(WhenStepDefinition.collectionresponse, hasExpected, ondispExpected);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
