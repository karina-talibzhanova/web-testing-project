package framework.pom.interfaces;

public interface CheckoutOverview extends CommonPageInterface{
    double getTotalPrice();
    String getPaymentInformation();
    boolean isTotalPriceCorrect();
    CheckoutComplete goToCheckoutCompletePage();
}
