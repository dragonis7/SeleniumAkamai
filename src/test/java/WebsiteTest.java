import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        WebElement searchFormDiv = driver.findElement(By.className("jLocPlaceholder"));
        WebElement searchLocation = driver.findElement(By.xpath("//*[@id=\"location_facet_chzn\"]/ul/li/input"));
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"jSearchSubmit\"]/span[2]"));

        searchForm.clear();
        searchForm.sendKeys("test");
        searchFormDiv.click();
        searchLocation.sendKeys("Krakow, Poland");
        searchLocation.sendKeys(Keys.ENTER);
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"jobs_filters_title\"]/div/span[1]")));
        WebElement totalResult = driver.findElement(By.xpath("//*[@id=\"jobs_filters_title\"]/div/span[1]"));

        System.out.println(totalResult.getText());


    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
