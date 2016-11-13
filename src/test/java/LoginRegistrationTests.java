import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;
import page.SearchPage;

/**
 * Tests of login and registration user
 */
public class LoginRegistrationTests extends BaseTest {

    @DataProvider(name = "errorMessages")
    public Object[][] searchTermsData() {
        return new Object[][]{
                {"", "", "", "", "Укажите имя"},
                {"FirstName", "", "", "", "Укажите фамилию"},
                {"", "LastName", "", "", "Укажите свой адрес электронной почты"},
                {"", "", "test@gmail.com", "", "Укажите пароль"},

        };
    }

    /**
     * Check the correctness of displaying error message on submit with different filled parameters in form.
     */
    @Test(dataProvider = "errorMessages")
    public void errorMessageOnFormSubmit(String firstName, String lastName, String email, String password, String errorMessage) {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        registrationPage.registrationFormFillAndSubmit(firstName, lastName, email, password);
        Assert.assertEquals(registrationPage.getErrorMessageText(), errorMessage, "Expected error message was not found on page!");
    }

    /**
     * Check the successful login of the user
     */
    @Test
    public void successfulLoginTest() {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        HomePage homePage = registrationPage.loginFormFillAndSubmit("whatevertest35@gmail.com", "!QAZ2w3e");
        Assert.assertTrue(homePage.isPageLoaded());

    }

    /**
     * Check the searched term in each found result on the page
     */

    @Test
    public void advancedSearchUpperCaseTest() {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        HomePage homePage = registrationPage.loginFormFillAndSubmit("whatevertest35@gmail.com", "!QAZ2w3e");
        Assert.assertTrue(homePage.isPageLoaded());
        SearchPage searchPage = homePage.clickAdvancedSearchLink();
        Assert.assertNotNull(searchPage, "Search page is not loaded");
        searchPage.fillKeywordSearchTermAndSubmit("HR");
        Assert.assertEquals(searchPage.getSearchResultsOnPageCount(), 10, "Actual results on page number is wrong!");
        searchPage.getDescriptionStringList();
        Assert.assertTrue(searchPage.checkTermInDescription("HR"));

    }
}
