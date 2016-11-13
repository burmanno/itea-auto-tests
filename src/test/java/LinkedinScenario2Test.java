import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class LinkedinScenario2Test {

    @Test

    public void LinkedinScenario2() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D:\\ForAutomation\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("reg-firstname")).sendKeys("TestName");
        Thread.sleep(1000);
        driver.findElement(By.id("reg-lastname")).sendKeys("TestLastname");
        Thread.sleep(1000);
        driver.findElement(By.id("reg-email")).sendKeys("test@gmail");
        Thread.sleep(1000);
        driver.findElement(By.id("reg-password")).sendKeys("qwerty123");
        Thread.sleep(1000);

        driver.findElement(By.id("registration-submit")).click();

        String alert = driver.findElement(By.xpath("//div[@class='reg-alert']/span[@class='alert-content']")).getText();
        assertTrue("Text not found!", alert.contains("Please enter a valid email address"));


    }

}
