package framework.pom.interfaces;

import framework.pom.interfaces.Inventory;

public interface Login {
    void setLoginDetails(String username, String password);
    Inventory clickLogin();
    String getErrorMessage();
    boolean isErrorIconsVisible();
    boolean isInputBoxesErrored();
}
