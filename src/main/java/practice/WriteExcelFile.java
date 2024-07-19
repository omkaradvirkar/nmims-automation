package practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		FileOutputStream output=new FileOutputStream("./Configuration/Book1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Omkar");
		row1.createCell(1).setCellValue("Automation");
		
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Advirkar");
		row2.createCell(1).setCellValue("Java");
	}

}
