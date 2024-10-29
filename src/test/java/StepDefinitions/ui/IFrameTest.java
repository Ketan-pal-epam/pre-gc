package StepDefinitions.ui;

import Utils.BrowserFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class IFrameTest {
    WebDriver driver ;
    @Given("i click Simple I Frame Container")
    public void clickContainr(){
        driver = BrowserFactory.getdriver();
        driver.findElement(By.linkText("iFrame Demo")).click();
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='iFrame1']"));
//        driver.navigate().;
        driver.switchTo().frame(frame1);



    }
    @Then("i should be able to enter {}")
    public void enterText(String arg){
        Actions action = new Actions(driver);
        WebElement inputBox =driver.findElement(By.xpath("//div[text()='Your content.']"));
        inputBox.click();
        action.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
        inputBox.sendKeys(arg);
    }
}
