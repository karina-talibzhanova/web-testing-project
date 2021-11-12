package framework.cucumber.stepdefs;

import framework.pom.pages.CommonPage;
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

public class LoginStepdefs{
    private WebDriver webDriver;
    private LoginPage loginPage;
    private CommonPage commonPage;

    @Before(order=0)
    public void setup(){
        Util.setDriverLocation(System.getenv("ChromeDriverPath"));
        webDriver= Util.getNewChromeDriver();
        loginPage= new LoginPage(webDriver); //starts from login page (makes sense because we always need to login)
    }


    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
    }

    @When("I input a valid username")
    public void iInputAValidUsername() {
        loginPage.inputUsername("standard_user");
    }

    @And("I input a valid password")
    public void iInputAValidPassword() {
        loginPage.inputPassword("secret_sauce");
    }

    @And("I click login")
    public void iClickLogin() {
        loginPage.clickLogin();
    }

    @Then("I am taken to the inventory page")
    public void iAmTakenToTheInventoryPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", loginPage.getURL());
    }

    @And("I input a invalid password")
    public void iInputAInvalidPassword() {
        loginPage.inputPassword("wrongpass@");
    }

    @Then("I am given the suitable error message")
    public void iAmGivenTheSuitableErrorMessage() {
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getErrorMessage());
    }

    @And("the input boxes are errored")
    public void theInputBoxesAreErrored() {
        Assertions.assertTrue(loginPage.isInputBoxesErrored());
    }

    @And("the input boxes display an error icon")
    public void theInputBoxesDisplayAnErrorIcon() {
        Assertions.assertTrue(loginPage.isErrorIconsVisible());
    }

    @When("I input a invalid username")
    public void iInputAInvalidUsername() {
        loginPage.inputUsername("wrongusername@");
    }

    @When("I leave username input blank")
    public void iLeaveUsernameInputBlank() {
        loginPage.inputUsername("");
    }

    @And("I leave password input blank")
    public void iLeavePasswordInputBlank() {
        loginPage.inputPassword("");
    }

    @Then("I am given a username error message")
    public void iAmGivenAUsernameErrorMessage() {
        Assertions.assertEquals("Epic sadface: Username is required", loginPage.getErrorMessage());
    }

    @Then("I am given the password error message")
    public void iAmGivenThePasswordErrorMessage() {
        Assertions.assertEquals("Epic sadface: Password is required", loginPage.getErrorMessage());
    }
    
}
