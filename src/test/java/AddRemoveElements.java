import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElements {

        public WebDriver chrome;
        int expectedListSize;
        int actualListSize;

        @BeforeClass
        public void setupBrowser() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            chrome = new ChromeDriver();
            chrome.manage().window().maximize();
        }

        @Test
        public void AddRemoveElementsTest() {
            chrome.get("http://the-internet.herokuapp.com/add_remove_elements/");
            chrome.findElement(By.xpath("//button[text()='Add Element']")).click();
            chrome.findElement(By.xpath("//button[text()='Add Element']")).click();
            chrome.findElement(By.xpath("//button[text()='Delete']")).click();
            List<WebElement> actualList = chrome.findElements(By.xpath("//button[text()='Delete']"));
            expectedListSize = 1;
            actualListSize = ((List<?>) actualList).size();
            Assert.assertEquals(expectedListSize, actualListSize);
        }

        @AfterClass
        public void endTest() {
            chrome.quit();
        }

}


