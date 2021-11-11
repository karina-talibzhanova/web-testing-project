package framework.pom.pages;

public interface checkoutInformation {
    void enterShippingDetails(String fName, String lName, String zip);
    boolean isErrorIconsVisible();
    boolean isInputBoxesErrored();
}
