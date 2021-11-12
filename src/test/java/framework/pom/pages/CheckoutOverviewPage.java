package framework.pom.pages;

import framework.pom.interfaces.CheckoutComplete;
import framework.pom.interfaces.CheckoutOverview;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
