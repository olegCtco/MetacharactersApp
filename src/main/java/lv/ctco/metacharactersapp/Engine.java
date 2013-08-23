package lv.ctco.metacharactersapp;

import java.util.Arrays;
import java.util.List;

public class Engine {

    public String stripBackslashNewlineSomeCombinations(String inputLine) {
        String regex = "\\\\\n";
        if (isEmpty(inputLine)) return inputLine;

        List<String> stringList = Arrays.asList(inputLine.split(regex));
        String result = "";
        for (String s : stringList) {
            result += s;
        }
        return result;
    }

    public boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }
}