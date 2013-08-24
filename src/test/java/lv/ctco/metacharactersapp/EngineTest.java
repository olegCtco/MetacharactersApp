package lv.ctco.metacharactersapp;

import org.junit.Test;
import org.mockito.InjectMocks;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class EngineTest {
    @InjectMocks
    Engine engine = new Engine();

    @Test
    public void shouldHaveTwoGroupsStrippedOut() {
        String inputLine = "ab\\\ncd\\\nef";
        String expectedLine = "abcdef";
        String resultLine = engine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void shouldHaveOneGroupStrippedOut() {
        String inputLine = "abc\\\ndef";
        String expectedLine = "abcdef";
        String resultLine = engine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void shouldHaveUnchangedBecauseWrongOrder() {
        String inputLine = "abc\n\\def";
        String expectedLine = new String(inputLine);
        String resultLine = engine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void shouldHaveUnchangedBecauseHaveNotNewline() {
        String inputLine = "abc\\def";
        String expectedLine = new String(inputLine);
        String resultLine = engine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void shouldHaveUnchangedBecauseHaveNotBackslash() {
        String inputLine = "abc\ndef";
        String expectedLine = new String(inputLine);
        String resultLine = engine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void shouldHaveUnchangedBecauseNotRequired() {
        String inputLine = "abcdef";
        String expectedLine = new String(inputLine);
        String resultLine = engine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void testOneGroupStrippedOut() {
        String inputLine = "\\\n";
        String expectedLine = "";
        String resultLine = engine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void testOneNewlineNotStrippedOut() {
        String inputLine = "\n";
        String expectedLine = "\n";
        String resultLine = engine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void testOneBackslashNotStrippedOut() {
        String inputLine = "\\";
        String expectedLine = "\\";
        String resultLine = engine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void testOneNewlineBackslashNotStrippedOut() {
        String inputLine = "\n\\";
        String expectedLine = "\n\\";
        String resultLine = engine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void testMaxRandom() {
        String inputLine = "a\\\\\\\\\\\\\\\\b\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\nc";
        String expectedLine = "a\\\\\\\\\\\\\\\\bc";
        String resultLine = engine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expectedLine, resultLine);
    }

    @Test
    public void testNullInputString() {
        String inputLine = null;
        String resultLine = engine.stripBackslashNewlineSomeCombinations(inputLine);
        assertNull(resultLine);
    }

    @Test
    public void testEmptyInputString() {
        String inputLine = "";
        String expected = "";
        String resultLine = engine.stripBackslashNewlineSomeCombinations(inputLine);
        assertEquals(expected, resultLine);
    }
}