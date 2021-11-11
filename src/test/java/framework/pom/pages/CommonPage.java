package framework.pom.pages;

import framework.pom.interfaces.Cart;
import framework.pom.interfaces.Inventory;
import framework.pom.interfaces.Login;
import framework.pom.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public abstract class CommonPage {
    private WebDriver webDriver;

    public CommonPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openSideBar() {}

    public void goToCompanyFacebookPage() {}

    public void goToCompanyTwitterPage() {}

    public void goToCompanyLinkedInPage() {}

    public Integer getCartBadgeNumber() {
        return null;
    }

    public Inventory clickAllItem() {
        return null;
    };

    public Login clickLogout() {
        return null;
    };

    public void clickResetAppState() {}

    public void goToCompanyAboutPage() {}

    public Cart goToCartPage() {
        return null;
    };


}
