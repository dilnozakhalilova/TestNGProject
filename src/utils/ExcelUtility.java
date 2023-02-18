package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

// we need to import Apache POI libraries for this to work
public class ExcelUtility {
    // Order: 1.filePath, 2.Workbook, 3.Sheet, 4.Rows & Col, 5.Cell

    public static String projectPath = System.getProperty("user.dir");
    private static FileInputStream fis;
    private static Workbook workbook;
    private static Sheet sheet;

    private static void getFilePath(String filePath) {

        try {
            fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getSheet(String sheetName) {
        sheet = workbook.getSheet(sheetName);
    }

    private static int rowCount() {
        return sheet.getPhysicalNumberOfRows();      // This method will return total count of rows

    }

    private static int colCount() {
        return sheet.getRow(0).getLastCellNum();   // This method will return total count of columns
    }

    private static String getCell(int rowIndex, int columIndex) {  // This method will read from a cell based on the inder of given row and column.
        return sheet.getRow(rowIndex).getCell(columIndex).toString();
    }


    public static Object[][] readFromExcel(String filePath, String sheetName) {
        getFilePath(filePath);
        getSheet(sheetName);
        int rows = rowCount();
        int cols = colCount();

        Object[][] data = new Object[rows-1][cols];
        for (int i = 1; i < rows; i++) {            // Start from one to avoid header
            for (int j = 0; j < cols; j++) {
                //sheet.getRow(i-1).getCell(columIndex).toString();
                // data[i][j]=sheet.getRow(i-1).getCell(columIndex).toString();
                // String cellValue = getCell(i, j);
                data[i - 1][j] = getCell(i, j);  // we are storing in Object to be able to use in DATAPROVIDER. All above are the same
            }

        }

        return data;
    }

}
