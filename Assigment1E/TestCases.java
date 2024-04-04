package Assigment1E;

public class TestCases 
{
    static boolean testCase1()
    {
        boolean testCasePassed = true;

        try
        {
            Backpack backpack1 = new Backpack();
            Backpack backpack2 = new Backpack();
            
            backpack1.insertItemInMainPocket("Fork", 2.0);
            backpack1.insertItemInMainPocket("Spoon", 1.0);
            backpack1.insertItemInMainPocket("Spoon", 1.0);

            backpack2.insertItemInMainPocket("Spoon", 1.0);
            backpack2.insertItemInMainPocket("Fork", 2.0);
            backpack2.insertItemInMainPocket("Fork", 2.0);
        
            boolean result = backpack1.equals(backpack2);

            if (result != false) testCasePassed = false;
        }
        catch (Exception ex)
        {
            testCasePassed = false;
        }

        return testCasePassed;
    }

    static boolean testCase2()
    {
        boolean testCasePassed = true;

        try
        {
            Backpack backpack1 = new Backpack();
            Backpack backpack2 = new Backpack();
            
            backpack1.insertItemInMainPocket("Fork", 2.0);
            backpack1.insertItemInMainPocket("Spoon", 1.0);
            
            backpack2.insertItemInMainPocket("Spoon", 1.0);
            backpack2.insertItemInMainPocket("Fork", 2.0);

            boolean result = backpack1.equals(backpack2);

            if (result != true) testCasePassed = false;
        }
        catch (Exception ex)
        {
            testCasePassed = false;
        }

        return testCasePassed;
    }

    static boolean testCase3()
    {
        boolean testCasePassed = true;

        try
        {
            Backpack backpack1 = new Backpack();
            Backpack backpack2 = new Backpack();
            
            backpack1.insertItemInMainPocket("Fork", 2.0);
            backpack1.insertItemInMainPocket("Spoon", 1.0);
            backpack1.insertItemInMainPocket("Cup", 1.0);
            
            backpack2.insertItemInMainPocket("Fork", 2.0);
             backpack2.insertItemInMainPocket("Spoon", 1.0);
            backpack2.insertItemInMainPocket("Cup", 1.0);

            boolean result = backpack1.equals(backpack2);

            if (result != true) testCasePassed = false;
        }
        catch (Exception ex)
        {
            testCasePassed = false;
        }

        return testCasePassed;
    }

    static boolean testCase4()
    {
        boolean testCasePassed = true;

        try
        {
            Backpack backpack1 = new Backpack();
            Backpack backpack2 = new Backpack();
            
            backpack1.insertItemInMainPocket("Sleeping bag", 2.0);
            backpack1.insertItemInMainPocket("Tent", 5.0);
            backpack1.insertItemInMainPocket("Pillow", 1.0);
            
            backpack2.insertItemInMainPocket("Sleeping bag", 2.0);
            backpack2.insertItemInMainPocket("Tent", 5.0);
            backpack2.insertItemInMainPocket("Pillow", 1.0);
            
            backpack1.insertItemInRightPocket("Cup", 0.25);
            backpack1.insertItemInRightPocket("Plate", 0.5);

            backpack2.insertItemInRightPocket("Cup", 0.25);
            backpack2.insertItemInRightPocket("Plate", 0.5);
           
            backpack1.insertItemInLeftPocket("Spoon", 0.25);
            backpack1.insertItemInLeftPocket("Fork", 0.5);
            
            backpack2.insertItemInLeftPocket("Spoon", 0.25);
            backpack2.insertItemInLeftPocket("Fork", 0.5);

            boolean result = backpack1.equals(backpack2);

            if (result != true) testCasePassed = false;
        }
        catch (Exception ex)
        {
            testCasePassed = false;
        }

        return testCasePassed;
    }

    static boolean testCase5()
    {
        boolean testCasePassed = true;

        try
        {
            boolean result = true;

            Backpack backpack1 = new Backpack();
            
            backpack1.insertItemInMainPocket("Sleeping bag", 2.0);
            backpack1.insertItemInRightPocket("Cup", 0.25);
            backpack1.insertItemInLeftPocket("Spoon", 0.25);
           
            Backpack backpack2 = (Backpack)backpack1.clone();
            result = backpack2.equals(backpack1);

            if (result != true) testCasePassed = false;
        }
        catch (Exception ex)
        {
            testCasePassed = false;
        }

        return testCasePassed;
    }

    static boolean testCase6()
    {
        boolean testCasePassed = true;

        try
        {
            boolean result = true;

            Backpack backpack1 = new Backpack();
            
            backpack1.insertItemInMainPocket("Sleeping bag", 2.0);
            backpack1.insertItemInRightPocket("Cup", 0.25);
            backpack1.insertItemInLeftPocket("Spoon", 0.25);
           
            Backpack backpack2 = (Backpack)backpack1.clone();
            result = backpack1.equals(backpack2);

            if (result != true) testCasePassed = false;
        }
        catch (Exception ex)
        {
            testCasePassed = false;
        }

        return testCasePassed;
    }
    
    static boolean testCase7()
    {
        boolean testCasePassed = true;

        try
        {
            boolean result = true;

            Backpack backpack1 = new Backpack();
            Backpack backpack2 = new Backpack();
            
            backpack1.insertItemInMainPocket("Sleeping bag", 2.0);
            backpack2.insertItemInMainPocket("Sleeping bag", 2.0);
            
            backpack1.insertItemInRightPocket("Cup", 0.25);
            backpack2.insertItemInRightPocket("Cup", 0.25);
            
            backpack1.insertItemInLeftPocket("Spoon", 0.25);
            backpack2.insertItemInLeftPocket("Spoon", 0.25);

            Backpack backpack3 = (Backpack)backpack1.clone();
            result = backpack3.equals(backpack1);

            if (result != true) testCasePassed = false;

            result = backpack3.equals(backpack2);

            if (result != true) testCasePassed = false;
        }
        catch (Exception ex)
        {
            testCasePassed = false;
        }

        return testCasePassed;
    }

    static boolean testCase8()
    {
        boolean testCasePassed = true;

        try
        {
            boolean result = true;

            Backpack backpack1 = new Backpack();
            
            backpack1.insertItemInMainPocket("Sleeping bag", 2.0);
            backpack1.insertItemInRightPocket("Cup", 0.25);
            backpack1.insertItemInLeftPocket("Spoon", 0.25);
            
            Backpack backpack2 = new Backpack(backpack1);
            result = backpack2.equals(backpack1);
            
            if (result != true) testCasePassed = false;
        }
        catch (Exception ex)
        {
            testCasePassed = false;
        }

        return testCasePassed;
    }
}
