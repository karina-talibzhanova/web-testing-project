package framework.pom.interfaces;

public interface CheckoutOverview {
    double getTotalPrice();
    String getPaymentInformation();
    boolean isTotalPriceCorrect();
    CheckoutComplete goToCheckoutCompletePage();
}
