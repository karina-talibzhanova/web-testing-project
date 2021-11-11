package framework.pom.interfaces;

public interface CheckoutInformation extends CommonPageInterface{
    void enterShippingDetails(String fName, String lName, String zip);
    boolean isErrorIconsVisible();
    boolean isInputBoxesErrored();
    Inventory goToInventory();
    CheckoutComplete goToCheckoutComplete();
}
