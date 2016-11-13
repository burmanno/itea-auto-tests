package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Methods for Home page
 */
public class HomePage extends BasePage {

    @FindBy(id = "advanced-search")
    private WebElement advancedSearchLink;

    @FindBy(xpath = "//div[@id='main-site-nav']//a[@class='nav-link' and @href='/home?trk=nav_responsive_tab_home']")
    private WebElement homeMenuLink;


    /**
     * Get driver and initialization of elements
     *
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Check is Home page is loaded already
     *
     * @return boolean true or false
     */
    public boolean isPageLoaded() {
        return waitUntilElementsDisplayed(homeMenuLink, 5).isDisplayed();
    }

    /**
     * Click  on advance search link in HomePage
     *
     * @return return SearchPage
     */
    public SearchPage clickAdvancedSearchLink() {
        advancedSearchLink.click();
        return new SearchPage(driver);
    }
}
