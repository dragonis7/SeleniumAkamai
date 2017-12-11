import com.zdybski.AdvertPage;
import com.zdybski.AkamaiJobsPage;
import com.zdybski.ResultPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class WebsiteTest extends AbstractUITest {

    private static final String SEARCH_PHRASE = "test";
    private static final int EXPECTED_TOTAL_RESULT_AMOUNT = 11;
    private static final String EXPECTED_ADV_DATE = "Oct 25, 2017";
    private static final String JOB_LOCATION = "Krakow, Poland ";
    private static final String START_URL =  "https://akamaijobs.referrals.selectminds.com/";;
    private static final String JOB_PHRASE = "Software Development Engineer in Test";
    private static final int EXPECTED_AMOUNT_OF_JOB_PHRASES = 2;
    private static final String JOB_PHRASE_LUNA = "Software Development Engineer in Test - LUNA";;

    @Test
    public void testSearch() throws NoSuchFieldException {

        AkamaiJobsPage jobsPage = new AkamaiJobsPage(driver, START_URL);
        jobsPage.goToPage();
        ResultPage resultPage = jobsPage.searchForJobs(SEARCH_PHRASE, JOB_LOCATION);
        int actualTotalResultAmount = resultPage.getTotalResultAmount();
        int actualJobOffersAMount = resultPage.findAmountOfSpecifiedJobOffers(JOB_PHRASE);
        AdvertPage advertPage = resultPage.goToAdvertPage(JOB_PHRASE_LUNA);
        String actualDateOfAdv = advertPage.getCreationDate();

        Assert.assertEquals(EXPECTED_TOTAL_RESULT_AMOUNT, actualTotalResultAmount);
        Assert.assertEquals(EXPECTED_AMOUNT_OF_JOB_PHRASES, actualJobOffersAMount);
        Assert.assertEquals(EXPECTED_ADV_DATE,actualDateOfAdv);
    }


}
