package cz.valkova.darja;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimeNumberReaderTest {

    private static final String RESOURCE_DIR = "src/test/resources/";

    @Test
    public void testPrint() throws Exception {
        File file = new File(RESOURCE_DIR + "vzorek_dat.xlsx");
        PrimeNumberReader reader = new PrimeNumberReader(file.getAbsolutePath());

        List<Integer> expectedNums = new ArrayList<>();
        expectedNums.add(5645657);
        expectedNums.add(15619);
        expectedNums.add(1234187);
        expectedNums.add(211);
        expectedNums.add(7);
        expectedNums.add(9788677);
        expectedNums.add(23311);
        expectedNums.add(54881);
        List<Integer> actualNums = reader.read();

        assertEquals(expectedNums, actualNums);
    }


    @Test
    public void testPrintInvalidDataDecimal() throws Exception {
        File file = new File(RESOURCE_DIR + "vzorek_dat_invalid_decimal.xlsx");
        PrimeNumberReader reader = new PrimeNumberReader(file.getAbsolutePath());

        List<Integer> expectedNums = new ArrayList<>();
        expectedNums.add(15619);
        expectedNums.add(1234187);
        expectedNums.add(211);
        expectedNums.add(9788677);
        expectedNums.add(23311);
        expectedNums.add(54881);
        List<Integer> actualNums = reader.read();

        assertEquals(expectedNums, actualNums);
    }

    @Test
    public void testPrintInvalidDataNegative() throws Exception {
        File file = new File(RESOURCE_DIR + "vzorek_dat_invalid_negativ.xlsx");
        PrimeNumberReader reader = new PrimeNumberReader(file.getAbsolutePath());

        List<Integer> expectedNums = new ArrayList<>();
        expectedNums.add(5645657);
        expectedNums.add(15619);
        expectedNums.add(1234187);
        expectedNums.add(7);
        expectedNums.add(9788677);
        expectedNums.add(23311);
        List<Integer> actualNums = reader.read();

        assertEquals(expectedNums, actualNums);
    }

    @Test
    public void testPrintInvalidDataString() throws Exception {
        File file = new File(RESOURCE_DIR + "vzorek_dat_invalid_string.xlsx");
        PrimeNumberReader reader = new PrimeNumberReader(file.getAbsolutePath());
        List<Integer> expectedNums = new ArrayList<>();
        expectedNums.add(5645657);
        expectedNums.add(1234187);
        expectedNums.add(211);
        expectedNums.add(9788677);
        expectedNums.add(23311);
        expectedNums.add(54881);
        List<Integer> actualNums = reader.read();

        assertEquals(expectedNums, actualNums);
    }

    @Test
    public void testPrintInvalidDataEmpty() throws Exception {
        File file = new File(RESOURCE_DIR + "vzorek_dat_empty.xlsx");
        PrimeNumberReader reader = new PrimeNumberReader(file.getAbsolutePath());
        List<Integer> expectedNums = new ArrayList<>();
        expectedNums.add(5645657);
        expectedNums.add(1234187);
        expectedNums.add(211);
        expectedNums.add(9788677);
        expectedNums.add(23311);
        expectedNums.add(54881);
        List<Integer> actualNums = reader.read();

        assertEquals(0, actualNums.size());
    }

    @Test
    public void testPrintInputFileNotFound() {
        File file = new File(RESOURCE_DIR + "fake.xlsx");
        PrimeNumberReader reader = new PrimeNumberReader(file.getAbsolutePath());
        assertThrows(FileNotFoundException.class, () -> reader.read());
    }

}
