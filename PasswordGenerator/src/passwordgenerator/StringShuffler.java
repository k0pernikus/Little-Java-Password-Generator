package passwordgenerator;

/**
 * @author Philipp Kretzschmar
 */
public class StringShuffler {
    public static String shuffleString(String str) {
        if (str.length() == 1) {
            return str;
        }

        int charPosition = getRandomNumberInRange(0, str.length() - 1);
        String charS = getCharAtPositon(str, charPosition);

        str = removeCharAt(str, charPosition);

        return charS + shuffleString(str);
    }

    final static int getRandomNumberInRange(int lowerRange, int upperRange) {
        double randomNumber = (Math.random() * (upperRange - lowerRange + 1) + lowerRange);
        return (int) randomNumber;
    }

    final static String getCharAtPositon(String str, int position) {
        char letter = str.charAt(position);
        return "" + letter;
    }

    final static String removeCharAt(String str, int pos) {
        StringBuilder buf = new StringBuilder(str.length() - 1);
        buf.append(str.substring(0, pos)).append(str.substring(pos + 1));
        return buf.toString();
    }
}
