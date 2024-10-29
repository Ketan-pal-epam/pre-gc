package StepDefinitions.ui;


import Models.PageFactory.AjaxFormSubmit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AjaxFormDefs {

    @When("I submit the form with name {} and message {}")
    public void iSubmitTheFormWithNameAndMessage(String arg0, String arg1) {
        AjaxFormSubmit ajaxFormSubmit = new AjaxFormSubmit(UiGlobals.driver);
        ajaxFormSubmit.fillForm(arg0, arg1);
        ajaxFormSubmit.submitForm();
    }

    @Then("I should see the message {}")
    public void iShouldSeeTheMessage(String arg0) {
        AjaxFormSubmit ajaxFormSubmit = new AjaxFormSubmit(UiGlobals.driver);
        Assert.assertEquals(ajaxFormSubmit.getSubmitControlText(), arg0);
    }
}
