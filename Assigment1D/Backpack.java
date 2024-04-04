package Assigment1D;
/* 
#  Name:Keith Gompf   			 	
#  Date:11/3/2023        	  	
#  Description: Backpack class calls the pocket class and implements the iterator
#  has an iterator implemented to go through each arraylist and then list all items in the backpack	
 */ 

import java.util.Iterator;
import java.util.List;

class Backpack implements Iterable<Pocket>, Iterator<Pocket> 
{
	//Constants
	private final static int MAIN_POCKET_MAX_WEIGHT = 10;
	private final static int LEFT_POCKET_MAX_WEIGHT = 5;
	private final static int RIGHT_POCKET_MAX_WEIGHT = 5;

	private final int POCKET_QUANTITY = 3;

	//Fields
	private Pocket mainPocket;
	private Pocket rightPocket;
	private Pocket leftPocket;
	
	//keeps track of which pocket is iterating through
	private int currentIteratingPocket = 0;

	//Constructors
	public Backpack()
	{
		this(MAIN_POCKET_MAX_WEIGHT, RIGHT_POCKET_MAX_WEIGHT, LEFT_POCKET_MAX_WEIGHT); 
	}
	//creates all of the pockets that are in the backpack
	public Backpack(int mainPocketMaxWeight, int rightPocketMaxWeight, int leftPocketMaxWeight)
	{
		mainPocket = new Pocket("mainPocket", mainPocketMaxWeight);
		rightPocket = new Pocket("rightPocket", rightPocketMaxWeight);
		leftPocket = new Pocket("leftPocket", leftPocketMaxWeight);
	}

	//Methods
	public void insertItemInMainPocket(String itemName, double itemWeight) throws Exception
	{
		mainPocket.insertItemInPocket(itemName, itemWeight);
	}

	public void insertItemInRightPocket(String itemName, double itemWeight) throws Exception
	{
		rightPocket.insertItemInPocket(itemName, itemWeight);
	}

	public void insertItemInLeftPocket(String itemName, double itemWeight) throws Exception
	{
		leftPocket.insertItemInPocket(itemName, itemWeight);
	}

	public void removeItemFromMainPocket(String itemName) throws Exception
	{
		mainPocket.removeItemFromPocket(itemName);
	}

	public void removeItemFromRightPocket(String itemName) throws Exception
	{
		rightPocket.removeItemFromPocket(itemName);
	}

	public void removeItemFromLeftPocket(String itemName) throws Exception
	{
		leftPocket.removeItemFromPocket(itemName);
	}

	public void listItemsInMainPocket()
	{
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
		double totalWeight = 0;
		totalWeight += mainPocket.getPocketTotalWeight();
		return totalWeight;
	}

	public double getRightPocketTotalWeight()
	{
		double totalWeight = 0;
		totalWeight += rightPocket.getPocketTotalWeight();
		return totalWeight;
	}

	public double getLeftPocketTotalWeight()
	{
		double totalWeight = 0;
		totalWeight += leftPocket.getPocketTotalWeight();
		return totalWeight;
	}
	//calls and lists what is inside each pocket
	public void listItemsInBackpack() {
	    System.out.println("Listing all backpack items...\n");
	    int iteration = 0;
	    String[] pocketNames = { "mainPocket", "rightPocket", "leftPocket" };

	    for (Pocket pocket : this) {
	        String pocketName = pocketNames[iteration % 3];
	        System.out.println("Items in " + pocketName + ":");
	        pocket.listItemsInPocket();
	        iteration++;
	    }
	}

	//calls each pockets weight and adds up their total for the backpacks total weight
	public double getTotalWeight()
	{
		double totalWeight = getMainPocketTotalWeight()
				+ getRightPocketTotalWeight()
				+ getLeftPocketTotalWeight();
		return totalWeight;
	}
	//iterator methods
	public boolean hasNext() 
	{
		return currentIteratingPocket < POCKET_QUANTITY;
	}
	//used for iteratoring through pockets
	public Pocket next() {
        if (!hasNext()) {
            throw new UnsupportedOperationException("No more pockets to iterate.");
        }

        Pocket nextPocket;
        switch (currentIteratingPocket) {
            case 0:
                nextPocket = mainPocket;
                break;
            case 1:
                nextPocket = rightPocket;
                break;
            case 2:
                nextPocket = leftPocket;
                break;
            default:
                throw new UnsupportedOperationException("Invalid pocket index.");
        }

        currentIteratingPocket++;
        return nextPocket;
    }

	public Iterator<Pocket> iterator() 
	{
		currentIteratingPocket = 0;
		// TODO Auto-generated method stub
		return this;
	}


}





