package inventorySystem;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	int quantity;
	String desc;
	String keyWord;
	
	public void printItem()
	{
		System.out.print(name + "," + partNumber + ", " + quantity + ", " + desc + ", " + keyWord);
	}
}


public class inventoryManager {
	
	//private static XSSFWorkbook inventorySheet;
	
	private static Item[] inventory;
	private static File workBook = new File("C:\\Users\\Altac\\eclipse-workspace\\PulseMac\\workbook.xlsx");
	
	private static File[] projects;
	
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
			inventory = readItems(workBook);
			loadProjects();
			writeToFile(workBook, inventory);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Item[] readItems(File f) throws Exception
	{
		int rownum = 0;
		Item[] items;

		FileInputStream file = new FileInputStream(
				new File(f.getPath()));

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = wb.getSheetAt(0);

		
		// Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		
		items = new Item[sheet.getLastRowNum()]; // if no data type is on the excel sheet, add a +1 to the array count
		Row row = rowIterator.next();
		
		while (rowIterator.hasNext()) 
		{
			row = rowIterator.next();  // Skipping the first entry that shows the data types for excel users.
			
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			items[rownum] = new Item();
			
			Cell cell = cellIterator.next();
			items[rownum].name = cell.getStringCellValue();
			cell = cellIterator.next();
			
			switch (cell.getCellType()) 
            {
                case Cell.CELL_TYPE_NUMERIC:
                	items[rownum].partNumber = (int)cell.getNumericCellValue() + "";
                    break;
                case Cell.CELL_TYPE_STRING:
                	items[rownum].partNumber = cell.getStringCellValue();
                    break;
            }
			cell = cellIterator.next();
			items[rownum].quantity = (int)cell.getNumericCellValue();
			cell = cellIterator.next();
			items[rownum].desc = cell.getStringCellValue();
			cell = cellIterator.next();
			items[rownum].keyWord = cell.getStringCellValue();
			
			rownum++;
		}
		
		// show data read from file
		for(int i = 0; i < items.length; i++)
		{
			items[i].printItem();
			System.out.println();
		}
		
		System.out.println("");

		file.close();
		
		return items;
	}
	
	private static void loadProjects()
	{
		File file = new File("C:\\Users\\Altac\\eclipse-workspace\\PulseMac\\");
		
		
		File[] list = file.listFiles();
		projects = new File[0];
		int f = 0;
		if (list != null) 
		{
			for (File fil : list) 
			{
				if (fil.getName().contains("project.xlsx"))
				{
					File[] tmp = projects;
					projects = new File[tmp.length + 1];
					
					for(int i = 0; i < tmp.length; i++)
					{
						projects[i] = tmp[i];
					}
					
					projects[f] = fil;
					f++;
				}
			}
		}
		
		System.out.println("Projects found: ");
		for(int i = 0; i < projects.length; i++)
		{
			System.out.println(projects[i].getName());
		}

		System.out.println();
	}
	
	private static void writeToFile(File f, Item[] items) throws IOException
	{
		
		FileInputStream file = new FileInputStream(
				new File(f.getPath()));

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = wb.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();
		Row row = rowIterator.next();
		
		row = rowIterator.next(); // skip the data types row

		for (int i = 0; i < items.length; i++) 
		{
			Iterator<Cell> cellIterator = row.cellIterator();

			Cell cell = cellIterator.next();
			
			cell.setCellValue(items[i].name);
			cell = cellIterator.next();
			cell.setCellValue(items[i].partNumber);
			cell = cellIterator.next();
			cell.setCellValue(items[i].quantity);
			cell = cellIterator.next();
			cell.setCellValue(items[i].desc);
			cell = cellIterator.next();
			cell.setCellValue(items[i].keyWord);
			
			System.out.println("Writing: " + items[i].name);
			
			if(rowIterator.hasNext())
				row = rowIterator.next();
		}

		// Write the output to a file FileOutputStream out;
		FileOutputStream out = new FileOutputStream(f.getPath());

		wb.write(out);
		out.close();
	}
	
	private void editFileRoutine(File f)
	{
		
	}

}
