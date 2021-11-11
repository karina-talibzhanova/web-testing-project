package framework.pom.pages;

public interface checkoutOverview {
    double getTotalPrice();
    String getPaymentInformation();
    boolean isTotalPriceCorrect();
    checkoutComplete goToCheckoutCompletePage();
}
