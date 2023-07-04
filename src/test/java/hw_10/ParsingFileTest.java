package hw_10;
import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ParsingFileTest {

    @Test
    void zipTest() throws Exception {

        try (ZipFile zipFile = new ZipFile("src/test/resources/test.zip")) {

            ZipEntry entryXls = zipFile.getEntry("test.xls");
            try (InputStream stream = zipFile.getInputStream(entryXls)) {
                XLS xls = new XLS(stream);
                Assertions.assertEquals("test11",
                        xls.excel.getSheetAt(1).
                                getRow(0)
                                .getCell(0)
                                .getStringCellValue());
            }

            ZipEntry entryPdf = zipFile.getEntry("test.pdf");
            try (InputStream stream = zipFile.getInputStream(entryPdf)) {
                PDF pdf = new PDF(stream);
                Assertions.assertEquals("Пример pdf", pdf.title);
            }

            ZipEntry entryCsv = zipFile.getEntry("test_csv.csv");
            try (InputStream stream = zipFile.getInputStream(entryCsv)) {
                Reader reader = new InputStreamReader(stream);
                CSVReader csvReader = new CSVReader(reader);
                List<String[]> content = csvReader.readAll();

                Assertions.assertEquals(5, content.size());

                final String[] firstRow = content.get(0);
                final String[] secondRow = content.get(1);
                final String[] thirdRow = content.get(2);
                final String[] fourthRow = content.get(3);
                final String[] fifthRow = content.get(4);

                Assertions.assertArrayEquals(new String[]{"Number", "Name"}, firstRow);
                Assertions.assertArrayEquals(new String[]{"1", "Aleksandr"}, secondRow);
                Assertions.assertArrayEquals(new String[]{"2", "Aleksandr"}, thirdRow);
                Assertions.assertArrayEquals(new String[]{"3", "Ivan"}, fourthRow);
                Assertions.assertArrayEquals(new String[]{"4", "Ivan"}, fifthRow);
            }
        }
    }
}

