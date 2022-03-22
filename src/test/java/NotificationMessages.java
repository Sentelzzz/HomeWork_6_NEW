import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NotificationMessages {

    WebDriver chrome;
    String expectedResult = "Action successful";
    String actualResult;

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
    }

    @Test
    public void notificationMessagesTest () {
        chrome.get("http://the-internet.herokuapp.com/notification_message_rendered");
        chrome.findElement(By.xpath("//a[text()='Click here']")).click();
        actualResult = chrome.findElement(By.xpath("//div[@class='flash notice']")).getAttribute("textContent");
        System.out.println(actualResult); //даже в при Action successful тест будет падать из-за того, что в коде текст имеет форму "\n   Action successful\n   ×\n   "
        Assert.assertNotEquals(expectedResult, actualResult);
    }

    @AfterClass
    public void endTest() {
        chrome.quit();
    }
}
