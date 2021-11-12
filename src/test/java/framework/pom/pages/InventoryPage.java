package framework.pom.pages;

import framework.pom.interfaces.Cart;
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
    public String cartNumber() {
        return webDriver.findElement(By.tagName("span")).getText();
    }

    @Override
    public void addProduct(WebElement product) {
        // given an inventory_item, click the button that says "ADD TO CART"
        WebElement button = product.findElement(By.tagName("button"));
        // make sure the button is the "ADD TO CART" button
        if (button.getText().equals("ADD TO CART")) {
            button.click();
        }
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
        List<WebElement> productTitles = webDriver.findElements(By.className("inventory_item_label"));
        WebElement productTitleLink;
        for (WebElement productTitle : productTitles) {
            if (productTitle.findElement(By.className("inventory_item_name")).getText().equals(productName)) {
                System.out.println("found");
                productTitleLink = productTitle;
                productTitleLink.findElement(By.tagName("a")).click();
                return new ProductPage(webDriver);
            }
        }
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

//    @Override
//    public Cart goToCartPage() {
//        webDriver.findElement(By.className("shopping_cart_link"));
//        return new CartPage(webDriver);
//        return null;
//    }
}
