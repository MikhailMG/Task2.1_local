package org.example2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageSteamPrivacy {
    WebDriver driver = SingletonWebDriver.driver;
    Actions action = SingletonWebDriver.action;
//    String checkedString_major =
//            UtilitesForTestAsserts.StringCheck.checkedString_Major;
//    String getCheckedString_minor = UtilitesForTestAsserts.StringCheck.checkedString_Minor;

    private WebElement privicyPolicyFeedback = driver.findElement(By.
            xpath("//a[contains(@href,'https://store.steampowered.com/ssa_feedback')]"));
// <a href="https://store.
// steampowered.com/ssa_feedback/" target="_blank" rel="">Отзыв о конфиденциальности</a>

    private WebElement privicyPolicyDate = driver.findElement(By.
            xpath("/html/body/div/div[7]/div[6]/div[1]/div/div[2]/div[2]/div/div[2]/i[3]"));
//    /html/body/div/div[7]/div[6]/div[1]/div/div[2]/div[2]/div/div[2]/i[3]
    // <i>Дата редакции: 1&nbsp;января 2023&nbsp;г.</i>

    public PageSteamPrivacy(WebDriver driver)
    {
        this.driver = driver ;
    }

    public void scrollThePageTillPrivicyPolicyDATE() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", privicyPolicyFeedback);
    }
    public String getPolicyDateToString() {
       return privicyPolicyDate.getText();
    }


}
