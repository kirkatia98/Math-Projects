import java.util.ArrayList;
public class Collatz
{
    private static int [] order;
    public static void main( String [] args)
    {
        int maxSteps = 0;
        int magicNum = 0 ;
        order = new int[(int)Math.pow(10,8)];
        order[1] = 0;
        for(int i = 1; i<= Math.pow(10,6); i++)
        {
            int steps = collatz(i); 
            if(steps > maxSteps)
            {
                maxSteps = steps; magicNum = i;
                System.out.println(magicNum + " "+ maxSteps);
            }
        }
        System.out.println(magicNum + " "+ maxSteps);
    }
    public static int collatz( int n )
    {
        if( order[n] > 0 )
        {
            return order[n];
        }
        if(n == 1)
        {
            return 0; 
        }
        else if( n %2 == 0)
        {
            n/= 2;
        }
        else
        {
            n*= 3;
            n+= 1;
        }
        int previous = collatz(n);
        order[n] = previous;
        return previous + 1;
    }
}