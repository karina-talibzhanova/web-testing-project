package framework.pom.pages;

import framework.pom.interfaces.Cart;
import framework.pom.interfaces.CheckoutInformation;
import framework.pom.interfaces.Inventory;
import framework.pom.interfaces.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends CommonPage implements Cart {
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void removeProducts(WebElement product) {
        WebElement button = product.findElement(By.tagName("button"));
        if (button.getText().equals("REMOVE")) {
            button.click();
        }
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
    public CheckoutInformation goToCheckOut() {
        webDriver.findElement(By.id("checkout")).click();
        return new CheckoutInformationPage(webDriver);
    }

    @Override
    public List<WebElement> getAllProducts() {
        return null;
    }

    @Override
    public Inventory goToInventory() {
        return null;
    }
}
