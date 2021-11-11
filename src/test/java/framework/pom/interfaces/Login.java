package framework.pom.interfaces;

import framework.pom.interfaces.Inventory;

public interface Login {
    void setLoginDetails(String username, String password);
    void inputName(String username);
    void inputPass(String password);
    Inventory clickLogin();
    String getErrorMessage();
    boolean isErrorIconsVisible();
    boolean isInputBoxesErrored();
}
