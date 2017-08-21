

import java.util.ArrayList;
public class Prime
{
    public static void main (String[] args)
    {
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        long sum = 2;
        System.out.println();
        for(int i = 3; i<1000; i++)
        {   boolean prime = true;
            int stop = (int)Math.sqrt(i);
            int pr = 0;
            while( prime && pr<stop)
            {
                if(i % primes.get(pr) == 0)
              { prime = false;
              }
              pr++;
            }
            if(prime) // if indivisible by every preceding prime
            {primes.add(i);
             //sum+= i;
            }
            if( i < 0)
            {System.out.print(i);
            break;}
        }
        //System.out.println(primes);
        System.out.println(primes.get(primes.size()-1));
        
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime/1000.0);
    } 
}
