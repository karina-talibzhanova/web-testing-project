package framework.cucumber.stepdefs;

import framework.pom.interfaces.Cart;
import framework.pom.interfaces.Inventory;
import framework.pom.pages.InventoryPage;
import framework.pom.pages.LoginPage;
import framework.pom.util.Util;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavStepDefs {
    private WebDriver webDriver;
    private LoginPage loginPage;
    private Cart cartPage;
    private Inventory inventoryPage;

    @Before(order=2)
    public void setup(){
        Util.setDriverLocation(System.getenv("ChromeDriverPath"));
        webDriver= Util.getWebDriver();
        inventoryPage = new InventoryPage(webDriver);
    }


    @When("I click Reset App State")
    public void iClickResetAppState() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_sidebar_link")));
        inventoryPage.clickResetAppState();
    }

    @Then("The app state will reset to default")
    public void theAppStateWillResetToDefault() {
        cartPage = inventoryPage.goToCartPage();
        Assertions.assertEquals(0, cartPage.getAllProducts().size());
    }

    @When("I click the dropdown menu icon")
    public void iClickTheDropdownMenuIcon() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));
        inventoryPage.openSideBar();
    }

    @And("I click About")
    public void iClickAbout() {
        inventoryPage.goToCompanyAboutPage();
    }

    @Then("the company's page will load")
    public void theCompanySPageWillLoad() {
        Assertions.assertEquals("https://saucelabs.com/",inventoryPage.getUrl());
    }

    @Then("I will see links to All Items, About, Logout and Reset App State")
    public void iWillSeeLinksToAllItemsAboutLogoutAndResetAppState() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_sidebar_link")));
        Assertions.assertTrue(inventoryPage.sidebarLinksValid());
    }

    @When("I am at the bottom of the page")
    public void iAmAtTheBottomOfThePage() {
        WebElement footer = webDriver.findElement(By.className("footer"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", footer);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I click on the Twitter icon")
    public void iClickOnTheTwitterIcon() {
        inventoryPage.goToCompanyTwitterPage();
    }

    @Then("the companies Twitter page should load")
    public void theCompaniesTwitterPageShouldLoad() {
        Assertions.assertEquals("https://twitter.com/saucelabs", webDriver.getCurrentUrl());
    }

    @And("I click on the Facebook icon")
    public void iClickOnTheFacebookIcon() {
        inventoryPage.goToCompanyFacebookPage();
    }

    @Then("the companies Facebook page should load")
    public void theCompaniesFacebookPageShouldLoad() {
        Assertions.assertEquals("https://www.facebook.com/saucelabs", inventoryPage.getUrl());
    }

    @And("I click on the Linkedin icon")
    public void iClickOnTheLinkedinIcon() {
        inventoryPage.goToCompanyLinkedInPage();
    }

    @Then("the companies Linkedin page should load")
    public void theCompaniesLinkedinPageShouldLoad() {

        Assertions.assertEquals("https://www.linkedin.com/company/sauce-labs/", inventoryPage.getUrl());

    }
}
