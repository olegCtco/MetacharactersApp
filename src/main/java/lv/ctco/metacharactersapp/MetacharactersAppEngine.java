package lv.ctco.metacharactersapp;

/**
 * Created with IntelliJ IDEA.
 * User: fedkin
 * Date: 8/22/13
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class MetacharactersAppEngine {

    public String stripBackslashNewlineSomeCombinations(String s) {
        if (isEmpty(s)) return s;
        if (isNotContainsFromBackslashNewlines(s)) return s;
        if (isOnlyOneBackslashOrNewLine(s)) return s;
//        if (isWrongOrder(s)) return s;

        int counter = 0;
        char[] chars = s.toCharArray();
        char[] result = new char[s.length()];
        for (int i = chars.length - 1, y = 0; i >= 0; i--) {
            if (counter == 0) {
                if (chars[i] != '\n') {
                    result[y] = chars[i];
                    y++;
                } else if (i == 0) {
                    result[y] = chars[i];
                    y++;
                } else {
                    counter++;
                }
            } else if (counter == 1) {
                if (chars[i] == '\\') {
                    counter++;
                } else {
                    result[y] = '\n';
                    y++;
                    result[y] = chars[i];
                    y++;
                    counter = 0;
                }
            } else {
                if (chars[i] == '\\') {
                    counter++;
                } else {
                    result[y] = chars[i];
                    y++;
                    counter = 0;
                }
            }
        }

        String beforeReverse = new String(result).trim();
        String reverse = new StringBuffer(beforeReverse).reverse().toString();
        return reverse;
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

//    public boolean isWrongOrder(String s) {
//        boolean flag = true;
//        for (int i = 0; i < s.length(); i++) {
//            if (flag) {
//                if (s.charAt(i) == '\n') {
//                    flag = false;
//                }
//            } else if (!flag) {
//                if (s.charAt(i) == '\\') {
//                    return true;
//                } else {
//                    flag = true;
//                }
//            }
//        }
//        return false;
//    }
}
