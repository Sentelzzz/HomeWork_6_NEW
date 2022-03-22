import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Typos {

    WebDriver chrome;
    String actualResult;
    String expectedResult;

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
    }

    @Test
    public void typoTest() {
        chrome.get("http://the-internet.herokuapp.com/typos");
        actualResult = chrome.findElement(By.xpath("//p[2]")).getText();         //тут по локатору By.tagName("p") существует два варианта, поставить [2] не получается, потому, что такого tagName в коде нет, использовал xpath.
        expectedResult = "Sometimes you'll see a typo, other times you won't.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @AfterClass
    public void endTest() {
        chrome.quit();
    }
}
