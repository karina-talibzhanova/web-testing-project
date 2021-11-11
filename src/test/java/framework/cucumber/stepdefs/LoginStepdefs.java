package framework.cucumber.stepdefs;

import framework.pom.pages.LoginPage;
import framework.pom.util.Util;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepdefs {
    private WebDriver webDriver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        Util.setDriverLocation("src/test/resources/chromedriver.exe");
        webDriver= new ChromeDriver();
        loginPage= new LoginPage(webDriver); //starts from login page (makes sense because we always need to login)
    }

    @After
    public void tearDown(){
        webDriver.quit(); //Comment out to see process
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
    }

    @When("I input a valid username")
    public void iInputAValidUsername() {
        loginPage.inputName("standard_user");
    }

    @And("I input a valid password")
    public void iInputAValidPassword() {
        loginPage.inputPass("secret_sauce");
    }
    @And("I click login")
    public void iClickLogin() {
        loginPage.clickLogin();
    }

    @Then("I am taken to the inventory page")
    public void iAmTakenToTheInventoryPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", webDriver.getCurrentUrl());
    }

    @And("I input a invalid password")
    public void iInputAInvalidPassword() {
        loginPage.inputPass("invalid@");
    }

    @Then("I am given an error message")
    public void iAmGivenAnErrorMessage() {
        Assertions.assertTrue(loginPage.checkErrorMessageExists());
    }

    @When("I input a invalid username")
    public void iInputAInvalidUsername() {
        loginPage.inputName("invalid@");
    }

    @When("I leave username input blank")
    public void iLeaveUsernameInputBlank() {
        loginPage.inputName("");
    }

    @And("I leave password input blank")
    public void iLeavePasswordInputBlank() {
        loginPage.inputPass("");
    }

    @Then("I am given an error message saying Username is required")
    public void iAmGivenAnErrorMessageSayingUsernameIsRequired() {
        Assertions.assertTrue(loginPage.checkMissingUsernameErrorMessage());
    }

    @Then("I am given an error message saying Password is required")
    public void iAmGivenAnErrorMessageSayingPasswordIsRequired() {
        Assertions.assertTrue(loginPage.checkMissingPasswordErrorMessage());
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        loginPage.inputName("standard_user");
        loginPage.inputPass("secret_sauce");
        loginPage.clickLogin();
    }
//
//    @When("I click logout")
//    public void iClickLogout() {
//        productsPage.openSidebar();
//        productsPage.clickLogout();
//    }
//
//    @Then("I will be directed to the logout page")
//    public void iWillBeDirectedToTheLogoutPage() {
//        Assertions.assertEquals("https://www.saucedemo.com/",webDriver.getCurrentUrl());
//    }
}
