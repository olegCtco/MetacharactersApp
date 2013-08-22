package lv.ctco.metacharactersapp;

/**
 * Created with IntelliJ IDEA.
 * User: fedkin
 * Date: 8/22/13
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class MetacharactersAppEngine {

    public String stripBackslashNewlineSomeCombinations(String inputLine) {
        if (isEmpty(inputLine)) return inputLine;
        if (isNotContainsFromBackslashNewlines(inputLine)) return inputLine;
        if (isOnlyOneBackslashOrNewLine(inputLine)) return inputLine;

        int tempRemovalSubstringCharCounter = 0;
        int indexForResultCharArray = 0;
        char[] inputLineCharArray = inputLine.toCharArray();
        char[] resultReversedCharArray = new char[inputLine.length()];
        for (int indexForInputLineCharArray = inputLineCharArray.length - 1; indexForInputLineCharArray >= 0; indexForInputLineCharArray--) {
            if (tempRemovalSubstringCharCounter == 0) {
                if (inputLineCharArray[indexForInputLineCharArray] != '\n') {
                    resultReversedCharArray[indexForResultCharArray] = inputLineCharArray[indexForInputLineCharArray];
                    indexForResultCharArray++;
                } else {
                    tempRemovalSubstringCharCounter++;
                }
            } else if (tempRemovalSubstringCharCounter == 1) {
                if (inputLineCharArray[indexForInputLineCharArray] == '\\') {
                    tempRemovalSubstringCharCounter++;
                } else {
                    resultReversedCharArray[indexForResultCharArray] = '\n';
                    indexForResultCharArray++;
                    resultReversedCharArray[indexForResultCharArray] = inputLineCharArray[indexForInputLineCharArray];
                    indexForResultCharArray++;
                    tempRemovalSubstringCharCounter = 0;
                }
            } else {
                if (inputLineCharArray[indexForInputLineCharArray] == '\\') {
                    tempRemovalSubstringCharCounter++;
                } else {
                    resultReversedCharArray[indexForResultCharArray] = inputLineCharArray[indexForInputLineCharArray];
                    indexForResultCharArray++;
                    tempRemovalSubstringCharCounter = 0;
                }
            }
        }

        String beforeReverseTrimmedLine = new String(resultReversedCharArray).trim();
        String reversedLine = new StringBuffer(beforeReverseTrimmedLine).reverse().toString();
        if (inputLine.charAt(0) == '\n') {
            reversedLine = '\n' + reversedLine;
        }
        return reversedLine;
    }

    public boolean isEmpty(String s) {
        if (s == null || s.isEmpty()) return true;
        return false;
    }

    public boolean isNotContainsFromBackslashNewlines(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\\' || s.charAt(i) == '\n') return false;
        }
        return true;
    }

    public boolean isOnlyOneBackslashOrNewLine(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\\' || s.charAt(i) == '\n') {
                counter++;
            }
        }
        if (counter == 1) return true;
        return false;
    }
}
