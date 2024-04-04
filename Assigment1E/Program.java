package Assigment1E;

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
		
        System.out.println("Testing Backpack application...\n");

        try
        {
            boolean result = false;

            result = TestCases.testCase1();
            System.out.println("Test case1 passed: " + result);

            result = TestCases.testCase2();
            System.out.println("Test case2 passed: " + result);

            result = TestCases.testCase3();
            System.out.println("Test case3 passed: " + result);

            result = TestCases.testCase4();
            System.out.println("Test case4 passed: " + result);

            result = TestCases.testCase5();
            System.out.println("Test case5 passed: " + result);

            result = TestCases.testCase6();
            System.out.println("Test case6 passed: " + result);

            result = TestCases.testCase7();
            System.out.println("Test case7 passed: " + result);

            result = TestCases.testCase8();
            System.out.println("Test case8 passed: " + result);

            System.out.println();
        }
        catch (Exception ex)
        {
            String exceptionMessage = ex.getMessage();
            
            System.out.println(exceptionMessage);
        }

        keyboard.close();
    }

    
}


