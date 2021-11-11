package framework.pom.interfaces;

public interface CommonPageInterface {
    void openSideBar();
    boolean sidebarLinksValid();
    void goToCompanyFacebookPage();
    void goToCompanyTwitterPage();
    void goToCompanyLinkedInPage();
    Integer getCartBadgeNumber();
    Inventory clickAllItem();
    Login clickLogout();
    void clickResetAppState();
    void goToCompanyAboutPage();
    Cart goToCartPage();
    String getUrl();

}
