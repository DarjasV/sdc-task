package cz.valkova.darja;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

    private static final String RESOURCE_DIR = "src/test/resources/";

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testMainMethod() {
        String[] args = {RESOURCE_DIR + "vzorek_dat.xlsx"};

        Main.main(args);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(5645657);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(15619);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(1234187);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(211);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(7);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(9788677);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(23311);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(54881);
        stringBuilder.append(System.lineSeparator());
        assertEquals(stringBuilder.toString(), outputStreamCaptor.toString());
    }

    @Test
    public void testMainMethodWithoutArgs() {
        assertThrows(IllegalArgumentException.class, () -> Main.main(new String[]{}));
    }

}
