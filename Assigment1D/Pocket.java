package Assigment1D;
/* 
#  Name:Keith Gompf			 	
#  Date:11/3/2023        	  	
#  Description: Pocket class has an arraylist which has the name and weight that are in BackpackItem
#  has methods to insert,remove, get weight, and list items inside a pocket	
 */ 
import java.util.ArrayList;
import java.util.Iterator;


public class Pocket implements Iterable<BackpackItem>
{
	//Fields
	private String pocketName;
	private int maxPocketWeight;
	private ArrayList<BackpackItem> pocketItems;

	//Constructors
	public Pocket(String pocketName, int maxPocketWeight)
	{
		this.pocketName = pocketName;
		this.maxPocketWeight = maxPocketWeight;
		this.pocketItems = new ArrayList<BackpackItem>();
	}
	public String getPocketName() {
	    return pocketName;
	}

	//Methods
	//Inserts items
	//if negative, or the item is too heavy an error will be thrown
	public void insertItemInPocket(String itemName, double itemWeight) throws Exception
	{
		try {
			String negativeMessage = "Invalid Weight Exception. Item name: "+ itemName + " Item Weight: " + itemWeight;
			if(itemWeight < 0) {//if value is negative
				throw new Exception(negativeMessage, new Throwable(negativeMessage));
			}

			BackpackItem item = new BackpackItem(itemName, itemWeight);
			//System.out.println(itemName + " has been inserted");
			pocketItems.add(item);

			if(getPocketTotalWeight() > maxPocketWeight) {
				removeItemFromPocket(itemName);
				String overFillMessage = "Weight Exceeded Exception. Currrent pocket weight: " + getPocketTotalWeight()+ ". Maximum pocket weight: "+ maxPocketWeight + " Item Name:"
						+ itemName + " Item weight: "+ itemWeight;
				throw new Exception(overFillMessage, new Throwable(overFillMessage));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}


	//removes item from pocket based on itemName
	//if item does not exist, an exception will be thrown
	public void removeItemFromPocket(String itemName) throws Exception
	{
		boolean removalpossible = false;
		try {
			for(int i = 0; i< pocketItems.size(); i++) {
				if(pocketItems.get(i).itemName == itemName) {
					removalpossible = true;
					//System.out.println(itemName + " has been removed");
					pocketItems.remove(i);
				}
			}
			if(removalpossible == false) {
				throw new Exception("Item not found Exception. ItemName: "+itemName, new Throwable("Remove"));
			}
		}catch(Exception remove) {
			System.out.println(remove.getMessage());
		}
	}
	
	//gets total weight of the specific pocket
	public double getPocketTotalWeight()
	{
		double totalWeight = 0;
		Iterator<BackpackItem> pocketWeight = pocketItems.iterator();
		for(int i = 0; i< pocketItems.size(); i++) {
			totalWeight += pocketWeight.next().itemWeight;
		}


		return totalWeight;
	}
	
	//list all items inside the specific pocket
	public void listItemsInPocket()
	{
		System.out.println("Listing " + pocketName + " Pocket Items..." );
		Iterator<BackpackItem> lister = pocketItems.iterator();
		while(lister.hasNext()){
			System.out.println(lister.next().itemName);
			lister.remove();
		}


	}

	public Iterator<BackpackItem> iterator() 
	{
		return pocketItems.iterator();
	}
}








