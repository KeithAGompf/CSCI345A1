package Assigment1B;
import java.util.ArrayList;

/* 
#  Name:Keith Gompf       			 	
#  Date:10/11/23        	  	
#  Description:Refactoring of Backpack to help with efficiency
	This program uses arraylists with names to represent a backpack better and with more methods to clean
	things up.
 */ 

public class Backpack
{
	//Constants
	final int MAIN_POCKET_MAX_WEIGHT = 10;
	final int LEFT_POCKET_MAX_WEIGHT = 5;
	final int RIGHT_POCKET_MAX_WEIGHT = 5;

	//Fields (Data members)
	ArrayList<String> mainPocketItems = new ArrayList<String>();
	ArrayList<Double> mainPocketItemWeights = new ArrayList<Double>();

	ArrayList<String> rightPocketItems = new ArrayList<String>();
	ArrayList<Double> rightPocketItemWeights = new ArrayList<Double>();

	ArrayList<String> leftPocketItems = new ArrayList<String>();
	ArrayList<Double> leftPocketItemWeights = new ArrayList<Double>();

	//Methods
	//checks for negative weights which should never be entered
	//if a item is inserted and goes over max weight it will be removed
	private boolean insertItemInPocket(ArrayList<String> pocketItems, ArrayList<Double>pocketItemWeights, String ItemName, double itemWeight, int pocketMaxWeight) {
		if(getPocketTotalWeight(pocketItemWeights)<pocketMaxWeight && itemWeight > 0)  {
			pocketItems.add(ItemName);
			pocketItemWeights.add(itemWeight);
		}
		if(getPocketTotalWeight(pocketItemWeights) > pocketMaxWeight) {
			removeItemFromPocket(pocketItems,pocketItemWeights, ItemName);
			return false;

		}
		return true;
	}
	public boolean insertItemInMainPocket(String itemName, double itemWeight)   
	{
		boolean result = false;
		if(insertItemInPocket(mainPocketItems, mainPocketItemWeights, itemName, itemWeight, MAIN_POCKET_MAX_WEIGHT)== true) {
			result = true;
		}


		return result;
	}

	public boolean insertItemInRightPocket(String itemName, double itemWeight)
	{
		boolean result = false;
		if(insertItemInPocket(rightPocketItems, rightPocketItemWeights, itemName, itemWeight, RIGHT_POCKET_MAX_WEIGHT)== true) {
			result = true;
		}
		return result;
	}
	public boolean insertItemInLeftPocket(String itemName, double itemWeight)
	{
		boolean result = false;
		if(insertItemInPocket(leftPocketItems, leftPocketItemWeights, itemName, itemWeight, LEFT_POCKET_MAX_WEIGHT)== true) {
			result = true;
		}
		return result;
	}
	//searches if an item exists from the front of the list
	//will reutrn false if item can not be found in list, will not remove anything in that case
	private boolean removeItemFromPocket(ArrayList<String> pocketItems, ArrayList<Double>pocketItemWeights, String itemName) {
		for(int i = 0; i < pocketItems.size(); i++) {
			if(pocketItems.get(i) == itemName) {
				pocketItems.remove(i);
				pocketItemWeights.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean removeItemFromMainPocket(String itemName)
	{
		boolean result = false;
		if (removeItemFromPocket(mainPocketItems, mainPocketItemWeights, itemName) == true){
			result = true;
		}
		return result;
	}

	public boolean removeItemFromRightPocket(String itemName)
	{
		boolean result = false;
		if(removeItemFromPocket(rightPocketItems, rightPocketItemWeights, itemName) == true) {
			result = true;
		}
		return result;
	}

	public boolean removeItemFromLeftPocket(String itemName)
	{
		boolean result = false;
		if(removeItemFromPocket(leftPocketItems, leftPocketItemWeights, itemName)== true) {
			result = true;
		}
		return result;
	}
	//has case if there is no items in pocket. Otherwise will list all items from when they were first put in.
	private void listItemsInPocket(ArrayList<String> pocketItems, ArrayList<Double>pocketItemWeights, String pocketName) {
		if(pocketItems.size()==0) {
			System.out.println("There is no items in " + pocketName);
		}else{
			System.out.println("items in " + pocketName + ":");
			for(int i = 0;i < pocketItems.size(); i++) {
				System.out.println(pocketItems.get(i) + ", Weight:" +  pocketItemWeights.get(i));
			}
		}
	}

	public void listItemsInMainPocket()
	{
		listItemsInPocket(mainPocketItems, mainPocketItemWeights, "MainPocket");

	}

	public void listItemsInRightPocket()
	{
		listItemsInPocket(rightPocketItems, rightPocketItemWeights, "RightPocket");
	}

	public void listItemsInLeftPocket()
	{
		listItemsInPocket(leftPocketItems, leftPocketItemWeights, "LeftPocket");

	}
	public void listItemsInBackpack()
	{
		System.out.println("Listing all backpack items...\n");
		listItemsInLeftPocket();
		listItemsInRightPocket();
		listItemsInMainPocket();

	}

	private double getPocketTotalWeight(ArrayList<Double>pocketWeights) {
		double totalWeight = 0;
		for(int i = 0; i< pocketWeights.size();i++) {
			totalWeight += pocketWeights.get(i);
		}
		return totalWeight;

	}

	public double getMainPocketTotalWeight()
	{
		return getPocketTotalWeight(mainPocketItemWeights);
	}

	public double getRightPocketTotalWeight()
	{
		return getPocketTotalWeight(rightPocketItemWeights);
	}

	public double getLeftPocketTotalWeight()
	{
		return getPocketTotalWeight(leftPocketItemWeights);
	}



	public double getTotalWeight()
	{
		double totalWeight = 0.0;
		totalWeight  += (getLeftPocketTotalWeight() + getRightPocketTotalWeight() + getMainPocketTotalWeight());

		return totalWeight;
	}

}





