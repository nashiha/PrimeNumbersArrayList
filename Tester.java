import java.util.*;
/*
 * Tester class- program that presents the user with a menu having the following options 
 * @author: Nashiha Ahmed
 * @version: 1/ 17.2.15
 */

public class Tester
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        //variables
        int userOption;
        IntBag newArray;
        int capacity;
        int value;
        int index;
        int testValue; 
        ArrayList<Integer> locations;
        
        //code
        //Initialization of variables
        userOption = 0;
        newArray = new IntBag(0);
        locations = new ArrayList<Integer>();
        testValue = 0;
        capacity = 0;
        
        //1.Print welcome message
        System.out.println( "Welcome to the number play program!");
        System.out.println();
        do
        {
            //2. Present User with menu until exit is chosen
            System.out.println();
            System.out.println( "Here's a menu of things you can do!");
            System.out.println( "1. Create a new empty collection with a specified maximum capacity" + 
                               "(any previous values are lost!)");
            System.out.println( "2. Read a set of positive values into the collection" +
                               "(use zero to indicate all the values have been entered.)");
            
            System.out.println( "3. Print the collection of values.");
            System.out.println( "4. Add a value to the collection of values at a specified location.");
            System.out.println( "5. Remove the value at a specified location from the collection of values");
            System.out.println( "6. Read a single test value.");
            System.out.println( "7. Compute the set of locations of the test value within the collection.");
            System.out.println( "8. Print the set of locations.");
            System.out.println( "9. Quit the program.");
            System.out.println();
            System.out.println( "Please enter the number to choose an option:");
            userOption = scan.nextInt();
            System.out.println();
            
            //2.1 Option 1: Creates an empty collection
            if( userOption == 1 )
            {
                System.out.println( "Please enter maximum capacity of the collection");
                capacity = scan.nextInt();
                if( capacity > 0)
                {
                    newArray = new IntBag( capacity);
                }
                else
                {
                    System.out.println( "Collection cannot be created with given capacity value.");
                }
            }
            
            //2.2 Option 2: Asks for values to fill collection
            else if( userOption == 2 )
            {
                System.out.println( "Please enter a set of positive values. 0 to stop.");
                do
                {
                    value = scan.nextInt();
                    if( value != 0 && newArray.size() < capacity)
                    {
                        newArray.add( value);
                    }
                    else if( newArray.size() > 10)
                    {
                        System.out.println( "Limit exceeded.");
                    }
                }while( value != 0 && newArray.size() < capacity); 
                System.out.println( "List is filled.");
            }
            
            //2.3 Option 3: Prints collection
            else if( userOption == 3 )
            {
                System.out.println( newArray.toString());
            }
            
            //2.4: Option 4: Adds input value at input index
            else if( userOption == 4 )
            {
                if ( newArray.size() < capacity)
                {
                    System.out.println( "Please enter positive value that is not 0 to be added to the array");
                    value = scan.nextInt();
                    System.out.println( "Please enter index at which value will be added");
                    index = scan.nextInt();
                    if( value > 0 && index < newArray.size())
                    {
                    newArray.add( value, index);
                    }
                    else 
                        System.out.println( "Invalid index or value. Please re-enter.");
                }
                else
                    System.out.println( "List is full.");
            }
            
            //2.5: Option 5: Removes the value at input index
            else if( userOption == 5 )
            {
                if( newArray.size() > 0)
                {
                    System.out.println( "Please enter index at which value will be removed");
                    index = scan.nextInt();
                    newArray.remove( index);
                }
                else
                    System.out.println( "List is empty. Cannot remove.");
            }
            
            //2.6: Option 6: Asks for test value
            else if( userOption == 6 )
            {
                System.out.println( "Please enter test value");
                testValue = scan.nextInt();
            }
            
            //2.7: Option 7: Computes set of locations with test value
            else if( userOption == 7 )
            {
                locations = newArray.findAll( testValue); 
            }
            
            //2.8: Prints locations
            else if( userOption == 8 )
            {
                System.out.println( "List of locations: ");
                for( int i = 0; i < locations.size(); i++)
                {
                    if( (i < locations.size() - 1))
                    {
                        System.out.print( locations.get(i) + ", ");
                    }
                    else
                        System.out.print( locations.get(i));
                }
            }
            
            //2.9: If options 2, 3, 4, 5, 6, 7, 8 are chosen without creating array, error message given
            else if( userOption == 2 || userOption ==  3 ||
                    userOption == 4 || userOption ==  5 ||
                    userOption == 6 || userOption == 7 ||
                    userOption == 8 && newArray.size() <= 0)
                System.out.println( "Array has not been created");
            
        }while( userOption != 9);
        //3: Exits if 9 is chosen
        if( userOption == 9)
        {
            System.out.println( "Bye!");
        }
    }
    //end of code
}
//end of Tester class
