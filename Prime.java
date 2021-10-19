/*--------------------------------------------------
 * Lab 01: PrimeNumbers: allows a variable sized collection of non-negative integer values to be stored
 * @author: Nashiha Ahmed
 * @version: 1; 15/ 02/ 15
 *--------------------------------------------------
 */
public class Prime
{
    //constants
    private static final int MAX = 100;
    //isPrime boolean Method to check if number is prime
    public static boolean isPrime( int input, IntBag prime)
    {
        for( int i = 0; i < prime.size(); i++)
        {
            if( input % prime.get( i) == 0  )
            {
                return false;
            }
        }
        return true;
    }
    
    public static void main( String[] args) 
    {
        //variables
        IntBag prime;
        int k;
        
        //code
        //1. Create prime array
        prime = new IntBag( MAX);
        
        //2. Add 2 to the array as first prime number
        prime.add( 2);
        
        //3. Find first 100 prime numbers using isPrime method
        for( k = 3; prime.size() < MAX; k++)
        {
            if( isPrime( k, prime))
                prime.add( k);
        }
        
        //4. Print array
        System.out.println( "The first 100 prime numbers are: " +prime.toString());
    }
}
