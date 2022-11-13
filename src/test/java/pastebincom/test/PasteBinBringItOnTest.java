package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pastebincom.page.PastebinHomePage;
import pastebincom.page.CreatedPastePage;

public class PasteBinBringItOnTest {
    private WebDriver driver;
    private static final String PASTETEXT = "git config --global user.name  \"New Sheriff in Town\"\n" + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" + "git push origin master --force";
    private static final String PASTE_NAME = "how to gain dominance among developers";
    private static final String PASTE_HIGHLIGHTING = "Bash";
    private static final String PASTE_EXPIRATION = "10 Minutes";
    CreatedPastePage createdPaste;

    @BeforeMethod
    public void createNewPaste() {
        driver = new ChromeDriver();
        PastebinHomePage mainPage = new PastebinHomePage(driver);
        mainPage.openPage();
        mainPage.enterNewPasteText(PASTETEXT);
        mainPage.enterHighlighting(PASTE_HIGHLIGHTING);
        mainPage.enterExpiration(PASTE_EXPIRATION);
        mainPage.enterPasteTitle(PASTE_NAME);
        createdPaste = mainPage.createPaste();
    }

    @Test
    public void compareHighlighting() {
        Assert.assertEquals(createdPaste.getHighlighting(),PASTE_HIGHLIGHTING);
    }
    @Test
    public void compareTitle() {
        Assert.assertEquals(createdPaste.getPageTitle().split("-")[0].trim(), PASTE_NAME);
    }
    @Test
    public void compareText() {
        Assert.assertEquals(createdPaste.getRawPaste(), PASTETEXT);
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
