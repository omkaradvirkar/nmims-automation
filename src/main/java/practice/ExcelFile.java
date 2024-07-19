package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Xl File-Workbook-Sheets-Rows-Cells

public class ExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file=new FileInputStream("./Configuration/CommunicationTemplate.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int row = sheet.getLastRowNum();
		int cell = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Number of cells"+cell);
		System.out.println("Number of rows"+row);
		
		for(int r=0;r<row;r++) {
			XSSFRow currentRow = sheet.getRow(r);
			
			for(int c=0;c<cell;c++) {
						XSSFCell currentcell = currentRow.getCell(c);
						System.out.println(currentcell.toString());
				
				
			}
			
		}
		workbook.close();
		file.close();
		
	}

}
