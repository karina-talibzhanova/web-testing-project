package framework.pom.pages;

import io.cucumber.java.af.En;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface InventoryInterface {
    void changeFilter(Enum OPTIONS);
    boolean isFilterApplied();
    void addProduct(WebElement product);
    void removeProduct(WebElement product);
    Product goToProductPageViaTitle(String productName);
    Product goToProductPageViaImage(String productName);
    boolean isProductDefinitionEmpty(WebElement product);
    boolean isProductTitleEmpty(WebElement product);
    boolean isProductImageAltSameAsProductTitle(WebElement product);
    List<WebElement> getAllProducts();
}
