package framework.pom.pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface CartInterface {
    void removeProducts(WebElement product);
    Product goToProductPageViaTitle(String productName);
    String getProductDescription(WebElement product);
    String getProductTitle(WebElement product);
    float getProductPrice(WebElement product);
    void goToCheckOut();
    List<WebElement> getAllProducts();
    Iventory goToInventory();
}
