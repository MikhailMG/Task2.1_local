package org.example2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageSteamPrivacy {
    WebDriver driver = SingletonWebDriver.driver;
    Actions action = SingletonWebDriver.action;

    private WebElement privicyPolicyFeedback = driver.findElement(By.
            xpath("//a[contains(@href,'https://store.steampowered.com/ssa_feedback')]"));
// <a href="https://store.
// steampowered.com/ssa_feedback/" target="_blank" rel="">Отзыв о конфиденциальности</a>

    public PageSteamPrivacy(WebDriver driver)
    {
        this.driver = driver ;
    }

    public void scrollThePageTillPrivicyPolicyDATE() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", privicyPolicyFeedback);
    }


}
