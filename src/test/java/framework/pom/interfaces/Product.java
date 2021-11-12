package framework.pom.interfaces;

import framework.pom.interfaces.Inventory;
import org.openqa.selenium.WebElement;

public interface Product extends CommonPageInterface{
    String getProductTitle();
    String getProductDescription();
    double getProductPrice();
    WebElement getProductImage();
    void addToCart();
    void removeFromCart();
    Inventory goToInventory();
    boolean isProductImageAltSameAsProductTitle();
    boolean isProductDescriptionEmpty();

}
