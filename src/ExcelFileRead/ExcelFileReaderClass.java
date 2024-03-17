package ExcelFileRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReaderClass {
	
	public static Map<String, String> datamap;
	ArrayList<Integer> threadid;
	static int matchingrow;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	String data;
	XSSFCell headcol;
	String header;
	String filePath = System.getProperty("user.dir")+"\\TestDataSheet\\"+"AutomationExcerciseWorkBook.xlsx";//"C:\\TestDataSheet\\AutomationExcerciseWorkBook.xlsx"; //System.getProperty("user.dir")+"\\TestDataSheet\\AutomationExcerciseWorkBook.xlsx";
	FileInputStream inputFile = null;
//	public static void main(String args[]) {
//		ExcelFileReaderClass efr=new ExcelFileReaderClass();
//		efr.readExcelFile("TestingSK01");
//	}
	
	public void readExcelFile(String testcasename) {
		
		datamap=new HashMap<String, String>();
		 threadid=new ArrayList<Integer>();
		try {
			try {
				inputFile = new FileInputStream(new File(filePath));
				wb = new XSSFWorkbook(inputFile);
			} catch (FileNotFoundException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sheet=wb.getSheet("TestData");
			int numberofRows=sheet.getPhysicalNumberOfRows();
			int lastcellnum=sheet.getRow(1).getLastCellNum();
			String firstcellnum=sheet.getRow(1).getCell(0).toString();
			for(int i=1;i<=numberofRows;i++) {
					if(sheet.getRow(i).getCell(0).toString().equals(testcasename)&& sheet.getRow(i).getCell(2).toString().equalsIgnoreCase("No Run")) {
						matchingrow=i;
						break;
					}
			}
			
				for(int j=0;j<lastcellnum;j++) {
					headcol=sheet.getRow(matchingrow).getCell(j);
					header=sheet.getRow(0).getCell(j).toString();
					switch (headcol.getCellType()) {
					case STRING:
						      data=headcol.getStringCellValue();
						      break;
					case NUMERIC:
								data=String.valueOf(headcol.getNumericCellValue());
							  break;
					case BOOLEAN:
								data=String.valueOf(headcol.getBooleanCellValue());
								break;
					case FORMULA:
								data=String.valueOf(headcol.getCellFormula());
								break;
					case BLANK:
								data="";
								break;
					case _NONE:
								data="";
								break;

					default:
							data="";
						break;
					}
					datamap.put(header, data);
				}
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getTestData(String colname) {
		Map<String, String>testDatamap;
		String columnvalue=datamap.get(colname);
		return columnvalue;
		
	}
	
	public void writeStatusToExcelSheet(String status) {
		
		XSSFCell val=sheet.getRow(matchingrow).getCell(2);
		val.setCellType(CellType.STRING);
		val.setCellValue(status);
		try {
			FileOutputStream outFile = null;
			outFile = new FileOutputStream(new File(filePath));
			wb.write(outFile);
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
			
	}
	
}
