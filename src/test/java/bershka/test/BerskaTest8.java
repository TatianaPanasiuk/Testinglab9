package bershka.test;

import bershka.page.BaseClothesPage;
import bershka.page.HomePage;
import bershka.page.ManPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BerskaTest8 {
    WebDriver driver;
    @BeforeMethod
    public void InitializeDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void BershkaTest8(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        ManPage manPage = homePage.chooseGender();
        manPage.hoverLogo();
        BaseClothesPage baseClothesPage = manPage.openBaseClothes();
        Assert.assertTrue(baseClothesPage.openJeansPage());
    }

    @AfterMethod(alwaysRun = true)
    public void QuitDriver() {
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        driver = null;
    }
}
