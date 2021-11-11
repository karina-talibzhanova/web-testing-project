package framework.pom.pages;

import framework.pom.interfaces.Inventory;
import framework.pom.interfaces.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends CommonPage implements Product {
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getProductTitle() {
        return webDriver.findElement(By.className("inventory_details_name")).getText();
    }

    @Override
    public String getProductDescription() {
        return null;
    }

    @Override
    public double getProductPrice() {
        return 0;
    }

    @Override
    public WebElement getProductImage() {
        return null;
    }

    @Override
    public void addToCart() {

    }

    @Override
    public void removeFromCart() {

    }

    @Override
    public Inventory goToInventory() {
        return null;
    }

    @Override
    public boolean isProductImageAltSameAsProductTitle() {
        return false;
    }
}
