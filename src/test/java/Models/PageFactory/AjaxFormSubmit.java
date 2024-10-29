package Models.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AjaxFormSubmit {

    @FindBy(id = "title")
    private WebElement title;

    @FindBy(id = "description")
    private WebElement description;

    @FindBy(id = "btn-submit")
    private WebElement submitButton;

    @FindBy(id = "submit-control")
    private WebElement submitControl;

    private WebDriverWait wait;

    public AjaxFormSubmit(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String title, String description) {
        this.title.sendKeys(title);
        this.description.sendKeys(description);
    }

    public void submitForm() {
        submitButton.click();
    }

    public String getSubmitControlText() {
        wait.until(ExpectedConditions.visibilityOf(submitControl));
        return submitControl.getText();
    }
}
