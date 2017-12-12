import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public abstract class AbstractUITest {

    WebDriver driver;

    AbstractUITest(){
        final File driverFile = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
