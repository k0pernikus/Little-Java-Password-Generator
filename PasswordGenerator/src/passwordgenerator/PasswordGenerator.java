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

    private static int passwordLength;
    private static String password;

    PasswordGenerator() {
        final int minPasswordLength = 4;
    }

    static String generatePassword(int length) {
        PasswordGenerator.passwordLength = length;
        return "";
    }



}
