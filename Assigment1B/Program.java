package Assigment1B;

/* 
#  Name:       			 	
#  Date:        	  	
#  Description: 	
*/ 

import java.util.Scanner; 

public class Program
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
		
        System.out.println("Running the Backpack application...\n");

        Backpack backpack = new Backpack();

        boolean result = backpack.insertItemInMainPocket("Sleeping bag", 2.0);

        if (result == true)
        {
        	System.out.println("Item inserted in main pocket...");
        }
        else
        {
        	System.out.println("Item could not be inserted in main pocket...");
        }
        
        result = backpack.insertItemInMainPocket("Tent", 5.0);

        if (result == true)
        {
        	System.out.println("Item inserted in main pocket...");
        }
        else
        {
        	System.out.println("Item could not be inserted in main pocket...");
        }
        
        double pocketWeight = backpack.getMainPocketTotalWeight();
        
        System.out.println("Main Pocket weight: " + pocketWeight);
  		
        backpack.listItemsInMainPocket();
        
        System.out.println();
        
        result = backpack.insertItemInRightPocket("Cup", 0.25);

        if (result == true)
        {
        	System.out.println("Item inserted in right pocket...");
        }
        else
        {
        	System.out.println("Item could not be inserted in right pocket...");
        }

        pocketWeight = backpack.getRightPocketTotalWeight();
        
        System.out.println("Right Pocket weight: " + pocketWeight);
  		
        backpack.listItemsInRightPocket();
        
        System.out.println();
        
        result = backpack.insertItemInLeftPocket("Compass", 0.1);

        if (result == true)
        {
        	System.out.println("Item inserted in left pocket...");
        }
        else
        {
        	System.out.println("Item could not be inserted in left pocket...");
        }

        pocketWeight = backpack.getLeftPocketTotalWeight();
        
        System.out.println("Left Pocket weight: " + pocketWeight);
  		
        backpack.listItemsInLeftPocket();
        
        System.out.println();
        
        double backPackTotalWeight = backpack.getTotalWeight();
        
        System.out.println("Backpack total weight: " + backPackTotalWeight);
  		
        System.out.println();
        
        result = backpack.removeItemFromMainPocket("Sleeping bag");

        if (result == true)
        {
        	System.out.println("Item removed from main pocket...");
        }
        else
        {
        	System.out.println("Item could not be removed from main pocket...");
        }
        
        backpack.listItemsInMainPocket();
        
        System.out.println();
        
        backPackTotalWeight = backpack.getTotalWeight();
        
        System.out.println("Backpack total weight: " + backPackTotalWeight);
  		
        System.out.println();
        
        backpack.listItemsInBackpack();
        
  		keyboard.close();
    }
}


