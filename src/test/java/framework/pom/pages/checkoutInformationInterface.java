package framework.pom.pages;

public interface checkoutInformationInterface {
    void enterShippingDetails(String fName, String lName, String zip);
    boolean isErrorIconsVisible();
    boolean isInputBoxesErrored();
}
