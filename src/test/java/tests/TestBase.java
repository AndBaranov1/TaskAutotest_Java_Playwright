package tests;

import com.microsoft.playwright.Page;
import org.example.until.PlaywrightFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected Page page;

    @BeforeMethod
    public void setUp() {
        page = PlaywrightFactory.initPage();
    }

    @AfterMethod
    public void tearDown() {
        PlaywrightFactory.close();
    }
}
