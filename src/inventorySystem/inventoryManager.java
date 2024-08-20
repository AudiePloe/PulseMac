package inventorySystem;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


class Item
{
	String name;
	String partNumber;
	String desc;
	String keyWord;
	
	public void printItem()
	{
		System.out.println(name + ", " + partNumber + ", " + desc + ", " + keyWord);
	}
}


public class inventoryManager {
	
	//private static XSSFWorkbook inventorySheet;
	
	private static Item[] inventory = new Item[0];
	
	
	
	//load all required resources
			//load main screen
			
			//main screen
				//open projects
				//open inventory
				//exit
			
			//project screen
				//list of projects
					//fetch all project names from folder
						//open project by name
				//create new project
			
			//project screen
				//list of all items in project
				//add new item
					//list of all available items from inventory list
					//select to add
						//input reqs of item to project
					//save project
				//save project
				//build project
					//print project requirements
					//remove items from inventory
			
			//inventory screen
				//list of all items created, with quantity
				//edit item
					//input new item reqs
					//add item to inventory
					//save inventory
				//add new item
					//input item reqs
					//add item to inventory
					//save inventory
				//remove item
					//delete item from inventory
					//save inventory
				  
	
	
	public static void main(String[] args)
	{
		initilize();
		
		
	}
	
	private static void initilize()
	{
		try {
			loadItems();
			loadProjects();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void loadItems() throws Exception
	{
		int rownum = 0;

		FileInputStream file = new FileInputStream(
				new File("C:\\Users\\Altac\\eclipse-workspace\\PulseMac\\workbook.xls"));

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = wb.getSheetAt(0);

		
		// Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		
		inventory = new Item[sheet.getLastRowNum()]; // if no data type is on the excel sheet, add a +1 to the array count
		Row row = rowIterator.next();  // Skipping the first entry that shows the data types for excel users.
		
		while (rowIterator.hasNext()) 
		{
			row = rowIterator.next();
			
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			inventory[rownum] = new Item();
			
			Cell cell = cellIterator.next();
			inventory[rownum].name = cell.getStringCellValue();
			cell = cellIterator.next();
			
			switch (cell.getCellType()) 
            {
                case Cell.CELL_TYPE_NUMERIC:
                	inventory[rownum].partNumber = (int)cell.getNumericCellValue() + "";
                    break;
                case Cell.CELL_TYPE_STRING:
                	inventory[rownum].partNumber = cell.getStringCellValue();
                    break;
            }
			
			cell = cellIterator.next();
			inventory[rownum].desc = cell.getStringCellValue();
			cell = cellIterator.next();
			inventory[rownum].keyWord = cell.getStringCellValue();
			
			rownum++;
		}
		
		// show data read from file
		for(int i = 0; i < inventory.length; i++)
		{
			inventory[i].printItem();
			System.out.println();
		}
		
		System.out.println("");

		file.close();
	}
	
	private static void loadProjects()
	{
		
	}
	
	private static void writeToFile()
	{

		/*
		 * XSSFWorkbook wb = new XSSFWorkbook(); 
		 * XSSFSheet sheet = wb.createSheet("new sheet");
		 * 
		 * // Create a row and put some cells in it. Rows are 0 based. 
		 * XSSFRow row = sheet.createRow((short)0); 
		 * 
		 * // Create a cell and put a value in it. 
		 * XSSFCell cell = row.createCell(0); cell.setCellValue(1);
		 * 
		 * // Or do it on one line. 
		 * row.createCell(1).setCellValue(1.2);
		 * row.createCell(2).setCellValue(true);
		 * 
		 * row = sheet.createRow((short)1);
		 * row.createCell(0).setCellValue("Hello world");
		 * 
		 * // Write the output to a file FileOutputStream out;
		 *  try { 
		 *  	out = new FileOutputStream("workbook.xls");
		 * 
		 * 		wb.write(out); out.close();
		 * 
		 * } catch (IOException e) { 
		 * 		// TODO Auto-generated catch block
		 * 		e.printStackTrace(); 
		 * }
		 */
	}

}
