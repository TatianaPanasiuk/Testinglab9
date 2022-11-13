package bershka.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class BaseClothesPage {

    private final By jeansLocator = By.xpath("/html/body/div[1]/article/ul/li[5]/button");
    final static int WAIT_TIME_IN_SECONDS = 15;
    WebDriver driver;

    public BaseClothesPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean openJeansPage(){
        WebElement iframe = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("iFrameResizer0")));
        driver.switchTo().frame(iframe);
        System.out.println(driver.getPageSource());
        WebElement jeansButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
               .until(ExpectedConditions.presenceOfElementLocated(jeansLocator));
        jeansButton.click();
        return true;
    }

}
