package framework.pom;

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

    public LoginPage clickLogout() {
        return null;
    };

    public void clickResetAppState() {}

    public void goToCompanyAboutPage() {}

    public Cart goToCartPage() {
        return null;
    };


}
