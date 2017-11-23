/**
 * RandomUtils.java - A utility class which provides methods to generate
 * random text, numbers, etc.
 *
 * @author  Swati Gupta
 * @version 1.0
 */

package utils.java.com.ebiquity;

import java.util.Random;

public class RandomUtils {

    /**
     * Returns a pseudo-random number between lb and ub (both inclusive).
     *
     * @param lb - lower bound
     * @param ub - upper bound
     * @return int between lb and ub (both inclusive)
     */
    public static int getRandomIntBetween(int lb, int ub) {
        Random random = new Random();
        int randomNum = random.nextInt((ub - lb) + 1) + lb;
        return randomNum;
    }

    /**
     * Returns a pseudo-random float [0.0, 1.0). Duplicate implementation of Random.nextDouble()
     *
     * @return float
     */
    public static float getRealBetween0and1() {
        Random random = new Random();
        int randomNum = random.nextInt(1000);
        float randomFloat = ((float)randomNum)/1000;
        return randomFloat;

    }


    /**
     * Returns a randomly generated 10-digit number.
     *
     * @return long 10-digit number.
     */
    public static long getTenDigitNumber() {
        char[] numericChars = "1234567890".toCharArray();

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char c;
            if(i == 0){
                c = numericChars[    random.nextInt(numericChars.length -1)     ];
            }
            else {
                c = numericChars[random.nextInt(numericChars.length)];
            }
            sb.append(c);
        }
        long output  = Long.parseLong(sb.toString());
        return output;
    }


    /**
     * Returns a random String of length strLen.
     *
     * @param strLen - size of the random String.
     *
     * @return String of length strLen.
     */
    public static String getRandomStringOfLen(int strLen, boolean isAlphaNumeric) {
        char[] alphaChars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphaNumericChars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        char[] chars;
        if (isAlphaNumeric){
            chars = alphaNumericChars;
        }
        else{
            chars = alphaChars;
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < strLen; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }


    /**
     * Returns a String of randomly created E-mail Id.
     *
     *
     * @return String
     */
    public static String getEmailAddress() {
        int idLen = getRandomIntBetween(10,20);
        StringBuilder sb = new StringBuilder(getRandomStringOfLen(idLen, true));
        int atIndex = getRandomIntBetween(4,9);
        int dotIndex = getRandomIntBetween(2,3);
        sb.insert(sb.length() - atIndex, "@");
        sb.insert(sb.length()-dotIndex, ".");
        return sb.toString();
    }


    /**
     * Returns a String of randomly created Sentences.
     *
     * @return String
     */
    public static String getSentences() {
        int idLen = getRandomIntBetween(100,500);
        StringBuilder sb = new StringBuilder(getRandomStringOfLen(idLen, false));
        //Logic to insert spaces.
        int i = getRandomIntBetween(0,4);
        for(; i <idLen;){
            sb.insert(i, " ");
            i += getRandomIntBetween(3,10);
        }
        //Logic to insert fullstops.
        i = getRandomIntBetween(50,60);
        for(; i <idLen;){
            sb.insert(i, ". ");
            i += getRandomIntBetween(30,60);
        }
        return sb.toString();
    }


    public static void main(String[] args){
        String output;
        long phoneNumber;
        for(int i=0; i<10; i++) {
            output = getEmailAddress();
            phoneNumber = getTenDigitNumber();
            System.out.println(output);
            System.out.println(phoneNumber);
            output = getSentences();
            System.out.println(output);
            System.out.println(getRealBetween0and1());
            System.out.println(getRandomIntBetween(0, 100));
        }
    }

}
