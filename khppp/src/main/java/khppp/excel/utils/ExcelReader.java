package khppp.excel.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;

/**
 * Created by Serhii_Pirohov on 26.11.2014.
 */
public class ExcelReader {

    public static final Logger LOG = LogManager.getLogger(ExcelReader.class);

    private XSSFSheet excelWSheet;
    private XSSFWorkbook excelWBook;
    private XSSFCell cell;

    // This method is to set the File path and to open the Excel file, Pass
    // Excel Path and Sheetname as Arguments to this method
    public void setExcelFile(String Path, String SheetName) {
        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(Path);
            // Access the required test data sheet
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(SheetName);
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }

    public Object[][] getTableArray(List<Integer> rowsNo) {
        Object[][] tabArray = new Object[rowsNo.size()][];
        // Access the required test data sheet
        for (int i = 0; i < rowsNo.size(); i++) {

            tabArray[i] = getRowData(rowsNo.get(i));
        }
        return tabArray;
    }

    public List[] getRowData(int rowNo) {
        List[] arr = new List[1];
        List<String> list = new ArrayList<>();
        // Access the required test data sheet
        int startCol = 1;
        int totalCols = excelWSheet.getRow(rowNo).getPhysicalNumberOfCells();
        for (int i = startCol; i < totalCols; i++) {
            String cellData = getCellData(rowNo, i);
            list.add(cellData);
        }
        arr[0] = list;
        return arr;
    }

    // This method is to read the test data from the Excel cell, in this we are
    // passing parameters as Row num and Col num
    public String getCellData(int rowNum, int colNum) {
        cell = excelWSheet.getRow(rowNum).getCell(colNum);
        String result;
        int cellType = cell.getCellType();
        if (cellType == CELL_TYPE_NUMERIC) {
            return Double.valueOf(cell.getNumericCellValue()).toString();
        } else {
            result = cell.getStringCellValue();
        }
        return result;
    }

    public List<Integer> getRowContains(String testCaseName, int colNum)
            throws Exception {
        List<Integer> list = new ArrayList<>();
        try {
            int rowCount = getRowUsed();
            for (int i = 0; i <= rowCount; i++) {
                String cellData = getCellData(i, colNum);
                if (cellData.equalsIgnoreCase(testCaseName)) {
                    list.add(i);
                }
            }
            return list;
        } catch (Exception e) {
            LOG.error("Exception happens " + e);
            throw (e);
        }
    }

    public int getRowUsed() throws Exception {
        return excelWSheet.getLastRowNum();
    }

}
