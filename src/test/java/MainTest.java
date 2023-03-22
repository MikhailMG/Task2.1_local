import org.example2.PageSteamHome;
import org.example2.PageSteamPrivacy;
import org.example2.SingletonWebDriver;
import org.example2.UtilitiesForTestAsserts;
import org.testng.Assert;
import org.testng.annotations.*;

public class MainTest {
    PageSteamHome homepage;
    PageSteamPrivacy privacyPage;
    @BeforeMethod
    public void before_test() {
        System.out.println("PreCondition WebDriver initialization");
           SingletonWebDriver.initializeWebDriver();
      }
    @Test
    public void seleniumTest1() {

/*Load Page by URL*/
      String title= SingletonWebDriver.driver.getTitle();
        System.out.println("The title of current page is  "+ title);
        System.out.println("breakpoint 1");
       homepage = new PageSteamHome(SingletonWebDriver.driver);

        Assert.assertTrue(homepage.checkLogButtonStatus()
                ,"Login Button is NOT displayed");
        System.out.println(homepage.checkLogButtonStatus());

 /*Scroll till BOTTOM*/
        homepage.scrollThePageTillBottom();
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        homepage.scrollThePageTillPrivicyPolicyButton();
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

       System.out.println("breakpoint 2");

/*Click Privicy Policy Button*/
//        homepage.clickPrivicyPolicyButton();


        homepage.swithToPrivacyPolicyTab();

        privacyPage = new PageSteamPrivacy(SingletonWebDriver.driver);

        System.out.println("breakpoint 3");
        String title2= SingletonWebDriver.driver.getTitle();
        System.out.println("The title of current page is  "+ title2);

        try {
            Thread.sleep(4 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

       homepage.scrollThePageTillBottom();
        try {
            Thread.sleep(4 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        privacyPage.getPolicyDateToString();
        System.out.println(privacyPage.getPolicyDateToString());
        boolean yearIs2023 = UtilitiesForTestAsserts.
                checkString(privacyPage.getPolicyDateToString(), "2023");
        Assert.assertTrue(yearIs2023,"Privacy policy year is not 2023");

   //     System.out.println(policyYear.incloodesString;

   //     privacyPage.scrollThePageTillPrivicyPolicyDATE();


        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
    @AfterMethod
    public void after_test() {
        SingletonWebDriver.quitDriverSingleton();
/*
        driver.quit();
        System.out.println("driver disabled");
*/
    }
}
