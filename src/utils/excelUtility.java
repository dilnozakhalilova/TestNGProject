package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
int colCount(){
        return sheet.getRow(0).getLastCellNum();   // This method will return total count of columns
}

}
