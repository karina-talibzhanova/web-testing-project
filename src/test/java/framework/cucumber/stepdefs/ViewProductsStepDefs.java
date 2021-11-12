package framework.cucumber.stepdefs;

import framework.pom.interfaces.Inventory;
import framework.pom.interfaces.Product;
import framework.pom.pages.InventoryPage;
import framework.pom.pages.ProductPage;
import framework.pom.util.Util;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewProductsStepDefs {
    private WebDriver webDriver;
    private Inventory inventoryPage;
    private Product productPage;

    @Before(order=3)
    public void setup() {
        Util.setDriverLocation(System.getenv("ChromeDriverPath"));
        webDriver= Util.getWebDriver();
        inventoryPage = new InventoryPage(webDriver);
//        productPage = new ProductPage(webDriver);
    }


    @When("I view the inventory page")
    public void iViewTheInventoryPage() {

    }

    @Then("all products have a non-empty description")
    public void allProductsHaveANonEmptyDescription() {
        List<WebElement> products = inventoryPage.getAllProducts();
        for (WebElement product: products) {
            String description = inventoryPage.getProductDescription(product);
            Assertions.assertFalse(inventoryPage.isProductDefinitionEmpty(description));
        }
    }

    @Then("the product has a non-empty description")
    public void theProductHasANonEmptyDescription() {
        productPage = new ProductPage(webDriver);
        Assertions.assertFalse(productPage.isProductDescriptionEmpty());
    }
}
