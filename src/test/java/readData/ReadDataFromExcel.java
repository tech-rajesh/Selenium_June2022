package readData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception {

		// file - location

		FileInputStream fis = new FileInputStream("./testData/RegistrationData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("smokeTest");

		int rowCount = sheet.getLastRowNum(); // no of row ----- return 5

		int columnCount = sheet.getRow(0).getLastCellNum();

		System.out.println("Row count : " + rowCount);
		System.out.println("Column count : " + columnCount);
		
		
		
		for(int i= 1; i <= rowCount; i ++ ) {
			
			
//			String data = sheet.getRow(i).getCell(0).toString();
//			
//			System.out.println(data);
			
			XSSFRow currentRow = sheet.getRow(i);
			
			
			
			String firstName = currentRow.getCell(0).toString();
			String lastName = currentRow.getCell(1).toString();
			String email = currentRow.getCell(2).toString();
			String phone = currentRow.getCell(3).toString();
			String address = currentRow.getCell(4).toString();
			System.out.println("======================");
			System.out.println("FirstName: " + firstName);
			System.out.println("Address: " + address);
			System.out.println("--------------------------");
			
		}
		
		
		

		

	}

}
