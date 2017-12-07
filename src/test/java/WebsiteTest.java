import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

/**
 * Created by Dariusz Zdybski on 2017-12-06.
 */
public class WebsiteTest {

    private WebDriver driver;
    private String searchPhrase;
    private String jobLocation;
    private String url;

    @Before
    public void setUp(){


        final File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        driver = new ChromeDriver();
        searchPhrase = "test”";
         jobLocation = "Krakow office";
         url = "https://akamaijobs.referrals.selectminds.com/";
    }

    @Test
    public void testSearch(){

        driver.get(url);
        WebElement searchForm = driver.findElement(By.name("keyword"));
        WebElement searchLocation = driver.findElement(By.className("jLocPlaceholder"));
        WebElement searchButton = driver.findElement(By.className("btn_text"));

        searchForm.clear();
        searchForm.sendKeys("test");
        searchLocation.sendKeys("Krakow, Poland");
        searchButton.click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
