/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

/**
 *
 * @author wolle
 */
public class PasswordGenerator {

    private static String[] ascci;

    static {
        PasswordGenerator.ascci = getAssciStringArray();
    }

    private static String[] getAssciStringArray() {
        final int asciiDigitSize = 128;
        String[] ascii = new String[asciiDigitSize];

        for (char i = 0; i < asciiDigitSize; i++) {
            ascii[i] = Character.toString(i);
        }
        return ascii.clone();
    }

    public static String getPassword(int length) {
        int passwordFinalLength = length;
        int passwordMinLength = 4;
        String password = new String();
        password = getUpperCaseLetter() + getLowerCaseLetter() + getNumber() + getSpecialSign();

        if (passwordFinalLength > passwordMinLength) {
            password += getRandomString(passwordFinalLength - passwordMinLength);
        }

        password = StringShuffler.shuffleString(password);
        return password;
    }

    private static String getUpperCaseLetter() {
        final int upperCaseAsciiStart = 65;
        final int upperCaseAsciiEnd = 90;
        int assciValue = getRandomNumberInRange(upperCaseAsciiStart, upperCaseAsciiEnd);
        return ascci[assciValue];

    }

    private static String getLowerCaseLetter() {
        final int lowerCaseAsciiStart = 97;
        final int lowerCaseAsciiEnd = 122;
        int assciValue = getRandomNumberInRange(lowerCaseAsciiStart, lowerCaseAsciiEnd);
        return ascci[assciValue];
    }

    private static String getNumber() {
        // ASCCI Range 48-57 -- but as I just want a number ...
        return "" + getRandomNumberInRange(0, 9);
        // So why exactly does prepending an empty string works as an
        // intToString-convertion but toString or (String) does not?
    }

    private static String getSpecialSign() {
        // Three Ranges in ASCII, so decide randomly which to use first
        int specialCaseStart = 0;
        int specialCaseEnd = 0;

        int rangeId = getRandomNumberInRange(0, 2);
        switch (rangeId) {
            case 0:
                specialCaseStart = 33;
                specialCaseEnd = 47;
                break;
            case 1:
                specialCaseStart = 58;
                specialCaseEnd = 64;
                break;
            case 2:
                specialCaseStart = 123;
                specialCaseEnd = 126;
                break;
        }
        int assciValue = getRandomNumberInRange(specialCaseStart, specialCaseEnd);
        return ascci[assciValue];
    }

    private static String getRandomDigit() {
        int kindOfDigit = getRandomNumberInRange(0, 3);
        switch (kindOfDigit) {
            case 0:
                return getNumber();
            case 1:
                return getSpecialSign();
            case 2:
                return getLowerCaseLetter();
            case 3:
                return getUpperCaseLetter();
        }
        return "";
    }

    private static String getRandomString(int lenght) {
        String randomString = new String();
        for (int i = 0; i < lenght; i++) {
            randomString += getRandomDigit();
        }
        return randomString;
    }

    private static int getRandomNumberInRange(int lowerRange, int upperRange) {
        double randomNumber = (Math.random() * (upperRange - lowerRange + 1) + lowerRange);
        return (int) randomNumber;
    }
}
