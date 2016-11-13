import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;
public class CheeseCakeTest {

    @Test

    public void listCheesecakes() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver","D:\\ForAutomation\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.thecheesecakefactory.com/");
        driver.findElement(By.id("closeBtn")).click();

        //WebElement menu = driver.findElement(By.className("head-menu"));
        WebElement menu = driver.findElement(By.xpath("//a[@href='/menu/']"));
        Thread.sleep(1000);
        menu.click();

        //WebElement desserts = driver.findElement(By.linkText("Desserts"));
        WebElement desserts = driver.findElement(By.xpath("//a[@href='/menu/desserts/']"));
        Thread.sleep(1000);
        desserts.click();

        WebElement cheesecake = driver.findElement(By.linkText("Cheesecakes"));
        Thread.sleep(1000);
        cheesecake.click();

        List<WebElement> cheesecakes = driver.findElements(By.xpath("//a[contains(@href,'/menu/desserts/cheesecakes/')]/span[@class='item-title']"));
        System.out.println(cheesecakes.size() + "cheesecakes:");

        for (int i=0; i< cheesecakes.size(); i++) {
            System.out.println(i+1 + "." + cheesecakes.get(i).getText());
        }

    }

}
