package StepDefinitions.api;

import Models.Address;
import Models.ResponseBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.testng.Assert;
import static StepDefinitions.api.APIGlobals.*;

import java.util.List;

import static io.restassured.RestAssured.given;

public class AddressesTest {
    Address singleAddress;
    List<Address> addresses;

    @When("I get all addresses")
    public void iGetAllAddresses() {
        response = given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();

        ResponseBody<Address> responseBody = response.as(new TypeRef<ResponseBody<Address>>() {});
        addresses = responseBody.getData();
    }

    @Then("I should get a list of addresses")
    public void iShouldGetAListOfAddresses() {
        Assert.assertFalse(addresses.isEmpty());
    }

    @When("I get {} no. of addresses")
    public void iGetNoOfAddresses(String arg0) {
        response = given()
                .queryParam("_quantity", arg0)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();

        ResponseBody<Address> responseBody = response.as(new TypeRef<ResponseBody<Address>>() {});
        addresses = responseBody.getData();
    }

    @Then("I should get {} no. of addresses")
    public void iShouldGetNoOfAddresses(String arg0) {
        Assert.assertEquals(addresses.size(), Integer.parseInt(arg0));
    }



    @When("I get address by country code {}")
    public void iGetAddressByCountryCode(String arg0) {
        addresses = response.as(new TypeRef<ResponseBody<Address>>() {}).getData();

    }

    @Then("I should get address with country code {}")
    public void iShouldGetAddressWithCountryCode(String arg0) {
        for (Address address: addresses) {
            Assert.assertEquals(address.getCountry_code(), arg0);
        }
    }


}
