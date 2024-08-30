package inventorySystem;

public class Item
{
	String name;
	String partNumber;
	String quantity;
	String desc;
	String keyWord;
	String link = "https: ";
	
	public void printItem()
	{
		System.out.print(name + "," + partNumber + ", " + quantity + ", " + desc + ", " + keyWord + ", " + link);
	}
}
