package framework.pom.pages;

import framework.pom.interfaces.CheckoutComplete;
import framework.pom.interfaces.Inventory;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends CommonPage implements CheckoutComplete {
    public CheckoutCompletePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public Inventory goToInventory() {
        return null;
    }
}
