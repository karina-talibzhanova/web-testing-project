package framework.cucumber.stepdefs;

import framework.pom.interfaces.Inventory;
import framework.pom.interfaces.Login;
import framework.pom.pages.InventoryPage;
import framework.pom.pages.LoginPage;
import framework.pom.util.Util;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyProductsStepDefs {
    private WebDriver webDriver;
    private Inventory inventoryPage;

    @Before
    public void setup(){
      /*  Util.setDriverLocation(System.getenv("ChromeDriverPath"));
        webDriver= new ChromeDriver();
        Login loginPage= new LoginPage(webDriver); //starts from login page (makes sense because we always need to login)
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        inventoryPage = loginPage.clickLogin();
        */
    }

    @After
    public void tearDown(){
        webDriver.quit(); //Comment out to see process
    }


    @When("I click Add to Cart to for an item on the inventory page")
    public void iClickAddToCartToForAnItemOnTheInventoryPage() {
        WebElement aProduct = webDriver.findElement(By.className("inventory_item"));
        inventoryPage.addProduct(aProduct);
    }

    @When("I click Add to Cart for an item on the product page")
    public void iClickAddToCartForAnItemOnTheProductPage() {
    }

    @Then("the item is added to cart")
    public void theItemIsAddedToCart() {
    }

    @And("I am on the cart page")
    public void iAmOnTheCartPage() {
    }

    @When("I click Remove")
    public void iClickRemove() {
    }

    @Then("the item is removed from the cart")
    public void theItemIsRemovedFromTheCart() {
    }

    @When("I checkout")
    public void iCheckout() {
    }

    @And("I add information details")
    public void iAddInformationDetails() {
    }

    @Then("the correct items will be shown in the checkout overview")
    public void theCorrectItemsWillBeShownInTheCheckoutOverview() {
    }

    @Then("the correct total is shown in the checkout overview")
    public void theCorrectTotalIsShownInTheCheckoutOverview() {
    }

    @Then("I am taken to the overview checkout page")
    public void iAmTakenToTheOverviewCheckoutPage() {
    }

    @Then("the cart badge shows the total items in the cart")
    public void theCartBadgeShowsTheTotalItemsInTheCart() {
    }

    @And("I click the sidebar")
    public void iClickTheSidebar() {
    }

    @When("I click All Items")
    public void iClickAllItems() {
    }

    @And("I am on a product page")
    public void iAmOnAProductPage() {
    }

    @When("I click Back to Products")
    public void iClickBackToProducts() {
    }

    @And("I am on the checkout overview page")
    public void iAmOnTheCheckoutOverviewPage() {
    }

    @When("I click Cancel")
    public void iClickCancel() {
    }

    @When("I click Continue Shopping")
    public void iClickContinueShopping() {
    }

    @When("I click the title of an item")
    public void iClickTheTitleOfAnItem() {
    }

    @Then("I am taken to the product page")
    public void iAmTakenToTheProductPage() {
    }

    @When("I click the image of an item")
    public void iClickTheImageOfAnItem() {
    }

    @When("I click the cart badge")
    public void iClickTheCartBadge() {
    }

    @Then("I am taken to the cart page")
    public void iAmTakenToTheCartPage() {
    }

    @When("I click Remove for an item on the inventory page")
    public void iClickRemoveForAnItemOnTheInventoryPage() {
        WebElement aProduct = webDriver.findElement(By.className("inventory_item"));
        inventoryPage.addProduct(aProduct);
        inventoryPage.removeProduct(aProduct);
    }
}
