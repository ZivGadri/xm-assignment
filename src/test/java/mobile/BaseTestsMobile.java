package mobile;

import mobile.manager.Constants;
import mobile.manager.ui.android.MobileUiManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import static mobile.manager.drivers.AndroidDriverManager.quitSession;

public class BaseTestsMobile {
    protected String mobilePlatform;
    protected MobileUiManager mobileUiManager;
    protected SoftAssert softAssert;

    @BeforeClass(alwaysRun = true)
    public void testSetup() {
        mobileUiManager = new MobileUiManager(Constants.ANDROID_PLATFORM);
    }

    @BeforeMethod
    public void beforeMethod(){
        softAssert = new SoftAssert();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        quitSession();
    }
}
