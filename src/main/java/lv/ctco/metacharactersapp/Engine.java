package lv.ctco.metacharactersapp;

import java.util.ArrayList;
import java.util.List;

public class Engine {

    public String stripBackslashNewlineSomeCombinations(String inputLine) {
        List<String> regexps = new ArrayList<>();
        String regex = "\\\\\n";
        String result = inputLine;
        regexps.add(regex);
        for (int i = 0; i < inputLine.length() - 2; i++) {
            regex = "\\\\" + regex;
            regexps.add(regex);
        }

        for (int i = regexps.size() - 1; i >= 0; i--) {
            result = result.replaceAll(regexps.get(i), "");
        }
        return result;
    }

    public boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }
}