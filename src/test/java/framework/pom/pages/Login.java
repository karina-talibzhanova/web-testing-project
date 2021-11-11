package framework.pom.pages;

public interface Login {
    void setLoginDetails(String username, String password);
    Inventory clickLogin();
    String getErrorMessage();
    boolean isErrorIconsVisible();
    boolean isInputBoxesErrored();
}
