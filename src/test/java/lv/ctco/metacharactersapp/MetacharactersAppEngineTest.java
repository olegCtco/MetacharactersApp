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
}
