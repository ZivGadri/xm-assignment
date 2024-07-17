package web.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.manager.pageHelpers.MainPageHelper;

public class UiManager {
    private static final Logger logger = LogManager.getLogger(UiManager.class);
    private final WebDriver driver;
    private final String xmUrl = "https://www.xm.com";

    public UiManager(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToMainPage() {
        MainPageHelper mainPageHelper = new MainPageHelper(driver, xmUrl);
    }
}