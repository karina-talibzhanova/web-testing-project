package framework.pom.interfaces;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface Inventory extends CommonPageInterface{
    void changeFilter(Enum OPTIONS);
    boolean isFilterApplied();
    int cartNumber();
    void addProduct(WebElement product);
    void removeProduct(WebElement product);
    Product goToProductPageViaTitle(String productName);
    Product goToProductPageViaImage(String productName);
    boolean isProductDefinitionEmpty(String description);
    boolean isProductTitleEmpty(String title);
    boolean isProductImageAltSameAsProductTitle(WebElement product);
    List<WebElement> getAllProducts();
    String getProductTitle(WebElement product);
    String getProductDescription(WebElement product);
    float getProductPrice(WebElement product);
    WebElement getProductImage(WebElement product);
}
