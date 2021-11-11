package framework.pom.interfaces;

public interface CheckoutInformation {
    void enterShippingDetails(String fName, String lName, String zip);
    boolean isErrorIconsVisible();
    boolean isInputBoxesErrored();
}
