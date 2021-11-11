package framework.cucumber.stepdefs;

import framework.pom.pages.CartPage;
import framework.pom.pages.CommonPage;
import framework.pom.pages.LoginPage;
import framework.pom.util.Util;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavStepDefs {
    private WebDriver webDriver;
    private CommonPage commonPage;
    private CartPage cartPage;
    private LoginPage loginPage;


    @Before
    public void setup(){
        Util.setDriverLocation("src/test/resources/chromedriver.exe");
        webDriver= new ChromeDriver();
        loginPage= new LoginPage(webDriver);

    }

    @When("I click Reset App State")
    public void iClickResetAppState() {
    }

    @Then("The app state will reset to default")
    public void theAppStateWillResetToDefault() {

    }

    @When("I click the dropdown menu icon")
    public void iClickTheDropdownMenuIcon() {
        commonPage.openSideBar();
    }

    @And("I click About")
    public void iClickAbout() {

    }

    @Then("the company's page will load")
    public void theCompanySPageWillLoad() {
    }

    @Then("I will see links to All Items, About, Logout and Reset App State")
    public void iWillSeeLinksToAllItemsAboutLogoutAndResetAppState() {
        Assertions.assertTrue(commonPage.sidebarLinksValid());
    }

    @When("I am at the bottom of the page")
    public void iAmAtTheBottomOfThePage() {
    }

    @And("I click on the Twitter icon")
    public void iClickOnTheTwitterIcon() {
    }

    @Then("the companies Twitter page should load")
    public void theCompaniesTwitterPageShouldLoad() {
    }

    @And("I click on the Facebook icon")
    public void iClickOnTheFacebookIcon() {
    }

    @Then("the companies Facebook page should load")
    public void theCompaniesFacebookPageShouldLoad() {
    }

    @And("I click on the Linkedin icon")
    public void iClickOnTheLinkedinIcon() {
    }

    @Then("the companies Linkedin page should load")
    public void theCompaniesLinkedinPageShouldLoad() {
    }
}
