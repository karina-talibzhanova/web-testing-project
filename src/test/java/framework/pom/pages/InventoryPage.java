package framework.pom.pages;

import framework.pom.interfaces.Inventory;
import framework.pom.interfaces.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends CommonPage implements Inventory {
    private WebDriver webDriver;
    public InventoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void changeFilter(Enum OPTIONS) {

    }

    @Override
    public boolean isFilterApplied() {
        return false;
    }

    @Override
    public void addProduct(WebElement product) {
        // given an inventory_item, click the button that says "ADD TO CART"
        WebElement button = product.findElement(By.tagName("button"));
        // make sure the button is the "ADD TO CART" button
        if (button.getText().equals("ADD TO CART")) {
            button.click();
        }
    }

    @Override
    public void removeProduct(WebElement product) {

    }

    @Override
    public Product goToProductPageViaTitle(String productName) {
        return null;
    }

    @Override
    public Product goToProductPageViaImage(String productName) {
        return null;
    }

    @Override
    public boolean isProductDefinitionEmpty(WebElement product) {
        return false;
    }

    @Override
    public boolean isProductTitleEmpty(WebElement product) {
        return false;
    }

    @Override
    public boolean isProductImageAltSameAsProductTitle(WebElement product) {
        return false;
    }

    @Override
    public List<WebElement> getAllProducts() {
        return null;
    }

    @Override
    public String getProductTitle(WebElement product) {
        return null;
    }

    @Override
    public String getProductDescription(WebElement product) {
        return null;
    }

    @Override
    public float getProductPrice(WebElement product) {
        return 0;
    }

    @Override
    public WebElement getProductImage(WebElement product) {
        return null;
    }
}
