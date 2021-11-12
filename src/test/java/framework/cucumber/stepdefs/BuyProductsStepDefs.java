package framework.cucumber.stepdefs;

import framework.pom.interfaces.*;
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

import java.util.List;


public class BuyProductsStepDefs {
    private WebDriver webDriver;
    private Inventory inventoryPage;
    private Product productPage;
    private Cart cartPage;
    private CheckoutInformation checkoutInformationPage;
    private CheckoutOverview checkoutOverviewPage;


    @Before(order=1)
    public void setup(){
        Util.setDriverLocation(System.getenv("ChromeDriverPath"));
        webDriver= Util.getWebDriver();
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        inventoryPage = Util.login("standard_user", "secret_sauce");
    }

    @When("I click Add to Cart to for an item on the inventory page")
    public void iClickAddToCartToForAnItemOnTheInventoryPage() {
        WebElement aProduct = webDriver.findElement(By.className("inventory_item"));
        inventoryPage.addProduct(aProduct);
    }



    @Then("the cart badge shows the {int} total items in the cart")
    public void theCartBadgeShowsTheTotalItemsInTheCart(int number) {
        Assertions.assertEquals(number, inventoryPage.cartNumber());
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


    @When("I click Continue Shopping")
    public void iClickContinueShopping() {
        inventoryPage.goToCartPage().goToInventory();
    }


    @Then("I do not go to the overview checkout page")
    public void iDoNotGoToTheOverviewCheckoutPage() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", webDriver.getCurrentUrl());
    }

    @And("I see an appropriate error response")
    public void iSeeAnAppropriateErrorResponse() {
        checkoutInformationPage.isInputBoxesErrored();
        Assertions.assertTrue(checkoutInformationPage.isErrorIconsVisible() && checkoutInformationPage.isInputBoxesErrored());
    }

    @And("I don't add all information {string}")
    public void iDonTAddAllInformation(String arg) {
        List<String> details = new java.util.ArrayList<>(List.of(arg.split(",")));
        for (int i = 0; i < details.size(); i++) {
            details.set(i, details.get(i).trim());
        }
        System.out.println(details);
        checkoutInformationPage.enterShippingDetails(details.get(0), details.get(1), details.get(2));
        checkoutInformationPage.goToCheckoutOverview();
    }

    @And("I have an item in cart")
    public void iHaveAnItemInCart() {
        inventoryPage.addProduct(webDriver.findElement(By.className("inventory_item")));
    }

    @And("I am on the cart page")
    public void iAmOnTheCartPage() {
        cartPage = inventoryPage.goToCartPage();
    }

    @When("I click Remove")
    public void iClickRemove() {
        WebElement aProduct = webDriver.findElement(By.className("cart_item"));
        cartPage.removeProducts(aProduct);
    }

    @Then("the item is removed from the cart")
    public void theItemIsRemovedFromTheCart() {
        Integer itemNumber = cartPage.getCartBadgeNumber();
        Assertions.assertNull(itemNumber);
    }

    @When("I checkout")
    public void iCheckout() {
        checkoutInformationPage = cartPage.goToCheckOut();
    }

    @And("I add information details")
    public void iAddInformationDetails() {
        checkoutInformationPage.enterShippingDetails("First", "Last", "Zip");
        checkoutOverviewPage = checkoutInformationPage.goToCheckoutOverview();

    }
//
//    @Then("the correct items will be shown in the checkout overview")
//    public void theCorrectItemsWillBeShownInTheCheckoutOverview() {
//    }
//
//    @Then("the correct total is shown in the checkout overview")
//    public void theCorrectTotalIsShownInTheCheckoutOverview() {
//    }
//
    @Then("I am taken to the overview checkout page")
    public void iAmTakenToTheOverviewCheckoutPage() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutOverviewPage.getUrl());
    }
//
//    @And("I click the sidebar")
//    public void iClickTheSidebar() {
//    }
//
//    @When("I click All Items")
//    public void iClickAllItems() {
//    }
//

    @When("I click the {string} of an item")
    public void iClickTheTitleOfAnItem(String title) {
        productPage = inventoryPage.goToProductPageViaTitle(title);
    }

    @Then("I am taken to the product page with {string}")
    public void iAmTakenToTheProductPage(String title) {
        Assertions.assertEquals(title, productPage.getProductTitle());
    }

    @When("I click the image of an item")
    public void iClickTheImageOfAnItem() {
        webDriver.findElement(By.className("inventory_item_img")).click();
        productPage = new ProductPage(webDriver);
    }

    @When("I click Remove for an item on the inventory page")
    public void iClickRemoveForAnItemOnTheInventoryPage() {
        WebElement aProduct = webDriver.findElement(By.className("inventory_item"));
        inventoryPage.addProduct(aProduct);
        inventoryPage.removeProduct(aProduct);
    }

    @Then("the correct items will be shown in the checkout overview")
    public void theCorrectItemsWillBeShownInTheCheckoutOverview() {
        List<String> productNames = List.of("Sauce Labs Backpack");
        Assertions.assertTrue(checkoutOverviewPage.isProductListCorrect(productNames));
    }

    @When("I click Back to Products")
    public void iClickBackToProducts() {

    }

    @And("I am on the checkout overview page")
    public void iAmOnTheCheckoutOverviewPage() {
        checkoutOverviewPage = checkoutInformationPage.goToCheckoutOverview();
    }

    @When("I click Cancel")
    public void iClickCancel() {
        checkoutInformationPage.goToInventory();
    }
}
