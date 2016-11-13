package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Methods for search page
 */
public class SearchPage extends BasePage {

    @FindBy(id = "advs-keywords")
    private WebElement keywordsField;

    @FindBy(id = "advs")
    private WebElement advancedSearchForm;

    @FindBy(xpath = "//div[@class ='description']")
    private List<WebElement> searchResultDescriptionList;

    @FindBy(xpath = "//div[@class='search-info']/p[contains(text(),'results for')]")
    private WebElement resultsForInfoText;

    private List<String> searchResultDescriptionStringList = new ArrayList<String>();

    /**
     * Get driver and init elements ont the page
     *
     * @param driver
     */
    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementsDisplayed(advancedSearchForm);
    }

    /**
     * Check is Search page is loaded already
     *
     * @return boolean true or false
     */
    public boolean isPageLoaded() {
        return waitUntilElementsDisplayed(keywordsField, 5).isDisplayed();
    }

    /**
     * Fill search keyword and click on "Submit' button
     *
     * @param searchTerm the parameter which should be found
     */
    public void fillKeywordSearchTermAndSubmit(String searchTerm) {
        waitUntilElementsDisplayed(keywordsField);
        keywordsField.sendKeys(searchTerm);
        keywordsField.submit();
        waitUntilElementsDisplayed(resultsForInfoText);
    }

    /**
     * Get results on the page and count it's number
     *
     * @return number of found results on the page
     */
    public int getSearchResultsOnPageCount() {
        return searchResultDescriptionList.size();
    }

    /**
     * Get the description of the each web element
     *
     * @return the string list of descriptions
     */
    public List<String> getDescriptionStringList() {
        for (WebElement searchResultDescriptionElement : searchResultDescriptionList) {
            searchResultDescriptionStringList.add(searchResultDescriptionElement.getText());
        }
        return searchResultDescriptionStringList;
    }

    /**
     * Checking of the term in description of found result
     *
     * @param searchTerm - term which is searched in description
     * @return boolean true or false
     */
    public boolean checkTermInDescription(String searchTerm) {
        for (int i = 0; i < searchResultDescriptionStringList.size(); i++) {
            if (!searchResultDescriptionStringList.get(i).contains(searchTerm))
                return false;
        }
        return true;
    }

}
