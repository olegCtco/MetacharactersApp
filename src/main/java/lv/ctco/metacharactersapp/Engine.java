package lv.ctco.metacharactersapp;

public class Engine {

    public String stripBackslashNewlineSomeCombinations(String inputLine) {
        return inputLine.replaceAll("\\\\+\n", "");
    }
}