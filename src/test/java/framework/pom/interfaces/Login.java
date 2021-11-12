package framework.pom.interfaces;

import framework.pom.interfaces.Inventory;

public interface Login {
    void inputUsername(String username);
    void inputPassword(String password);
    Inventory clickLogin();
    String getErrorMessage();
    boolean isErrorIconsVisible();
    boolean isInputBoxesErrored();
    String getURL();
}
