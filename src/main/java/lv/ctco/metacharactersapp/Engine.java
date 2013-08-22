package lv.ctco.metacharactersapp;

public class Engine {

    public String stripBackslashNewlineSomeCombinations(String inputLine) {
        if (isEmpty(inputLine)) return inputLine;

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
        return s == null || s.isEmpty();
    }
}