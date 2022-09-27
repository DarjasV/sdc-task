package cz.valkova.darja;

import org.apache.logging.log4j.core.util.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.STRING;

/**
 * Class for reading xlsx files with prime numbers
 */
public class PrimeNumberReader {

    private final String excelPath;

    public PrimeNumberReader(String excelPath) {
        this.excelPath = excelPath;
    }


    /**
     * Read xlsx files with prime numbers
     *
     * @return list of prime numbers found on first sheet
     * @throws IOException
     * @throws IllegalArgumentException
     */
    public List<Integer> read() throws IOException, IllegalArgumentException {
        if (!FileUtils.getFileExtension(new File(this.excelPath))
                .equalsIgnoreCase("xlsx")) {
            throw new IllegalArgumentException("File extension is not supported. Supported only xlsx.");
        }

        FileInputStream file = new FileInputStream(this.excelPath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet firstSheet = workbook.getSheetAt(0);
        return getPrimeNumbers(firstSheet);
    }

    /**
     * Get prime numbers from xls sheet
     *
     * @param sheet
     * @return
     */
    private List<Integer> getPrimeNumbers(Sheet sheet) {
        List<Integer> out = new ArrayList<>();
        for (Row row : sheet) {
            Cell secondCell = row.getCell(1);
            if (secondCell != null && secondCell.getCellType() == STRING) {
                try {
                    Integer number = Integer.valueOf(secondCell.getStringCellValue());
                    if (isPrimeNum(number)) {
                        out.add(number);
                    }
                } catch (NumberFormatException e) {
                    // ignore not valid values
                }
            }
        }

        return out;
    }


    /**
     * Check if num is prime number
     *
     * @param num
     * @return
     */
    private boolean isPrimeNum(Integer num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }

}
