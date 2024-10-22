package StepDefinitions.api;

import Models.Address;
import Utils.ConfigReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIGlobals {
    public static String endpoint;
    public static Response response;

    @Before
    public void refresh() {
        endpoint = ConfigReader.getProperty("api-base-url");
    }
    @Given("I have access to the API endpoint {string}")
    public void iHaveAccessToTheAPIEndpoint(String arg0) {
        endpoint += arg0;
    }
    @Given("I add parameter {string} to the request {}")
    public void iAddParameterToTheRequest(String arg0, String arg1) {
        response = given()
                .queryParam(arg0, arg1)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
}
