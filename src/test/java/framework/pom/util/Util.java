package framework.pom.util;

import framework.pom.interfaces.Inventory;
import framework.pom.interfaces.Login;
import framework.pom.pages.InventoryPage;
import framework.pom.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class Util {
    private static WebDriver webDriver;
    public static void setDriverLocation(String pathToDriver) {
        System.setProperty("webdriver.chrome.driver", pathToDriver);
    }

    public static ChromeDriverService getChromeDriverService(String pathToDriver) {
        return new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(pathToDriver))
                .usingAnyFreePort()
                .build();
    }

    public static WebDriver getNewChromeDriver() {
        webDriver = new ChromeDriver();
        return webDriver;
    }

    public static WebDriver getNewChromeDriver(ChromeDriverService service) {
        webDriver = new ChromeDriver(service);
        return webDriver;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static Inventory login(String username, String password) {
        Login loginPage = new LoginPage(webDriver);
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLogin();
        return new InventoryPage(webDriver);
    }
}

