package framework.pom.pages;

import framework.pom.interfaces.CheckoutInformation;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage extends CommonPage implements CheckoutInformation {
    public CheckoutInformationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void enterShippingDetails(String fName, String lName, String zip) {

    }

    @Override
    public boolean isErrorIconsVisible() {
        return false;
    }

    @Override
    public boolean isInputBoxesErrored() {
        return false;
    }
}
