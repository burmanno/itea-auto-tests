package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * General methods for pages
 */
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**Navigate to set URL
     * @param url URL which should be opened in browser
     */
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    /**
     * Explicitly waiting for WebElement visibility with set time
     *
     * @param element WebElement that will be explicitly waited
     * @param timeout Maximum wait time in seconds
     * @return WebElement that was explicitly waited
     */
    public WebElement waitUntilElementsDisplayed(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));

    }

    /**
     * Explicitly waiting for WebElement visibility for 10 seconds
     *
     * @param element WebElement that will be explicitly waited
     * @return WebElement that was explicitly waited
     */
    public WebElement waitUntilElementsDisplayed(WebElement element) {
        return waitUntilElementsDisplayed(element, 10);
    }

    /**
     * Gets current browser URL.
     *
     * @return String with current URL value.
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
