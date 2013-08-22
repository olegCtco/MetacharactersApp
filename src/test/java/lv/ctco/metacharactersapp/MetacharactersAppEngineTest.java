package lv.ctco.metacharactersapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: fedkin
 * Date: 8/22/13
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class MetacharactersAppEngineTest {
    @Test
    public void shouldTwoStrippedOut() {
        String inputLine = "ab\\\ncd\\\nef";
        String expectedLine = "abcdef";

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        String resultLine = metacharactersAppEngine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void shouldOneStrippedOut() {
        String inputLine = "abc\\\ndef";
        String expectedLine = "abcdef";

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        String resultLine = metacharactersAppEngine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void shouldUnchangedBecauseWrongOrder() {
        String inputLine = "abc\n\\def";
        String expectedLine = new String(inputLine);

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        String resultLine = metacharactersAppEngine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void shouldUnchangedBecauseNoNewline() {
        String inputLine = "abc\\def";
        String expectedLine = new String(inputLine);

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        String resultLine = metacharactersAppEngine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void shouldUnchangedBecauseNoBackslash() {
        String inputLine = "abc\ndef";
        String expectedLine = new String(inputLine);

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        String resultLine = metacharactersAppEngine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void shouldUnchangedBecauseNoRequired() {
        String inputLine = "abcdef";
        String expectedLine = new String(inputLine);

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        String resultLine = metacharactersAppEngine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void shouldReturnTrueIfNull_isEmpty() {
        String inputLine = null;

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        boolean result = metacharactersAppEngine.isEmpty(inputLine);
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueIfEmpty_isEmpty() {
        String inputLine = "";

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        boolean result = metacharactersAppEngine.isEmpty(inputLine);
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseIfNotEmpty_isEmpty() {
        String inputLine = " ";

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        boolean result = metacharactersAppEngine.isEmpty(inputLine);
        assertFalse(result);
    }

    @Test
    public void shouldTrueBecauseNoRequired_isNotContainsFromBackslashNewlines() {
        String inputLine = "abcdef";

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        boolean result = metacharactersAppEngine.isNotContainsFromBackslashNewlines(inputLine);
        assertTrue(result);
    }

    @Test
    public void shouldFalseBecauseBackslash_isNotContainsFromBackslashNewlines() {
        String inputLine = "abcdef\\";

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        boolean result = metacharactersAppEngine.isNotContainsFromBackslashNewlines(inputLine);
        assertFalse(result);
    }

    @Test
    public void shouldFalseBecauseNewLine_isNotContainsFromBackslashNewlines() {
        String inputLine = "abcdef\n";

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        boolean result = metacharactersAppEngine.isNotContainsFromBackslashNewlines(inputLine);
        assertFalse(result);
    }

    @Test
    public void shouldTrueBecauseOneBackslash_isOnlyOneBackslashOrNewLine() {
        String inputLine = "abcdef\\";

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        boolean result = metacharactersAppEngine.isOnlyOneBackslashOrNewLine(inputLine);
        assertTrue(result);
    }

    @Test
    public void shouldTrueBecauseOneNewline_isOnlyOneBackslashOrNewLine() {
        String inputLine = "abcdef\n";

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        boolean result = metacharactersAppEngine.isOnlyOneBackslashOrNewLine(inputLine);
        assertTrue(result);
    }

    @Test
    public void shouldFalseBecauseTwoNewlines_isOnlyOneBackslashOrNewLine() {
        String inputLine = "abcdef\n\n";

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        boolean result = metacharactersAppEngine.isOnlyOneBackslashOrNewLine(inputLine);
        assertFalse(result);
    }

    @Test
    public void shouldFalseBecauseTwoBackslashes_isOnlyOneBackslashOrNewLine() {
        String inputLine = "abcdef\\\\";

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        boolean result = metacharactersAppEngine.isOnlyOneBackslashOrNewLine(inputLine);
        assertFalse(result);
    }

    @Test
    public void shouldFalseBecauseNoBackslashesOrNewlines_isOnlyOneBackslashOrNewLine() {
        String inputLine = "abcdef";

        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
        boolean result = metacharactersAppEngine.isOnlyOneBackslashOrNewLine(inputLine);
        assertFalse(result);
    }

//    @Test
//    public void shouldTrueBecauseWrongOrder_isWrongOrder(){
//        String inputLine = "abc\n\\def";
//
//        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
//        boolean result = metacharactersAppEngine.isWrongOrder(inputLine);
//        assertTrue(result);
//    }
//
//    @Test
//    public void shouldFalseBecauseCorrectOrder_isWrongOrder(){
//        String inputLine = "abc\\\ndef";
//
//        MetacharactersAppEngine metacharactersAppEngine = new MetacharactersAppEngine();
//        boolean result = metacharactersAppEngine.isWrongOrder(inputLine);
//        assertFalse(result);
//    }
}
