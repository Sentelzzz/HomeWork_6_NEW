import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Checkboxes {

    public WebDriver chrome;
    boolean firstCheck;
    boolean secondCheck;

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
    }

    @Test
    public void checkBoxesTest() {
        chrome.get("http://the-internet.herokuapp.com/checkboxes");
        firstCheck = chrome.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected();
        if (!firstCheck) {
            chrome.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
        }
        firstCheck = chrome.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected();
        Assert.assertTrue(firstCheck);
        secondCheck = chrome.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected();
        if (secondCheck) {
            chrome.findElement(By.xpath("//input[@type='checkbox'][2]")).click();
        }
        secondCheck = chrome.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected();
        Assert.assertFalse(secondCheck);
    }

    @AfterClass
    public void endTest() {
        chrome.quit();
    }
}
