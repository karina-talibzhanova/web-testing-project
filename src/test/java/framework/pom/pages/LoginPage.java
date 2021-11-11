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

    @Override
    public void setLoginDetails(String username, String password) {

    }

    @Override
    public Inventory clickLogin() {
        return null;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public boolean isErrorIconsVisible() {
        return false;
    }

    @Override
    public boolean isInputBoxesErrored() {
        return false;
    }

    private void goToLoginPage(){
        webDriver.get("https://www.saucedemo.com/");
    }

    public void inputName(String name){
        webDriver.findElement(By.name("user-name")).sendKeys(name);
    }

    public void inputPass(String pass){
        webDriver.findElement(By.name("password")).sendKeys(pass);
    }

    /*public void clickLogin(){
        webDriver.findElement(By.name("login-button")).click();
    }*/

   public boolean checkMissingUsernameErrorMessage(){
        return webDriver.findElement(By.tagName("h3")).getText().contains("Username is required");
    }
    public boolean checkMissingPasswordErrorMessage(){
        return webDriver.findElement(By.tagName("h3")).getText().contains("Password is required");
    }

    public boolean checkErrorMessageExists(){
        return webDriver.findElement(By.className("error-button")).isDisplayed();
    }

}
