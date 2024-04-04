package Assigment1E;

//import Assigment1E.Pocket;
/* 
#  Name:Keith Gompf   			 	
#  Date:11/11/23  	
#  Description:Refactoring of backpack which includes cloning and comparing pockets with new equals methods
*/ 
import java.util.Iterator;

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
	//creates a copy of the backpack
	public Backpack(Backpack original) {
        this.mainPocket = new Pocket(original.mainPocket);
        this.rightPocket = new Pocket(original.rightPocket);
        this.leftPocket = new Pocket(original.leftPocket);
    }
	
	//creates all of the pockets that are in the backpack
	public Backpack(int mainPocketMaxWeight, int rightPocketMaxWeight, int leftPocketMaxWeight)
	{
		mainPocket = new Pocket("mainPocket", mainPocketMaxWeight);
		rightPocket = new Pocket("rightPocket", rightPocketMaxWeight);
		leftPocket = new Pocket("leftPocket", leftPocketMaxWeight);
	}

	//Methods
	//inserts items in main pocket
	public void insertItemInMainPocket(String itemName, double itemWeight) throws Exception
	{
		mainPocket.insertItemInPocket(itemName, itemWeight);
	}
	//inserts items in right pocket
	public void insertItemInRightPocket(String itemName, double itemWeight) throws Exception
	{
		rightPocket.insertItemInPocket(itemName, itemWeight);
	}
	//inserts items in left pocket
	public void insertItemInLeftPocket(String itemName, double itemWeight) throws Exception
	{
		leftPocket.insertItemInPocket(itemName, itemWeight);
	}
	//removes items from main pocket
	public void removeItemFromMainPocket(String itemName) throws Exception
	{
		mainPocket.removeItemFromPocket(itemName);
	}
	//removes items from right pocket
	public void removeItemFromRightPocket(String itemName) throws Exception
	{
		rightPocket.removeItemFromPocket(itemName);
	}
	//removes items from left pocket
	public void removeItemFromLeftPocket(String itemName) throws Exception
	{
		leftPocket.removeItemFromPocket(itemName);
	}
	//list items in main pocket
	public void listItemsInMainPocket()
	{
		mainPocket.listItemsInPocket();
	}
	//list items in right pocket
	public void listItemsInRightPocket()
	{
		rightPocket.listItemsInPocket();
	}
	//list items in left pocket
	public void listItemsInLeftPocket()
	{
		leftPocket.listItemsInPocket();
	}
	//gets main pockets weight
	public double getMainPocketTotalWeight()
	{
		double totalWeight = 0;
		totalWeight += mainPocket.getPocketTotalWeight();
		return totalWeight;
	}
	
	//gets right pocket weight
	public double getRightPocketTotalWeight()
	{
		double totalWeight = 0;
		totalWeight += rightPocket.getPocketTotalWeight();
		return totalWeight;
	}
	
	//gets left pocket weight
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
		return this;
	}

	//calls equals on each pocket and if all are equal then true
	//pocket class needs to be implemented first
	//has booleans that all need to be true to varify if the pockets are the same
	@Override
	public boolean equals(Object other)
	{

		boolean result = false;
		Backpack otherBackpack = (Backpack) other;
		boolean mainPocketEquals = this.mainPocket.equals(otherBackpack.mainPocket);
	    boolean rightPocketEquals = this.rightPocket.equals(otherBackpack.rightPocket);
	    boolean leftPocketEquals = this.leftPocket.equals(otherBackpack.leftPocket);
	    //System.out.println("main "+mainPocketEquals);
	    //System.out.println("right "+rightPocketEquals);
	    //System.out.println("left "+leftPocketEquals);
	    if(mainPocketEquals == true && rightPocketEquals == true && leftPocketEquals) {
	    	result = true;
	    }
		
		return result;
	}

	//calls clone for each pocket to then build into a backpack
	@Override
    public Object clone() {
        return new Backpack(this); // Use the copy constructor
    }
}
