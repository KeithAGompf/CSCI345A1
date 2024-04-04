package Assigment1E;

/* 
#  Name:Keith Gompf       			 	
#  Date: 11/11/23        	  	
#  Description:Stores Backpack items with names and weights and has new equals method to compare those items 	
*/ 
public class BackpackItem 
{
	//fields
    public String itemName;
    public double itemWeight;
    
    //stores itemName and ItemWeight
    public BackpackItem(String itemName, double itemWeight)
    {
        this.itemName = itemName;
        this.itemWeight = itemWeight;
    }
    
    //Compares items in the backpack
    @Override
    public boolean equals(Object other)
	{
		if (this == other) return true;
		
		boolean result = false;

		if (other != null && (this.getClass() == other.getClass()))
		{
			BackpackItem backpackItem = (BackpackItem)other;

			result = this.itemName.equals(backpackItem.itemName) 
                && this.itemWeight == backpackItem.itemWeight;
		}
		return result;
	}
}
