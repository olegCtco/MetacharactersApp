package lv.ctco.metacharactersapp;

public class Engine {
    public String stripBackslashNewlineSomeCombinations(String inputLine) {
        if (inputLine == null) return inputLine;
        return inputLine.replaceAll("\\\\+\n", "");
    }
}