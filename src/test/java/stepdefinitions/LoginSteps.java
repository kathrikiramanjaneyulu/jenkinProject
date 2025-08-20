package stepdefinitions;

import io.cucumber.java.en.*;
import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("I open Facebook login page")
    public void openFacebookPage() {
        driver = BaseTest.getDriver();
        driver.get(BaseTest.getProp().getProperty("url"));
        loginPage = new LoginPage(driver);
    }

    @When("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @And("I click on login button")
    public void clickLoginButton() {
        loginPage.clickLogin();
    }

   
}
