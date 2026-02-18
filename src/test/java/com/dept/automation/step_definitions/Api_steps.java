package com.dept.automation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Api_steps {

    private Response response;

    @Given("I call OpenLibrary author API for {string}")
    public void iCallOpenLibraryAuthorApiFor(String authorId) {
        response = given()
                .baseUri("https://openlibrary.org")
                .when()
                .get("/authors/" + authorId + ".json");
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        assertNotNull("Response is null", response);
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response should have personal_name {string}")
    public void theResponseShouldHavePersonalName(String expectedName) {
        String actual = response.jsonPath().getString("personal_name");
        assertEquals("personal_name mismatch", expectedName, actual);
    }

    @Then("the response should contain alternate_name {string}")
    public void theResponseShouldContainAlternateName(String expectedAltName) {
        List<String> altNames = response.jsonPath().getList("alternate_names");
        assertNotNull("alternate_names is null", altNames);
        assertTrue("alternate_names does not contain: " + expectedAltName,
                altNames.contains(expectedAltName));
    }
}