package framework.pom.pages;

import framework.pom.interfaces.CheckoutComplete;
import framework.pom.interfaces.CheckoutOverview;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutOverviewPage extends CommonPage implements CheckoutOverview {
    public CheckoutOverviewPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public String getPaymentInformation() {
        return null;
    }

    @Override
    public boolean isTotalPriceCorrect() {
        return false;
    }

    @Override
    public CheckoutComplete goToCheckoutCompletePage() {
        return null;
    }

    @Override
    public List<WebElement> getAllProducts() {
        return webDriver.findElements(By.className("cart_item"));
    }

    @Override
    public boolean isProductListCorrect(List<String> productNames) {
        List<WebElement> checkoutProducts = getAllProducts();
        for (WebElement product : checkoutProducts) {
            // comparing the titles of every product in the overview to a given list of titles
            if (!productNames.contains(product.findElement(By.className("inventory_item_name")).getText())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getProductTitle(WebElement product) {
        return webDriver.findElement(By.className("inventory_item_name")).getText();
    }

    @Override
    public String getProductDescription(WebElement product) {
        return webDriver.findElement(By.className("inventory_item_desc")).getText();
    }

    @Override
    public String getProductPrice(WebElement product) {
        return null;
    }
}
