import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Inputs {

    WebDriver chrome;
    String testingNumbers;
    String actualNumber;
    String testingString;
    String actualString;

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
    }

    @Test
    public void inputsNumberTest() {
        chrome.get("http://the-internet.herokuapp.com/inputs");
        testingNumbers = "123456";
        chrome.findElement(By.tagName("input")).sendKeys(testingNumbers);
        actualNumber = chrome.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
        Assert.assertEquals(testingNumbers, actualNumber);
    }

    @Test
    public void inputsStringTest() {
        chrome.get("http://the-internet.herokuapp.com/inputs");
        testingString = "Hello World!";
        chrome.findElement(By.tagName("input")).sendKeys(testingString);
        actualString = chrome.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
        Assert.assertEquals(testingString, actualString);
    }

    @AfterClass
    public void endTest() {
        chrome.quit();
    }
}
