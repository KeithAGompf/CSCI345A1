package Assugment1C;

import java.util.ArrayList;
public class Pocket
{
	//Fields
	private String pocketName;
	private int maxPocketWeight;
	ArrayList<BackpackItem> pocketItems = new ArrayList<BackpackItem>();
	//Constructors
	public Pocket(String pocketName, int maxPocketWeight)
	{
		this.pocketName = pocketName;
		this.maxPocketWeight = maxPocketWeight;
	}
	//Methods
	public boolean insertItemInPocket(String itemName, double itemWeight)
	{
		boolean result = false;
		//checks if item is smaller than max weight and if it is not negative
		if(getPocketTotalWeight() < maxPocketWeight && itemWeight > 0) {
			BackpackItem item = new BackpackItem(itemName, itemWeight);
			pocketItems.add(item);
			result = true;
		}else if(getPocketTotalWeight() > maxPocketWeight) {
			//overflow case item puts max weight over and needs to be removed
			removeItemFromPocket(itemName);
			result = false;
		}
		return result;
	}
	public boolean removeItemFromPocket(String itemName)
	//searches from front of list to remove item
	{
		boolean result = false;
		for(int i = 0; i< pocketItems.size(); i++) {
			if(pocketItems.get(i).itemName == itemName) {
				pocketItems.remove(i);
				result = true;
			}
		}
		return result;
	}
	public double getPocketTotalWeight()
	{
		double totalWeight = 0;
		for(int i = 0; i <pocketItems.size(); i++) {
			totalWeight += pocketItems.get(i).itemWeight;
		}
		return totalWeight;
	}
	public void listItemsInPocket()
	{
		System.out.println("Listing " + pocketName + " Pocket Items..." );
		for(int i = 0; i < pocketItems.size(); i++) {
			System.out.println(pocketItems.get(i).itemName + " Weight:" +
					pocketItems.get(i).itemWeight);
		}
	}
}