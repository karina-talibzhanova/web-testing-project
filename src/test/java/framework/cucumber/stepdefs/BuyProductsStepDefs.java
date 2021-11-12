package framework.cucumber.stepdefs;

import framework.pom.interfaces.Cart;
import framework.pom.interfaces.Inventory;
import framework.pom.interfaces.Login;
import framework.pom.interfaces.Product;
import framework.pom.pages.CartPage;
import framework.pom.pages.InventoryPage;
import framework.pom.pages.LoginPage;
import framework.pom.pages.ProductPage;
import framework.pom.util.Util;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyProductsStepDefs {
    private WebDriver webDriver;
    private Inventory inventoryPage;
    private Product productPage;
    private CartPage cartPage;


    @Before(order=1)
    public void setup(){
        Util.setDriverLocation(System.getenv("ChromeDriverPath"));
        webDriver= Util.getWebDriver();
        Login loginPage= new LoginPage(webDriver); //starts from login page (makes sense because we always need to login)
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        inventoryPage = loginPage.clickLogin();
    }


    @Given("I am logged in")
    public void iAmLoggedIn() {
    }

    @When("I click Add to Cart to for an item on the inventory page")
    public void iClickAddToCartToForAnItemOnTheInventoryPage() {
        WebElement aProduct = webDriver.findElement(By.className("inventory_item"));
        inventoryPage.addProduct(aProduct);
    }

    @Then("the cart badge shows the total items in the cart")
    public void theCartBadgeShowsTheTotalItemsInTheCart() {
        Assertions.assertEquals("1", inventoryPage.cartNumber());
    }

    @And("I am on a product page")
    public void iAmOnAProductPage() {
        inventoryPage.goToProductPageViaTitle("Sauce Labs Backpack");
        productPage= new ProductPage(webDriver);
    }

    @When("I click Add to Cart for an item on the product page")
    public void iClickAddToCartForAnItemOnTheProductPage() {
        productPage.addToCart();
    }

    @Then("the item is added to cart")
    public void theItemIsAddedToCart() {
        productPage.goToCartPage();
    }


//    @When("I click Add to Cart for an item on the product page")
//    public void iClickAddToCartForAnItemOnTheProductPage() {
//        productPage.addToCart();
//    }
//
//    @Then("the item is added to cart")
//    public void theItemIsAddedToCart() {
//
//    }
//
//    @And("I have an item in cart")
//    public void iHaveAnItemInCart() {
////        inventoryPage.addProduct(webDriver.findElement(By.className("inventory_item")));
//    }
//
//    //ERROR BEGINS
//    @And("I am on the cart page")
//    public void iAmOnTheCartPage() {
////        cartPage = inventoryPage.goToCartPage();
//    }
//
//    @When("I click Remove")
//    public void iClickRemove() {
////        WebElement aProduct = webDriver.findElement(By.className("cart_item"));
////        cartPage.removeProducts(aProduct);
//    }
//
//    @Then("the item is removed from the cart")
//    public void theItemIsRemovedFromTheCart() {
//    }
//
//    @When("I checkout")
//    public void iCheckout() {
//    }
//
//    @And("I add information details")
//    public void iAddInformationDetails() {
//    }
//
//    @Then("the correct items will be shown in the checkout overview")
//    public void theCorrectItemsWillBeShownInTheCheckoutOverview() {
//    }
//
//    @Then("the correct total is shown in the checkout overview")
//    public void theCorrectTotalIsShownInTheCheckoutOverview() {
//    }
//
//    @Then("I am taken to the overview checkout page")
//    public void iAmTakenToTheOverviewCheckoutPage() {
//    }
//
//    @And("I click the sidebar")
//    public void iClickTheSidebar() {
//    }
//
//    @When("I click All Items")
//    public void iClickAllItems() {
//    }
//
//    @And("I am on a product page")
//    public void iAmOnAProductPage() {
//    }
//
//
//    @When("I click the {string} of an item")
//    public void iClickTheTitleOfAnItem(String title) {
//        productPage = inventoryPage.goToProductPageViaTitle(title);
//    }
//
//    @Then("I am taken to the product page with {string}")
//    public void iAmTakenToTheProductPage(String title) {
//        Assertions.assertEquals(title, productPage.getProductTitle());
//    }
//
//    @When("I click the image of an item")
//    public void iClickTheImageOfAnItem() {
//        webDriver.findElement(By.className("inventory_item_img")).click();
//        productPage = new ProductPage(webDriver);
//    }
//    @When("I click Remove for an item on the inventory page")
//    public void iClickRemoveForAnItemOnTheInventoryPage() {
//        WebElement aProduct = webDriver.findElement(By.className("inventory_item"));
//        inventoryPage.addProduct(aProduct);
//        inventoryPage.removeProduct(aProduct);
//    }

}
