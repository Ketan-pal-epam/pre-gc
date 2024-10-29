package StepDefinitions.ui;

import Utils.BrowserFactory;
import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class UiGlobals {

    String baseUrl = ConfigReader.getProperty("ui-base-url");
    //public static WebDriver driver;
    public static RemoteWebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-ketanpal2002-6d497");
        sauceOptions.put("accessKey", "40d0111b-f5a4-4fce-b9fc-a5167f679c2d");
        sauceOptions.put("build", "selenium-build-L0P08");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[text()='Allow all']")).click();
//        driver = BrowserFactory.getdriver();
//        driver.get(baseUrl);
    }

    @Given("I click link {string}")
    public void iClickLink(String arg0) {
        driver.findElement(By.linkText(arg0)).click();
    }

    @After
    public void tearDown(Scenario scenario) {
        String jobStatus = scenario.isFailed()?"failed":"passed";
        driver.executeScript("sauce:job-result=" + jobStatus);
        driver.quit();
        //BrowserFactory.closeDriver();
    }
}
