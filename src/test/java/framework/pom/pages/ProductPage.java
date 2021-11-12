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
        return webDriver.findElement(By.className("inventory_details_desc")).getText();
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
        webDriver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Override
    public void removeFromCart() {
        webDriver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    @Override
    public Inventory goToInventory() {
        webDriver.findElement(By.id("back-to-products")).click();
        return new InventoryPage(webDriver);
    }

    @Override
    public boolean isProductImageAltSameAsProductTitle() {
        //return webDriver.findElement(By.xpath("//img[contains(@alt,"))
        return false;
    }

    @Override
    public boolean isProductDescriptionEmpty() {
        return webDriver.findElement(By.className("inventory_details_desc")).getText().isEmpty();
    }
}
