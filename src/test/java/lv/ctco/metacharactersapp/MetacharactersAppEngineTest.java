package lv.ctco.metacharactersapp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
