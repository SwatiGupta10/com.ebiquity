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
        float coinTossProbability = getCoinTossProbability();
        if (coinTossProbability > 0.5){
            return true;
        }
        return false;
    }
}
