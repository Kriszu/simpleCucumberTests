package pageobject;

import helpers.Helpers;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChilliPharmLoginPageObject {

    private WebDriver driver;

    private Helpers helper;

    private By signInHeader = By.xpath("//div//h1[contains(text(), 'Sign in')]");
    private By signInButton = By.xpath("//input[@value='Sign in']");
    private By emailInput = By.xpath("//input[@id='user_email']");
    private By passwordInput = By.xpath("//input[@type='password']");

    By validationError(String error) {
        return By.xpath("//li[contains(text(), '" + error + "')] | //div[contains(text(), '" + error + "')] ");
    }

    By popUp(String title) {
        return By.xpath("//div[@class='popupbox-titleBar']//span[contains(text(), '" + title + "')]");
    }

    public ChilliPharmLoginPageObject(WebDriver driver) {
        this.driver = driver;
        this.helper = new Helpers(driver);
    }

    public void at() {
        helper.waintUntilVisible(driver.findElement(signInHeader));
    }

    public void openSignInWebsite() {
        driver.get("https://chillipharm.com/sign_in");
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void verifyIfValidationErrorIsVisible(String errorText) {
        driver.findElement(validationError(errorText)).isDisplayed();
    }

    public void login(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        driver.findElement(signInButton).click();
    }

    private void fillEmail(String email) {
        WebElement emailElement = driver.findElement(emailInput);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    private void fillPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordInput);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void verifyIfPopUpIsVisible(String popUpTitle) {
        helper.waintUntilVisible(driver.findElement(popUp(popUpTitle)));
    }
}
