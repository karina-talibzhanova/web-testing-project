package framework.pom.pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface Cart {
    void removeProducts(WebElement product);
    Product goToProductPageViaTitle(String productName);
    String getProductDescription(WebElement product);
    String getProductTitle(WebElement product);
    double getProductPrice(WebElement product);
    void goToCheckOut();
    List<WebElement> getAllProducts();
    Inventory goToInventory();
}
