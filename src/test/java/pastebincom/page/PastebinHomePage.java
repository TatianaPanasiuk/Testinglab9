package pastebincom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PastebinHomePage {

    public static final int WAIT_TIME_IN_SECONDS = 10;
    public static final String HOMEPAGE_URL = "https://pastebin.com";

    private final By newTextLocator = By.xpath("//textarea[@id='postform-text']");
    private final By pasteTitleLocator = By.id("postform-name");

    private final By selectHighlightingLocator = By.xpath("//select[@id='postform-format']/following::span[1]");
    private final By selectExpirationLocator = By.xpath("//select[@id='postform-expiration']/following::span[1]");
    private final By selectOptionsLocator = By.xpath("//li[contains(@class,'select2-results__option')]");

    private final By createButtonLocator = By.xpath("//button[text()='Create New Paste']");

    WebDriver driver;

    public PastebinHomePage(WebDriver driver){
        this.driver = driver;
    }

    public PastebinHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void enterNewPasteText(String text){
        WebElement newText = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(newTextLocator));
        newText.sendKeys(text);
    }

    public void enterPasteTitle(String text){
        WebElement pasteTitle = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(pasteTitleLocator));
        pasteTitle.sendKeys(text);
    }

    public void enterExpiration(String expiration) {
        WebElement selectExpiration = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(selectExpirationLocator));
        selectExpiration.click();
        List<WebElement> selectOptions = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(selectOptionsLocator));
        for (WebElement option : selectOptions) {
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.elementToBeClickable(option));
            if (option.getText().trim().equals(expiration.trim())) {
                option.click();
                new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.invisibilityOf(option));
                break;
            }
        }
    }

    public void enterHighlighting(String highlighting) {
        WebElement selectExpiration = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(selectHighlightingLocator));
        selectExpiration.click();
        List<WebElement> selectOptions = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(selectOptionsLocator));
        for (WebElement option : selectOptions) {
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.elementToBeClickable(option));
            if (option.getText().trim().equals(highlighting.trim())) {
                option.click();
                new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.invisibilityOf(option));
                break;
            }
        }
    }

    public void createNewPaste(){
        WebElement createPaste = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(createButtonLocator));
        createPaste.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
    }

    public CreatedPastePage createPaste() {
        WebElement createPaste = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(createButtonLocator));
        createPaste.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
        return new CreatedPastePage(driver);
    }

}
