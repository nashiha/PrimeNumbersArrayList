import java.util.*;
/*--------------------------------------------------
 * Lab 01: IntBag: allows a variable sized collection of non-negative integer values to be stored
 * @author: Nashiha Ahmed
 * @version: 2; 17/ 02/ 15
 */

public class IntBag
{
    //constants 
    private final int SENTINEL = -27;
    
    //properties
    private int[] bag;
    
    //constructors
    //constructor1
    public IntBag()
    {
        bag = new int[ 101];
        bag[ 0] = -27;
    }
    
    //constructor2
    public IntBag( int maxValues)
    {
        bag = new int[ maxValues + 1];
        bag[ 0] = -27;
    }
    
    //methods
    //add method: Adds given value at the end of valid part of the array
    public void add( int value)
    {
        //1. Add if there is space and if value is positive
        if( size() < bag.length && value > 0)
        {
            int i;
            i = size();
            bag[ i + 1] = SENTINEL; //Moves Sentinel after the end of *valid* values
            bag[ i] = value; //Adds given value at the end of *valid* values
        }
        
        
        //2. Give error message, if there is no space
        else if( size() >= bag.length)
        {
            System.out.println( "There is no space to add value. Sorry!");
        }
        
        //3. Give error message, if given value is negative
        else if( value < 0)
        {
            System.out.println( "Negative values cannot be added.");
        }
    }
    
    //add Method: Adds given value at the given index
    public void add( int value, int index)
    {
        //1. Add at index if there is space and if index and value are valid numbers 
        //1.1 Move all the values up one starting from the SENTINEL to the index
        if( size() < bag.length && value >= 0 && index >= 0)
        {
            for( int i = (size() + 1); i > index; i--)
            {
                bag[ i ] = bag[ i - 1];
            }
            //1.2 Put desired value at index     
            bag[ index] = value;
            
        }
        
        //2. Giver error messages, if...
        //2.1 There is no space
        else if( size() >= bag.length)
        {
            System.out.println( "There is no space to add value. Sorry!");
        }
        //2.2 Value is negative
        else if( value < 0)
        {
            System.out.println( "Negative values cannot be added.");
        }
        //2.3 Index is negative
        else if( index < 0)
        {
            System.out.println( "Input index is invalid.");
        }
    }
    
    //Contains method: checks if given value is in array and returns true/false
    public boolean contains( int value)
    {
        for( int i = 0; i < size(); i++)
        {
            if( bag[i] == value)
            {
                return true;
            }
        }
        return false;
    }
    
    //remove method: removes the value at the given index
    public void remove( int index)
    {
        //1.1 Move all the values down one starting from the SENTINEL to the index
        if( size() > 0 && index >= 0)
        {
            for( int i = index; i < size(); i++)
            {
                bag[ i ] = bag[ i + 1];
            }
        }
        
        //2. Giver error messages, if...
        //2.1 There is no space
        else if( size() <= 0)
        {
            System.out.println( "List is empty. Cannot remove.");
        }
        //2.2 Index is negative
        else if( index < 0)
        {
            System.out.println( "Input index is invalid.");
        }
    }
    
    //Size method: gets size of array
    public int size()
    {
        int size;
        size = 0;
        for( int i = 0; i < bag.length; i++)
        {
            if( bag[i] == SENTINEL)
            {
                return size;
            }
            size++;
        }
        return size;
    }
    
    //toString method: prints array
    public String toString()
    {
        String print;
        print = "";
        print = "List: " + "[ ";
        for( int i = 0; i < size(); i++)
        {
            if( i < (size() - 1))
            {
               print = print + bag[i] + ", ";
            }
            else
                print = print + bag[i];
        }
        print = print + "]";
        return print;
    }
    
    //Get method: gets value at given index
    public int get( int index)
    {
        int number;
        number = bag[ index];
        return number;
    }
    
    //findAll method: returns the locations (indexes) of all instances of a given value in the collection.
    public ArrayList<Integer> findAll( int value)
    {
        int index;
        index = 0;
        ArrayList<Integer> list;
        list = new ArrayList<Integer>();
        for( int i = 0; i < size(); i ++)
        {
            if( bag[ i] == value)
            {
                list.add( i);
            }
        }
        return list;
    }
    //end of code
}
//end of IntBag