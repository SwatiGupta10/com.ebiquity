/**
 * BasePageFieldsGenerator.java - A class which contains methods to generate
 * random text to test the form at https://www.ebiquity.com/en/contact-us
 *
 * @author  Swati Gupta
 * @version 1.0
 */

package main.java.com.ebiquity.pages;

import static utils.java.com.ebiquity.RandomUtils.*;

public class BasePageFieldsGenerator {

    public String getHelpText(){
        return getSentences();
    }

    public String getEmailId(){
        return getEmailAddress();
    }

    public String getFirstName(){
        return getRandomStringOfLen(10, false);
    }

    public String getSurname(){
        return getRandomStringOfLen(12, false);
    }

    public String getCompany(){
        return getRandomStringOfLen(25, false);
    }

    public String getPosition(){
        return getRandomStringOfLen(20, false);
    }

    public int getBusinessAreaIndex(){
        return getRandomIntBetween(0,11);
    }

    public String getPhoneNumber(){
        long phoneNumber = getTenDigitNumber();
        return Long.toString(phoneNumber);
    }

    public int getRegionIndex(){
        return getRandomIntBetween(1,17);
    }

    public boolean isContactByPhone(){
        float coinTossProbability = getRealBetween0and1();
        if (coinTossProbability > 0.5){
            return true;
        }
        return false;
    }
}
