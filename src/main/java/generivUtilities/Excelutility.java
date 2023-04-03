package generivUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	private Workbook wb;
	public void excelInitialization(String excelpath) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//to get single cell values from excel sheet
	public String readDataFromExcel(String sheetname, int rowNum, int cellNum) {
		String data = wb.getSheet(sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
	//to get multiple cell values from excel sheet
	public Map<String,String> readDataFromExcel(String sheetName, String expectedTestName) {
		Map<String,String> map=new HashMap<>();
		 Sheet sheet = wb.getSheet(sheetName);
		 for(int i=0;i<=sheet.getLastRowNum();i++) {
			String actualTestName = sheet.getRow(i).getCell(1).getStringCellValue();
			 if(actualTestName.equalsIgnoreCase(expectedTestName)) {
				 for(int j=i;j<=sheet.getLastRowNum();j++) {
					String key = sheet.getRow(j).getCell(2).getStringCellValue();
					String value = sheet.getRow(j).getCell(3).getStringCellValue();
					map.put(key, value);
					if(key.equals("####"))
						break;
					  }
				 break;
			 }
		 }
		return map;
	}
	
	
	public void closeWorkbook() {
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}
	public void writeToDataExcel(String sheetName, int rowNum, int cellNum, String data, String excelpath) {
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos=null;
		try {
			  fos=new FileOutputStream(excelpath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		  try {
				wb.write(fos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
 public void writeToExcel(String sheetName, String status, String ExpectedTestName, String excelpath) {
	Sheet sheet = wb.getSheet(sheetName);
	for(int i=0;i<=sheet.getLastRowNum();i++) {
		String actualTestName = sheet.getRow(i).getCell(1).getStringCellValue();
	  if(actualTestName.equalsIgnoreCase(ExpectedTestName)){
		  Cell cell=sheet.getRow(i).createCell(4);
		  cell.setCellValue(status);
		  FileOutputStream fos=null;
		  try {
			  fos=new FileOutputStream(excelpath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		  try {
				wb.write(fos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		  break;
		  
		  
	  }

    }
  }
}
