import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Hovers {

    WebDriver chrome;
    WebElement user;
    Actions action;
    String expectedUserName;
    String actualUserName;
    String expectedMessage;
    String actualMessage;

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        action = new Actions(chrome);
    }

    @Test
    public void hoverFirstTest() {
        chrome.get("http://the-internet.herokuapp.com/hovers");
        user = chrome.findElement(By.xpath("//img[@src='/img/avatar-blank.jpg']"));
        action.moveToElement(user).perform();
        expectedUserName = "name: user1";
        actualUserName = chrome.findElement(By.xpath("//h5[text()='name: user1']")).getAttribute("textContent");
        Assert.assertEquals(expectedUserName, actualUserName);
        chrome.findElement(By.xpath("//a[@href='/users/1'][1]")).click();
        expectedMessage = "ERROR 404";
        actualMessage = chrome.findElement(By.xpath("//h1")).getText();
        Assert.assertNotEquals(expectedMessage, actualMessage);
    }

    //проверка остальных пользователей невозможна из-за того, что невозможно подобрать уникальный локатор

    @AfterClass
    public void endTest() {
        chrome.quit();
    }
}
