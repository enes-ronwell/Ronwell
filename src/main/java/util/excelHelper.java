package util;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class excelHelper {


    public String getValue(int row, int cell) {
        propertiesFactory propertiesFactory = new propertiesFactory();
        File file = new File(System.getProperty("user.dir") + "\\" + propertiesFactory.getExcel());
        FileInputStream inputStream;

        {
            try {
                inputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        HSSFWorkbook workbook;

        {
            try {
                workbook = new HSSFWorkbook(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        HSSFSheet sheet=workbook.getSheet("testData");
        return sheet.getRow(row).getCell(cell).getStringCellValue();
    }

}

