package org.example2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class PageSteamHome {

    /*protected static*/  WebDriver driver1;
    public PageSteamHome(WebDriver driver1) {
        this.driver1 = driver1;
    }
    private WebElement loginButton= driver1.findElement(By.
            xpath("//a[contains(@class,'global_action_link') and" +
            " contains(@href,'store.steampowered.com/login')]"));

    //Constructor that will be automatically called as soon as the object of the class is created

        Actions action = new Actions(driver1);


    public  void clickLoginButton () {
        action.moveToElement(loginButton).click().perform();
    }

}


