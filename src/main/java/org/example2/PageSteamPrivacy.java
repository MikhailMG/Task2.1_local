package org.example2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class PageSteamPrivacy {
    WebDriver driver = SingletonWebDriver.driver;
    Actions action = SingletonWebDriver.action;
//    String checkedString_major =
//            UtilitesForTestAsserts.StringCheck.checkedString_Major;
//    String getCheckedString_minor = UtilitesForTestAsserts.StringCheck.checkedString_Minor;
 //   LanguageList listOfLanguages;
    private WebElement privicyPolicyFeedback = driver.findElement(By.
            xpath("//a[contains(@href,'https://store.steampowered.com/ssa_feedback')]"));
// <a href="https://store.
// steampowered.com/ssa_feedback/" target="_blank" rel="">Отзыв о конфиденциальности</a>

    private WebElement privicyPolicyDate = driver.findElement(By.
            xpath("/html/body/div/div[7]/div[6]/div[1]/div/div[2]/div[2]/div/div[2]/i[3]"));
//    /html/body/div/div[7]/div[6]/div[1]/div/div[2]/div[2]/div/div[2]/i[3]
    // <i>Дата редакции: 1&nbsp;января 2023&nbsp;г.</i>

    private WebElement languagesBar = (WebElement) driver.findElement(By.id("languages"));

    private List<WebElement> languagesOfPolicy = languagesBar.findElements(By.xpath("./child::*"));

    //   private List<WebElement> languagesOfPolicy2 = driver.findElements(By.xpath("./child::*"));


    //<a href="https://store.steampowered.com/privacy_agreement/english/">
    List<Language> listOfLanguages = new ArrayList<Language>();
  //  LanguageList <listOfLanguages> = new LanguageList   ();

    public PageSteamPrivacy(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollThePageTillPrivicyPolicyDATE() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", privicyPolicyFeedback);
    }

    public String getPolicyDateToString() {
        return privicyPolicyDate.getText();
    }

    public void getLanguageOfPolicyElement() {
        System.out.println(languagesOfPolicy.size() + " languages on a pannel");

        for (WebElement webElement : languagesOfPolicy) {
            String webElementHREF = webElement.getAttribute("href");
       //     System.out.println(webElementHREF);

            String s2 = "https://store.steampowered.com/privacy_agreement/";
            String s3 = webElementHREF.replace(s2, "");

            String language1 = s3.replace("/","");
 //           System.out.println(language1);
            Language language = new Language();
            language.language = language1;

                listOfLanguages.add(language);
        }
            System.out.println(listOfLanguages);
     //       Collections.addAll(, (language1)) ;




        }

    }



