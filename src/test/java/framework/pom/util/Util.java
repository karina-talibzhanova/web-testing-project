package framework.pom.util;

import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class Util {
    public static void setDriverLocation(String pathToDriver) {
        System.setProperty("webdriver.chrome.driver", pathToDriver);
    }

    public static ChromeDriverService getChromeDriverService(String pathToDriver) {
        return new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(pathToDriver))
                .usingAnyFreePort()
                .build();
    }
}

