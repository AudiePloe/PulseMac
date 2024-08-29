package inventorySystem;

public class Item
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
