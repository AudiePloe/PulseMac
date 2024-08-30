package inventorySystem;

import java.awt.print.PrinterException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.xmlbeans.StringEnumAbstractBase.Table;

public class GUIManager {
	
	private static MainFrame mainFrame;
	private static InventoryFrame invFrame;
	private static ProjectSelectFrame projSelFrame;
	private static ProjectInventoryFrame projInvFrame;
	
	private static TableModel invTable;

	public static GUIManager t = new GUIManager();
	
	
	public void init()
	{
		mainFrame = new MainFrame();
		invFrame = new InventoryFrame();
		projSelFrame = new ProjectSelectFrame();
		projInvFrame = new ProjectInventoryFrame();
		
		mainFrame.setVisible(true);
		invFrame.setVisible(false);
		projSelFrame.setVisible(false);
		projInvFrame.setVisible(false);
		
	}
	
	public void goToMainMenu()
	{
		mainFrame.setVisible(true);
		invFrame.setVisible(false);
		projSelFrame.setVisible(false);
		projInvFrame.setVisible(false);
	}
	
	public void goToProjSelect()
	{
		mainFrame.setVisible(false);
		invFrame.setVisible(false);
		projSelFrame.setVisible(true);
		projInvFrame.setVisible(false);
	}
	
	public void goToinv()
	{
		mainFrame.setVisible(false);
		invFrame.setVisible(true);
		projSelFrame.setVisible(false);
		projInvFrame.setVisible(false);
	}
	
	public void goToProjInv()
	{
		mainFrame.setVisible(false);
		invFrame.setVisible(false);
		projSelFrame.setVisible(false);
		projInvFrame.setVisible(true);
	}
	
	
	public void loadToTable(Item[] items)
	{
		String[] columNames = {"Name", "Part Number", "Quantity", "KeyWord"};
		invTable = new DefaultTableModel(columNames, items.length);
		
		for(int i = 0; i < items.length; i++)
		{
			invTable.setValueAt(items[i].name, i, 0);
			invTable.setValueAt(items[i].partNumber, i, 1);
			invTable.setValueAt(items[i].quantity, i, 2);
			invTable.setValueAt(items[i].keyWord, i, 3);
		}
		
		invFrame.inventoryTable.setModel(invTable);
	}
	
	public void unloadFromTable()
	{
		TableModel tm = invFrame.inventoryTable.getModel();
		Item[] newItems = new Item[tm.getRowCount()];
		
		for(int i = 0; i < newItems.length; i++)
		{
			newItems[i] = new Item();
			newItems[i].name = (String) tm.getValueAt(i, 0);
			newItems[i].partNumber = (String) tm.getValueAt(i, 1);
			newItems[i].quantity = (String) tm.getValueAt(i, 2);
			newItems[i].keyWord = (String) tm.getValueAt(i, 3);
			
			newItems[i].desc = InventoryManager.inventory[i].desc;
			newItems[i].link = InventoryManager.inventory[i].link;

		}
		
		InventoryManager.inventory = newItems;
		InventoryManager.refreshFile();
		InventoryManager.printInventory();
	}
	
}
