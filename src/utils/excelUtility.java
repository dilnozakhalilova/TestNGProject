package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

// we need to import Apache POI libraries for this to work
public class excelUtility {
    // Order: 1.filePath, 2.Workbook, 3.Sheet, 4.Rows & Col, 5.Cell

    static String projectPath = System.getProperty("user.dir");
    FileInputStream fis;
    Workbook workbook;
    Sheet sheet;

    void getFilePath(String filePath) {

        try {
            fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void getSheet(String sheetName) {
        sheet = workbook.getSheet(sheetName);
    }

    int rowCount() {
        return sheet.getPhysicalNumberOfRows();      // This method will return total count of rows

    }

    int colCount() {
        return sheet.getRow(0).getLastCellNum();   // This method will return total count of columns
    }

    String getCell(int rowIndex, int columIndex) {  // This method will read from a cell based on the inder of given row and column.
        return sheet.getRow(rowIndex).getCell(columIndex).toString();
    }


    public Object [][] readFromExcel(String filePath, String sheetName){
        getFilePath(filePath);
        getSheet(sheetName);
        int rows=rowCount();
        int cols = colCount();

    Object [][] data= new Object[rows][cols];
        for (int i = 1; i <rows ; i++) {            // Start from one to avoid header
            for (int j = 0; j < cols; j++) {

            }

        }


    }

}
