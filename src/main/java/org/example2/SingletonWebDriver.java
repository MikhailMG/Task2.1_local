package org.example2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SingletonWebDriver {
    public static WebDriver driver = null;
    public static Actions action = null;

    public static void initializeWebDriver(){
        if(driver==null){

            WebDriverManager.firefoxdriver().setup();

            WebDriver fireFoxdriver = new FirefoxDriver();
            driver = fireFoxdriver;
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get("https://store.steampowered.com/");
            action = new Actions(driver);
        }
    }
    public static void quitDriverSingleton (){
        System.out.println("Singleton WebDriver quiting");
        driver.quit();
        driver=null;
    }
}
