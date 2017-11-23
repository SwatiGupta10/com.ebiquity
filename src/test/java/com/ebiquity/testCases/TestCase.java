/**
 * TestCase.java - A class which contains automated testcase(s) to test
 * multi-user form filling at https://www.ebiquity.com/en/contact-us
 *
 * @author  Swati Gupta
 * @version 1.0
 */

package test.java.com.ebiquity.testCases;

import main.java.com.ebiquity.pages.BasePageLocators;
import main.java.com.ebiquity.pages.BasePageFieldsGenerator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestCase {

    static final String drivers_path =  "resources" + File.separator + "drivers" ;
    Logger log = Logger.getLogger(TestCase.class);

    WebDriver driver;
    private String url = "https://www.ebiquity.com/en/contact-us";
    private BasePageLocators contactUs;
    private BasePageFieldsGenerator fieldsGen;

    //Instantiate util class objects.
    @BeforeClass
    public void setupTest() {
        fieldsGen = new BasePageFieldsGenerator();
    }

    //Setup Driver
    @BeforeMethod
    public void createDriver() {
        driver = new FirefoxDriver();
        driver.navigate().to(url);
        contactUs = new BasePageLocators(driver);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    //Testcase. Change @invocationCount to run it for multiple Users.
    @Test(invocationCount = 5, priority=0)
    public void ebiquityContactUs(ITestContext testContext) {
        int currentCount = testContext.getAllTestMethods()[0].getCurrentInvocationCount();
        log.info("Starting Test run number: " + currentCount);

        String helpText = fieldsGen.getHelpText();
        log.info("How can I help you? :" + helpText);
        contactUs.howCanWeHelp().click();
        contactUs.howCanWeHelp().sendKeys(helpText);

        String emailId = fieldsGen.getEmailId();
        log.info("*Email :" + emailId);
        contactUs.email().click();
        contactUs.email().sendKeys(emailId);

        String firstName = fieldsGen.getFirstName();
        log.info("*First Name :" + firstName);
        contactUs.firstName().click();
        contactUs.firstName().sendKeys(firstName);

        String surName = fieldsGen.getSurname();
        log.info("*Surname :" + surName);
        contactUs.surName().click();
        contactUs.surName().sendKeys(surName);

        String company = fieldsGen.getCompany();
        log.info("*Company :" + company);
        contactUs.company().click();
        contactUs.company().sendKeys(company);

        String position = fieldsGen.getPosition();
        log.info("Position / Job Title :" + position);
        contactUs.position_JobTitle().click();
        contactUs.position_JobTitle().sendKeys(position);

        int businessAreaIndex = fieldsGen.getBusinessAreaIndex();
        log.info("Business Area" + businessAreaIndex);
        Select business = new Select(contactUs.businessArea());
        business.selectByIndex(businessAreaIndex);

        String phoneNumber = fieldsGen.getPosition();
        log.info("Phone Number :" + phoneNumber);
        contactUs.phoneNumber().click();
        contactUs.phoneNumber().sendKeys(phoneNumber);

        int regionIndex = fieldsGen.getRegionIndex();
        log.info("*Your Region :" + regionIndex);
        Select region = new Select(contactUs.yourRegion());
        region.selectByIndex(regionIndex);

        boolean isContactByPhone = fieldsGen.isContactByPhone();
        log.info("Contact me by :" + isContactByPhone);
        if(isContactByPhone) {
            contactUs.ContactMeByPhone().click();
        }
        else {
            contactUs.ContactMeByEmail().click();
        }

        // Captcha is not handled by Selenium Webdriver.

        log.info("Submit Button");
        contactUs.contactSubmitButton().click();

        driver.quit();
    }

    //Quit the Driver.
    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

    //Release resources util class objects.
    @AfterClass
    public void quitSetup() {
        fieldsGen = null;
    }

    //Static block to set-up driver according to OS.
    static {
         String path = drivers_path;
         String jvmProcessor = System.getProperty("sun.arch.data.model").trim();
         String osName = System.getProperty("os.name").toLowerCase();
         if(osName.indexOf("win") >= 0){
             if(jvmProcessor.equals("32")){
                 path = drivers_path + File.separator + "win32";
             }
             else{
                 path = drivers_path + File.separator + "win64";
             }
         }
         else if(osName.indexOf("nix") >= 0 || osName.indexOf("nux") >= 0 || osName.indexOf("aix") > 0){
             if(jvmProcessor.equals("32")){
                 path = drivers_path + File.separator + "linux32";
             }
             else{
                 path = drivers_path + File.separator + "linux64";
             }
         }
         else{
             path = drivers_path + File.separator + "mac";
         }
         System.setProperty("webdriver.gecko.driver", path + File.separator + "geckodriver.exe");
    }

}
