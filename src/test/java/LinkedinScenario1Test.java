import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

import org.testng.annotations.Test;

public class LinkedinScenario1Test {

    @Test

    public void linkedinScenario1() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "D:\\ForAutomation\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("registration-submit")).click();
        String alert = driver.findElement(By.xpath("//div[@class='reg-alert']/span[@class='alert-content']")).getText();
        assertTrue("Text not found!", alert.contains("Please enter your first name"));

    }
}
