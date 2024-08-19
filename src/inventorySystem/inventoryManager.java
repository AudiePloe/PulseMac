package inventorySystem;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class inventoryManager {
	
	private File inventorySheet;
	
	
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
		loadItems();
		loadProjects();
	}
	
	private static void loadItems()
	{
		
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFCreationHelper createHelper = wb.getCreationHelper();
		XSSFSheet sheet = wb.createSheet("new sheet");

		// Create a row and put some cells in it. Rows are 0 based.
		XSSFRow row = sheet.createRow((short)0);
		// Create a cell and put a value in it.
		XSSFCell cell = row.createCell(0);
		cell.setCellValue(1);

		// Or do it on one line.
		row.createCell(1).setCellValue(1.2);
		row.createCell(2).setCellValue(
				createHelper.createRichTextString("This is a string"));
		row.createCell(3).setCellValue(true);

		// Write the output to a file
		FileOutputStream out;
		try {
			out = new FileOutputStream("workbook.xls");
			
			wb.write(out);
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	private static void loadProjects()
	{
		
	}

}
