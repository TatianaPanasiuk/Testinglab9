package bershka.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManPage {
    //public static final String HOMEPAGE_URL = "https://www.bershka.com/by";

    static final int WAIT_TIME_IN_SECONDS = 5;

    static final By brandLocator = By.className("brand-logo");

    WebDriver driver;

    public ManPage(WebDriver driver){
        this.driver = driver;
    }

    public void hoverLogo(){
        WebElement hoverableLogo = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(brandLocator)).get(0);
        new Actions(driver)
                .moveToElement(hoverableLogo)
                .perform();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
    }

    public BaseClothesPage openBaseClothes(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String href = String.valueOf(js.executeScript("return document.querySelectorAll(\"a[aria-label='Перейти в Базовый гардероб']\")[1].href"));
        driver.get(href);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        return new BaseClothesPage(driver);
    }

}
