import org.testng.Assert;
import org.testng.annotations.*;
import page.HomePage;
import page.LoginRegistrationPage;
import page.SearchPage;

/**
 * Tests for advanced search
 */
public class AdvancedSearchTests extends BaseTest{

    public HomePage homePage;

    @BeforeClass
    public void beforeTest(){
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        homePage = registrationPage.loginFormFillAndSubmit("whatevertest35@gmail.com", "!QAZ2w3e");
        Assert.assertTrue(homePage.isPageLoaded());
    }

    @DataProvider(name = "searchTerms")
    public Object[][] searchTermsData() {
        return new Object[][] {
                { "HR","HR" },
                { "hr","hr" },
        };
    }

    @Test(dataProvider = "searchTerms")
    public void advancedSearchTest(String searchTerm, String expectedContainedTerm){
        SearchPage searchPage = homePage.clickAdvancedSearchLink();
        Assert.assertNotNull(searchPage,"Search page is not loaded");
        searchPage.fillKeywordSearchTermAndSubmit(searchTerm);
        Assert.assertEquals(searchPage.getSearchResultsOnPageCount(), 10, "Actual results on page number is wrong!");
        searchPage.getDescriptionStringList();
        Assert.assertTrue(searchPage.checkTermInDescription(expectedContainedTerm),"Expected searched term is not found in results list!");

    }
}
