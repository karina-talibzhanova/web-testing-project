package framework.pom.interfaces;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface CheckoutOverview extends CommonPageInterface{
    double getTotalPrice();
    String getPaymentInformation();
    boolean isTotalPriceCorrect();
    CheckoutComplete goToCheckoutCompletePage();
    List<WebElement> getAllProducts();
    boolean isProductListCorrect(List<String> productNames);
}
