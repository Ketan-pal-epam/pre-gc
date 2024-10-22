package StepDefinitions.api;

import Models.Books;
import Models.ResponseBody;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import static StepDefinitions.api.APIGlobals.*;
import static io.restassured.RestAssured.given;

public class BooksTest {
    List<Books> books;
    Books singleBook;

    @When("I get all books")
    public void iGetAllBooks() {
        response = given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
        ResponseBody<Books> responseBody = response.as(new TypeRef<ResponseBody<Books>>() {});
        books = responseBody.getData();
    }

    @Then("I should get a list of books")
    public void iShouldGetAListOfBooks() {
        Assert.assertFalse(books.isEmpty());
    }

    @When("I get {} no. of books")
    public void iGetNoOfBooks(String arg0) {
        response = given()
                .queryParam("_quantity", arg0)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
        ResponseBody<Books> responseBody = response.as(new TypeRef<ResponseBody<Books>>() {});
        books = responseBody.getData();
    }

    @Then("I should get {} no. of books")
    public void iShouldGetNoOfBooks(String arg0) {
        Assert.assertEquals(books.size(), Integer.parseInt(arg0));
    }
}
