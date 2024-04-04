package Assugment1C;

/*
# Name:Keith Gompf
# Date:10/22/23
# Description:Refactoring of Backpack to help with efficiency. Backpack calls the
functions in Pocket
 */
public class Backpack
{
	//Constants
	final int MAIN_POCKET_MAX_WEIGHT = 10;
	final int LEFT_POCKET_MAX_WEIGHT = 5;
	final int RIGHT_POCKET_MAX_WEIGHT = 5;
	//Fields
	private Pocket mainPocket;
	private Pocket rightPocket;
	private Pocket leftPocket;
	//Constructors
	public Backpack()
	{
		Pocket mainPocket = new Pocket("mainPocket", MAIN_POCKET_MAX_WEIGHT);
		this.mainPocket = mainPocket;
		Pocket leftPocket = new Pocket("leftPocket", LEFT_POCKET_MAX_WEIGHT);
		this.leftPocket = leftPocket;
		Pocket rightPocket = new Pocket("rightPocket", RIGHT_POCKET_MAX_WEIGHT);
		this.rightPocket = rightPocket;
	}
	//Methods
	public boolean insertItemInMainPocket(String itemName, double itemWeight)
	{
		boolean result = false;
		if(mainPocket.insertItemInPocket(itemName, itemWeight) == true) {
			result = true;
		}
		return result;
	}
	public boolean insertItemInRightPocket(String itemName, double itemWeight)
	{
		boolean result = false;
		if(rightPocket.insertItemInPocket(itemName, itemWeight) == true) {
			result = true;
		}
		return result;
	}
	public boolean insertItemInLeftPocket(String itemName, double itemWeight)
	{
		boolean result = false;
		if(leftPocket.insertItemInPocket(itemName, itemWeight) == true) {
			result = true;
		}
		return result;
	}
	public boolean removeItemFromMainPocket(String itemName)
	{
		boolean result = false;
		if(mainPocket.removeItemFromPocket(itemName) == true) {
			result = true;
		}
		return result;
	}
	public boolean removeItemFromRightPocket(String itemName)
	{
		boolean result = false;
		if(rightPocket.removeItemFromPocket(itemName) == true) {
			result = true;
		}
		return result;
	}
	public boolean removeItemFromLeftPocket(String itemName)
	{
		boolean result = false;
		if(leftPocket.removeItemFromPocket(itemName) == true) {
			result = true;
		}
		return result;
	}
	public void listItemsInMainPocket()
	{//calls pocket class to list items
		mainPocket.listItemsInPocket();
	}
	public void listItemsInRightPocket()
	{
		rightPocket.listItemsInPocket();
	}
	public void listItemsInLeftPocket()
	{
		leftPocket.listItemsInPocket();
	}
	public double getMainPocketTotalWeight()
	{
		double totalWeight = mainPocket.getPocketTotalWeight();
		return totalWeight;
	}
	public double getRightPocketTotalWeight()
	{
		double totalWeight = rightPocket.getPocketTotalWeight();
		return totalWeight;
	}
	public double getLeftPocketTotalWeight()
	{
		double totalWeight = leftPocket.getPocketTotalWeight();
		return totalWeight;
	}
	public void listItemsInBackpack()
	{
		System.out.println("Listing all backpack items...\n");
		listItemsInMainPocket();
		listItemsInRightPocket();
		listItemsInLeftPocket();
	}
	public double getTotalWeight()
	{
		double totalWeight = getMainPocketTotalWeight()
				+ getRightPocketTotalWeight()
				+ getLeftPocketTotalWeight();
		return totalWeight;
	}
}