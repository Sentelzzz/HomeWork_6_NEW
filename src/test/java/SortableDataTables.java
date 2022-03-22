import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SortableDataTables {

    WebDriver chrome;
    String emailTableOne;
    String emailTableTwo;
    String dueTableOne;
    String dueTableTwo;
    String webSiteTableOne;
    String webSiteTableTwo;


    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
    }

    @Test
    public void emailDataTablesTest() {
        chrome.get("http://the-internet.herokuapp.com/tables");
        emailTableOne = chrome.findElement(By.xpath("//table//tr[1]//td[3]")).getText();
        emailTableTwo = chrome.findElement(By.xpath("//table[2]//tr[1]//td[3]")).getText();
        Assert.assertEquals(emailTableOne, emailTableTwo);
    }

    @Test
    public void dueDataTablesTest() {
        chrome.get("http://the-internet.herokuapp.com/tables");
        dueTableOne = chrome.findElement(By.xpath("//table//tr[2]//td[4]")).getText();
        dueTableTwo = chrome.findElement(By.xpath("//table[2]//tr[2]//td[4]")).getText();
        Assert.assertEquals(dueTableOne, dueTableTwo);
    }

    @Test
    public void webSiteDataTableTest() {
        chrome.get("http://the-internet.herokuapp.com/tables");
        webSiteTableOne = chrome.findElement(By.xpath("//table//tr[4]//td[5]")).getText();
        webSiteTableTwo = chrome.findElement(By.xpath("//table[2]//tr[4]//td[5]")).getText();
        Assert.assertEquals(webSiteTableOne, webSiteTableTwo);
    }

    @AfterClass
    public void endTest() {
        chrome.quit();
    }

}
