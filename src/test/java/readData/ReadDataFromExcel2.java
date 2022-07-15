package readData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel2 {

	public static void main(String[] args) throws Exception {

		// file - location

		// FileInputStream fis = new
		// FileInputStream("./testData/RegistrationData.xlsx");
		FileInputStream fis = new FileInputStream("./testData/RegisterStudent.xls");

//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//
//		XSSFSheet sheet = workbook.getSheet("smokeTest");
//
//		int rowCount = sheet.getLastRowNum(); // no of row ----- return 5
//
//		int columnCount = sheet.getRow(0).getLastCellNum();
//
//		System.out.println("Row count : " + rowCount);
//		System.out.println("Column count : " + columnCount);

		HSSFWorkbook workbook = new HSSFWorkbook(fis);

		HSSFSheet sheet = workbook.getSheet("smokeTest");

		int rowCount = sheet.getLastRowNum(); // no of row ----- return 5

		int columnCount = sheet.getRow(0).getLastCellNum();

		System.out.println("Row count : " + rowCount);
		System.out.println("Column count : " + columnCount);

	}

}
