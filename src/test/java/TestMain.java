import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public TestMain() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainFirst() {
        String data = "3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "  *\n" +
                " ***\n" +
                "*****\n";
        String actual = outContent.toString().replaceAll("\r", "");
        assertEquals(expected, actual);
    }

    @Test
    public void testMainSecond() {
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "*\n";
        String actual = outContent.toString().replaceAll("\r", "");
        assertEquals(expected, actual);
    }

    @Test
    public void testMainThird() {
        String data = "0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "";
        String actual = outContent.toString().replaceAll("\r", "");
        assertEquals(expected, actual);
    }

    @Test
    public void testMainForth() {
        String data = "5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "    *\n" +
                "   ***\n" +
                "  *****\n" +
                " *******\n" +
                "*********\n";
        String actual = outContent.toString().replaceAll("\r", "");
        assertEquals(expected, actual);
    }

    @Test
    public void testMainFifth() {
        String data = "6";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "     *\n" +
                "    ***\n" +
                "   *****\n" +
                "  *******\n" +
                " *********\n" +
                "***********\n";
        String actual = outContent.toString().replaceAll("\r", "");
        assertEquals(expected, actual);
    }
}