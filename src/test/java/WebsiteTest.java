import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver = new ChromeDriver();
        searchPhrase = "test”";
        String jobLocation = "Krakow office";
        String url = "https://akamaijobs.referrals.selectminds.com/";
    }

    @Test
    public void testSearch(){

    }

    @After
    public void tearDown(){

    }
}
