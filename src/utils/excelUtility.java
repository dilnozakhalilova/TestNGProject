package utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

// we need to import Apache POI libraries for this to work
public class excelUtility {
    // Order: 1.filePath, 2.Workbook, 3.Sheet, 4.Rows & Col, 5.Cell

    static String projectPath = System.getProperty("user.dir");
    void getFilePath(String filePath) {

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
