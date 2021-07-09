package step;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.ChilliPharmLoginPageObject;

public class ChiliPharmLoginStepDefinition {


    private ChilliPharmLoginPageObject chilliPharmLoginPageObject;

    private WebDriver driver;

    @Before
    public void beforeScenario() {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\karol\\OneDrive\\Dokumenty\\projekty\\apzumi\\cucumberTests\\src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        chilliPharmLoginPageObject = new ChilliPharmLoginPageObject(driver);
    }

    @After
    public void afterScenario() {
        driver.quit();
    }

    static {
    }

    @Given("open sign in page")
    public void openSignInPage() {
        chilliPharmLoginPageObject.openSignInWebsite();
    }

    @Then("sign in page is opened")
    public void verifyIfSignInPageOpened(){
        chilliPharmLoginPageObject.at();
    }

    @When("user clicks Sign In button")
    public void userClicksSignInButton() {
        chilliPharmLoginPageObject.clickSignInButton();
    }

    @Then("validation error {} is visible")
    public void validationErrorEmailIsRequiredIsVisible(String errorText) {
        chilliPharmLoginPageObject.verifyIfValidationErrorIsVisible(errorText);
    }

    @When("login with username {} password {}")
    public void login(String username, String password) {
        chilliPharmLoginPageObject.login(username, password);
    }

    @Then("pop up {} is visible")
    public void popUpAccountLockoutWarninigIsVisible(String popUpTitle) {
        chilliPharmLoginPageObject.verifyIfPopUpIsVisible(popUpTitle);
    }
}
