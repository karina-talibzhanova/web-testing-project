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

public class MyStepdefs {
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
}
