package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.logging.Logger;

public class ExcelHelper {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelHelper(){

    }
    public static void main(String[] args) {
        //getRowCount();
        //getCellData();
    }

    public static void excelSetup(){
        try {
            workbook = new XSSFWorkbook("src/main/java/data/test data.xlsx");
            sheet = workbook.getSheet("Test Data");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void getRowCount(){
        excelSetup();
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("Number of rows: "+rowCount);
    }

    public static String getCellDataString(int rowNum, int cellNum){
        excelSetup();
        String cellData = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
        return cellData;
    }

    public static double getCellDataInt(int rowNum, int cellNum){
        excelSetup();
        double cellData = sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
        return cellData;
    }


}
