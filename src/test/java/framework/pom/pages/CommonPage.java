package framework.pom.pages;

import framework.pom.interfaces.Cart;
import framework.pom.interfaces.CommonPageInterface;
import framework.pom.interfaces.Inventory;
import framework.pom.interfaces.Login;
import framework.pom.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public abstract class CommonPage implements CommonPageInterface {
    protected WebDriver webDriver;

    public CommonPage(WebDriver webDriver) {
        this.webDriver = webDriver;
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
        String originalTab = webDriver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("social_facebook")));
        webDriver.findElement(By.linkText("Facebook")).click();
        //a set of every tab created
        Set<String> allWindows = webDriver.getWindowHandles();
        Iterator<String> I1 = allWindows.iterator();
        while (I1.hasNext())
        {
            String child_window=I1.next();
            if(!originalTab.equals(child_window)){
                webDriver.switchTo().window(child_window);
                System.out.println(webDriver.switchTo().window(child_window).getTitle());
                break;
            }
        }
    }

    public void goToCompanyTwitterPage() {
        String originalTab = webDriver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("social_twitter")));
        webDriver.findElement(By.linkText("Twitter")).click();
        //a set of every tab created
        Set<String> allWindows = webDriver.getWindowHandles();
        Iterator<String> I1 = allWindows.iterator();
        while (I1.hasNext())
        {
            String child_window=I1.next();
            if(!originalTab.equals(child_window)){
                webDriver.switchTo().window(child_window);
                System.out.println(webDriver.switchTo().window(child_window).getTitle());
                break;
            }
        }

    }

    public void goToCompanyLinkedInPage() {
        String originalTab = webDriver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("social_linkedin")));
        webDriver.findElement(By.linkText("LinkedIn")).click();
        Set<String> allWindows = webDriver.getWindowHandles();
        Iterator<String> I1 = allWindows.iterator();
        while (I1.hasNext())
        {
            String child_window=I1.next();
            if(!originalTab.equals(child_window)){
                webDriver.switchTo().window(child_window);
                System.out.println(webDriver.switchTo().window(child_window).getTitle());
                break;
            }
        }
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
        webDriver.findElement(By.className("shopping_cart_link")).click();
        return new CartPage(webDriver);
    };

    public String getUrl(){
        return webDriver.getCurrentUrl();
    }


}
