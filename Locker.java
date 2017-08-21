import java.util.ArrayList;
public class Locker
{
    static ArrayList<Integer> primes;
    static ArrayList<Integer> safes;
    static int cur;
    public static void main( String [] args )
    {
      long startTime = System.currentTimeMillis();
      primes = new ArrayList<Integer>();
      primes.add(2);
      primes.add(3);
      System.out.println();
      System.out.println();
      System.out.println();
      int pr = 0;
      for(int i = 5; primes.size() < 20 ; i+=2)
      {     boolean prime = true;
            int stop = (int)Math.sqrt(i);
            //int pr = 0;
            while( prime && pr<stop)
            {
                if(i % primes.get(pr) == 0)
              { prime = false;
              }
              pr++;
            }
            if(prime) // if indivisible by every preceding prime
            {primes.add(i);
             //if( (i+1)%3 != 0) {i+=2;}
             for(int next: primes)
             {
                 if( (i+next-1)%next != 0) 
                 {
                     i = i -2 + (next - 1);
                     pr = next;
                     break;
                 }
             }
            }
            /*if(i%(timer*110000) > 100000)
            {
             System.out.println(primes.size());
             timer++;
            }*/
      }
      //System.out.println("done");
      //System.out.println(primes.size());
      //System.out.println(primes.get(primes.size()-1));
      System.out.print(primes);
      long endTime   = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime/1000.0);
    }
    public static int power(int factor, int count)
    {
        if(cur % factor == 0)
        {
         cur/=factor;
         count++;
         count = power(factor, count);
        }
        return count;
    } 
}
