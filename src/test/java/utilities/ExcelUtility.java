package utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;   
	String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
		
	public int getRowCount(String sheetName) throws IOException 
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;		
	}
	
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}
	
	
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try{
		data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
	}
	
		public static void write(String sheetName,int rowno,int colno,String data) throws IOException {
		
		// Opening the excel file 
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\DataFile.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		//Creating the sheet if it does not exist
		
		if(book.getSheetIndex(sheetName)==-1) {
			book.createSheet(sheetName);
		}
		XSSFSheet sheet = book.getSheet(sheetName);
		if(sheet.getRow(rowno)==null) {
			sheet.createRow(rowno);
		}
		XSSFRow row = sheet.getRow(rowno);
		
		XSSFCell cell = row.createCell(colno);
		
		cell.setCellValue(data);
		
		FileOutputStream fo = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\DataFile.xlsx");
		
		book.write(fo);
		book.close();
		file.close();
		fo.close();
	}
	
	
}


