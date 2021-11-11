package framework.pom.pages;

import org.openqa.selenium.WebElement;

public interface ProductInterface {
    String getProductTitle();
    String getProductDescription();
    float getProductPrice();
    WebElement getProductImage();
    void addToCart();
    void removeFromCart();
    Inventory goToInventory();
    boolean isProductImageAltSameAsProductTitle();

}
