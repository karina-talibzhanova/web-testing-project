package framework.pom.interfaces;

import org.openqa.selenium.WebElement;

public interface CheckoutOverview extends CommonPageInterface{
    double getTotalPrice();
    String getPaymentInformation();
    boolean isTotalPriceCorrect();
    CheckoutComplete goToCheckoutCompletePage();
    String getProductTitle(WebElement product);
    String getProductDescription(WebElement product);
    String getProductPrice(WebElement product);
}
