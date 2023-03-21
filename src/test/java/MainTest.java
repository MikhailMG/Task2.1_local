import io.github.bonigarcia.wdm.WebDriverManager;
import org.example2.PageSteamHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MainTest {
    public WebDriver driver;

//   PageSteamHome homepage;



    @BeforeMethod
    public void before_test() {
        System.out.println("PreCondition WebDriver initialization");
        /*Driver launch*/
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//       driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        this.driver = driver;
    }
    @Test
    public void seleniumTest1() {
 //       PageSteamHome homepage =new PageSteamHome();

/*Load Page by URL*/
        driver.get("https://store.steampowered.com/");
        System.out.println("breakpoint 1");
        PageSteamHome homepage = new PageSteamHome(driver);
        System.out.println("breakpoint 2");

/*goTo LoginPage*/
  //      homepage.clickLoginButton();

        System.out.println("breakpoint 3");
    }
    @AfterMethod
    public void after_test() {
        driver.quit();
        System.out.println("driver disabled");
    }
}
