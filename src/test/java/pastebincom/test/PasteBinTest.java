package pastebincom.test;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pastebincom.page.PastebinHomePage;

public class PasteBinTest {

    WebDriver driver;
    @BeforeMethod
    public void InitializeDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void PasteBinNewPasteTest(){
        PastebinHomePage homePage = new PastebinHomePage(driver);
        homePage.openPage();
        homePage.enterNewPasteText("Hello from WebDriver");
        homePage.enterPasteTitle("helloweb");
        homePage.enterExpiration("10 Minutes");

        String oldUrl = driver.getCurrentUrl();

        homePage.createNewPaste();

        Assert.assertNotEquals(oldUrl, driver.getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void QuitDriver() {
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        driver = null;
    }

}
