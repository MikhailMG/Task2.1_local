package org.example2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class PageSteamHome  {
    WebDriver driver = SingletonWebDriver.driver;
    Actions action = SingletonWebDriver.action;


    private WebElement loginButton = driver.findElement(By.
            xpath("//a[contains(@class,'global_action_link') and" +
                    " contains(@href,'store.steampowered.com/login')]"));

    private WebElement privicyPolicyButton = driver.findElement(By.
            xpath("/html/body/div[1]/div[7]" +
                    "/div[6]/div/div[7]/div/div[4]/div[2]/a[1]"));
     //       xpath("//a[contains(@href,'store.steampowered.com/privacy_agreement')]"));

    // /html/body/div[1]/div[7]/div[6]/div/div[7]/div/div[4]/div[2]/a[1]
//    <a href="https://store.steampowered.com/privacy_agreement/?snr=1_44_44_"
//    target="_blank" rel="">Политика конфиденциальности</a>



    //Constructor that will be automatically called as soon as the object of the class is created
    public PageSteamHome(WebDriver driver)
    {
        this.driver = driver ;
    }


//    static boolean loginButtonIsPresent = driver.findElement(By.xpath("//a[contains(@class,'global_action_link') and" +
//            " contains(@href,'store.steampowered.com/login')]")).isDisplayed();
    public boolean checkLogButtonStatus(){
      return loginButton.isDisplayed();
    }
    //    Actions action = new Actions(driver);

    public void clickLoginButton () {
  //      action = new Actions(driver);
    //    loginButton.click();
           action.moveToElement(loginButton).click().perform();
        }
        public void scrollThePageTillBottom(){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            //This will scroll the web page till end.
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void scrollThePageTillPrivicyPolicyButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", privicyPolicyButton);
    }



    public void clickPrivicyPolicyButton () {
        action.moveToElement(privicyPolicyButton).click().perform();
    }

    public void swithToPrivacyPolicyTab(){
        WebDriverWait wait = new WebDriverWait(driver, 8);
            //Store the ID of the original window
            String originalWindow = driver.getWindowHandle();

//Check we don't have other windows open already
      //      assert driver.getWindowHandles().size() == 1;

//Click the link which opens in a new window
            driver.findElement(By.
                    xpath("/html/body/div[1]/div[7]/div[6]/div/div[7]" +
                            "/div/div[4]/div[2]/a[1]")).click();

//Wait for the new window or tab
            wait.until(numberOfWindowsToBe(2));

//Loop through until we find a new window handle
            for (String windowHandle : driver.getWindowHandles()) {
                if(!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

//Wait for the new tab to finish loading content
            wait.until(titleIs("Соглашение политики конфиденциальности"));

        }


/*Just to Test Actions*/
        public void enterUserPassData(){
            /*Pass field entry creation*/
            WebElement loginPassField = driver.findElement(By.
                    xpath("/html/body/div[1]/div[7]/div[6]/div/" +
                            "div[1]/div/div/div/div[2]/div/form/div[2]/input"));
//                WebElement loginPassField = driver.findElement(By.
//                xpath("//input[@class='newlogindialog_TextInput_2eKVn']")) ;
            action.moveToElement(loginPassField).click().perform();
            action.sendKeys(StringRandomGenerator.randomAlphaNumericSpesh(8)).perform();

            /*Username field entry creation*/
            WebElement loginUserField = driver.findElement(By.
                    xpath("/html/body/div[1]/div[7]/div[6]/div/" +
                            "div[1]/div/div/div/div[2]/div/form/div[1]/input"));
//                WebElement loginPassField = driver.findElement(By.
//                xpath("//input[@class='newlogindialog_TextInput_2eKVn']")) ;

            action.moveToElement(loginUserField).click().perform();
            action.sendKeys(StringRandomGenerator.randomAlphaNumeric(8)).perform();
        }
/*Actions test end*/

    }



