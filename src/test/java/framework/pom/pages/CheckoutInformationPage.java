package framework.pom.pages;

import framework.pom.interfaces.CheckoutInformation;
import framework.pom.interfaces.CheckoutOverview;
import framework.pom.interfaces.Inventory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutInformationPage extends CommonPage implements CheckoutInformation {
    public CheckoutInformationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void enterShippingDetails(String fName, String lName, String zip) {
        webDriver.findElement(By.id("first-name")).sendKeys(fName);
        webDriver.findElement(By.id("last-name")).sendKeys(lName);
        webDriver.findElement(By.id("postal-code")).sendKeys(zip);
    }

    @Override
    public boolean isErrorIconsVisible() {
        List<WebElement> errorIcons = webDriver.findElements(By.className("error_icon"));

        return errorIcons.size() == 3;
    }

    @Override
    public boolean isInputBoxesErrored() {
        List<WebElement> errorForms = webDriver.findElements(By.className("input_error"));

        if (errorForms.size() != 3) {
            return false;
        }

        for (WebElement errorForm : errorForms) {
            if (!errorForm.getCssValue("border-bottom-color").equals("rgba(226, 35, 26, 1)")) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Inventory goToInventory() {
        webDriver.findElement(By.id("cancel")).click();
        return new InventoryPage(webDriver);
    }

    @Override
    public CheckoutOverview goToCheckoutOverview() {
        webDriver.findElement(By.id("continue")).click();
        return new CheckoutOverviewPage(webDriver);
    }
}
