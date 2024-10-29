import Utils.ConfigReader;
import Utils.Listener;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class randomTest {
    RemoteWebDriver driver;
    @Test()
    public void test() throws MalformedURLException {
        String baseUrl = ConfigReader.getProperty("ui-base-url");
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-ketanpal2002-6d497");
        sauceOptions.put("accessKey", "");
        sauceOptions.put("build", "selenium-build-L0P08");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[text()='Allow all']")).click();
        driver.findElement(By.linkText("iFrame Demo")).click();
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='iFrame1']"));
        driver.switchTo().frame(frame1);
        Actions action = new Actions(driver);
        WebElement inputBox =driver.findElement(By.xpath("//div[text()='Your content.']"));
        inputBox.click();
        action.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
        inputBox.sendKeys("hello World!");
        driver.executeScript("sauce:job-result=" + "passed");
        driver.quit();
        String a ="hey";
        String b = "hi";
        a=a.concat(b);
    }
}
