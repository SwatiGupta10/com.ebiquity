/**
 * BasePageLocators.java - A class which contains locators for WebElements
 * of https://www.ebiquity.com/en/contact-us
 *
 * @author  Swati Gupta
 * @version 1.0
 */
package main.java.com.ebiquity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageLocators {

    WebDriver driver;

    // Constructor placed in order to make sure driver remains for this java class.
    public BasePageLocators(WebDriver driver){
        this.driver=driver;
    }

    By howCanWeHelp = By.id("00Nw0000008iSjb");
    By email = By.id("email");
    By firstName = By.id("first_name");
    By surName = By.id("last_name");
    By company = By.id("company");
    By position_JobTitle = By.id("title");
    //BusinessArea DropDown
    By businessArea = By.id("00Nw0000008iSjL");

    By phoneNumber = By.id("phone");
    //yourRegionDropDown
    By yourRegion = By.id("00Nw0000008iSjO");

    //Contact me by
    By ContactMeByPhone = By.id("00Nw0000008iSjJ");
    By ContactMeByEmail = By.id("00Nw0000008iSjI");

    By captch = By.xpath(".//*[@id='recaptcha-anchor']/div[5]");
    By contactSubmitButton = By.id("contactSubmit");

    public WebElement howCanWeHelp(){ return driver.findElement(howCanWeHelp);}
    public WebElement email(){ return driver.findElement(email);}
    public WebElement firstName(){ return driver.findElement(firstName);}
    public WebElement surName(){ return driver.findElement(surName);}
    public WebElement company(){ return driver.findElement(company);}
    public WebElement position_JobTitle(){ return driver.findElement(position_JobTitle);}

    public WebElement businessArea(){ return driver.findElement(businessArea);}

    public WebElement phoneNumber(){ return driver.findElement(phoneNumber);}

    public WebElement yourRegion(){ return driver.findElement(yourRegion);}

    public WebElement ContactMeByPhone(){ return driver.findElement(ContactMeByPhone);}
    public WebElement ContactMeByEmail(){ return driver.findElement(ContactMeByEmail);}
    public WebElement captch(){ return driver.findElement(captch);}
    public WebElement contactSubmitButton(){ return driver.findElement(contactSubmitButton);}

    }
