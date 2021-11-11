package framework.pom.pages;

import framework.pom.interfaces.Inventory;
import framework.pom.interfaces.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage implements Login {
    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        goToLoginPage();
    }

    private void goToLoginPage(){
        webDriver.get("https://www.saucedemo.com/");
    }

    @Override
    public void inputUsername(String user) {
        webDriver.findElement(By.name("user-name")).sendKeys(user);
    }

    @Override
    public void inputPassword(String pass) {
        webDriver.findElement(By.name("password")).sendKeys(pass);
    }

    @Override
    public Inventory clickLogin() {
        webDriver.findElement(By.name("login-button")).click();
        return new InventoryPage(webDriver);
        //return null;

    }

    @Override
    public String getErrorMessage() {
        return webDriver.findElement(By.tagName("h3")).getText();
    }

    @Override
    public boolean isErrorIconsVisible() {
        return webDriver.findElement((By.className("error_icon"))).isDisplayed();
    }

    @Override
    public boolean isInputBoxesErrored() {
        return webDriver.findElement(By.className("input_error")).getCssValue("border-bottom-color").equals("rgba(226, 35, 26, 1)");
    }

    @Override
    public String getURL(){
        return webDriver.getCurrentUrl();
    }

    //logout test has to be done
}
