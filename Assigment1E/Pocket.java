package Assigment1E;

/* 
#  Name:Keith Gompf       			 	
#  Date:11/11/23        	  	
#  Description:Pocket class has removing, inserting and listing items, With a new equals method that compares the items in a pocket given another 	
*/ 

//import Assigment1E.BackpackItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

	// Copy constructor
	public Pocket(Pocket pocket) {
		this.pocketName = pocket.pocketName;
		this.maxPocketWeight = pocket.maxPocketWeight;
		this.pocketItems = new ArrayList<>(pocket.pocketItems.size());
		for (BackpackItem item : pocket.pocketItems) {
			this.pocketItems.add(item);
		}
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

	//checks if the pockets are equal
	//each pocket must have same items witeh same weights
	//sorts both lists and runs through them simulataneously
	//if they dont have the same item and weight at an instance will return false and quit method
	@Override
	public boolean equals(Object obj)
	{
		boolean result = false;
		Pocket copy = (Pocket) obj;

		//case in which there is no items in pocket
		if(this.pocketItems.size() == 0 && copy.pocketItems.size() == 0) {
			result = true;
		}else {
			//comapres size instead of weight cause checking size costs less then checking weight
			if(copy.pocketItems.size() == this.pocketItems.size()) {
				Collections.sort(this.pocketItems, Comparator.comparing(item -> item.itemName));
				Collections.sort(copy.pocketItems, Comparator.comparing(item -> item.itemName));
				for(int i = 0; i < copy.pocketItems.size(); i++) {
					if(this.pocketItems.get(i).itemName.equals(copy.pocketItems.get(i).itemName) &&
							this.pocketItems.get(i).itemWeight == (copy.pocketItems.get(i).itemWeight)) {
						result = true;
					}else {
						//case in which one index is not the same, thus pockets are not equal
						return false;
					}

				}
			}
		}
		return result;
	}

	@Override
	public Object clone() {
		return new Pocket(this);
	}
}
