package inventorySystem;

import java.io.File;

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
		
	}
	
	private static void loadProjects()
	{
		
	}

}
