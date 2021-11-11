package framework.pom.pages;

import framework.pom.interfaces.CheckoutComplete;
import framework.pom.interfaces.CheckoutOverview;
import org.openqa.selenium.WebDriver;

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
}
