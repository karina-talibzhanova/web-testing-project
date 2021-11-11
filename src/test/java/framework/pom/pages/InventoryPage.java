package framework.pom.pages;

import framework.pom.interfaces.Inventory;
import framework.pom.interfaces.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends CommonPage implements Inventory {
    public InventoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void changeFilter(Enum OPTIONS) {

    }

    @Override
    public boolean isFilterApplied() {
        return false;
    }

    @Override
    public void addProduct(WebElement product) {

    }

    @Override
    public void removeProduct(WebElement product) {
        // find the button and check it says "REMOVE"
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
    public Product goToProductPageViaImage(String productName) {
        return null;
    }

    @Override
    public boolean isProductDefinitionEmpty(WebElement product) {
        return false;
    }

    @Override
    public boolean isProductTitleEmpty(WebElement product) {
        return false;
    }

    @Override
    public boolean isProductImageAltSameAsProductTitle(WebElement product) {
        return false;
    }

    @Override
    public List<WebElement> getAllProducts() {
        return null;
    }

    @Override
    public String getProductTitle(WebElement product) {
        return null;
    }

    @Override
    public String getProductDescription(WebElement product) {
        return null;
    }

    @Override
    public float getProductPrice(WebElement product) {
        return 0;
    }

    @Override
    public WebElement getProductImage(WebElement product) {
        return null;
    }
}
