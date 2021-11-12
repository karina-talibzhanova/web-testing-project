package framework.pom.pages;

import framework.pom.interfaces.Cart;
import framework.pom.interfaces.Inventory;
import framework.pom.interfaces.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends CommonPage implements Cart {
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void removeProducts(WebElement product) {

    }

    @Override
    public Product goToProductPageViaTitle(String productName) {
        return null;
    }

    @Override
    public String getProductDescription(WebElement product) {
        return null;
    }

    @Override
    public String getProductTitle(WebElement product) {
        return null;
    }

    @Override
    public float getProductPrice(WebElement product) {
        return 0;
    }

    @Override
    public void goToCheckOut() {

    }

    @Override
    public List<WebElement> getAllProducts() {
        List<WebElement> allProducts = webDriver.findElements(By.className("cart_item"));
        return allProducts;
    }

    @Override
    public Inventory goToInventory() {
        return null;
    }
}
