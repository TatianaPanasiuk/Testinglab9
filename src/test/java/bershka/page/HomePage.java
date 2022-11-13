package bershka.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public static final String HOMEPAGE_URL = "https://www.bershka.com/by";
    private By selectGenderLocator = By.className("gender-selector__container");
    static final int WAIT_TIME_IN_SECONDS = 10;

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage(){
        driver.get(HOMEPAGE_URL);
    }

    public ManPage chooseGender(){
        WebElement gender = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(selectGenderLocator)).get(1);
        gender.click();
        return new ManPage(driver);
    }

}
