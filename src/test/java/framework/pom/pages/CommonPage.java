package framework.pom.pages;

import framework.pom.interfaces.Cart;
import framework.pom.interfaces.CommonPageInterface;
import framework.pom.interfaces.Inventory;
import framework.pom.interfaces.Login;
import framework.pom.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CommonPage implements CommonPageInterface {
    private WebDriver webDriver;

    public CommonPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openSideBar() {
        webDriver.findElement(By.id("react-burger-menu-btn")).click();
    }
    public void openSideBar() {
        webDriver.findElement(By.id("react-burger-menu-btn")).click();
    }
    public boolean sidebarLinksValid(){
        WebElement inventoryLink = webDriver.findElement(By.id("inventory_sidebar_link"));
        WebElement aboutLink = webDriver.findElement(By.id("about_sidebar_link"));
        WebElement logoutLink = webDriver.findElement(By.id("logout_sidebar_link"));
        WebElement resetLink = webDriver.findElement(By.id("reset_sidebar_link"));
        return inventoryLink.getText().contains("ALL ITEMS")
                && aboutLink.getText().contains("ABOUT")
                && logoutLink.getText().contains("LOGOUT")
                && resetLink.getText().contains("RESET APP STATE");
    }

    public void goToCompanyFacebookPage() {
        webDriver.findElement(By.className("social_facebook")).click();
    }

    public void goToCompanyTwitterPage() {
        webDriver.findElement(By.className("social_twitter")).click();
    }

    public void goToCompanyLinkedInPage() {
        webDriver.findElement(By.className("social_linkedin")).click();
    }

    public Integer getCartBadgeNumber() {
        return null;
    }

    public Inventory clickAllItem() {
        return null;
    };

    public Login clickLogout() {
        webDriver.findElement(By.linkText("Logout")).click();
        return new LoginPage(webDriver);
    };

    public void clickResetAppState() {
        webDriver.findElement(By.id("reset_sidebar_link")).click();
    }

    public void goToCompanyAboutPage() {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("about_sidebar_link")));
        webDriver.findElement(By.id("about_sidebar_link")).click();
    }

    public Cart goToCartPage() {
        return null;
    };

    public String getUrl(){
        return webDriver.getCurrentUrl();
    }


}
