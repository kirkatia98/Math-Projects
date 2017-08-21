import java.util.ArrayList;
public class Triangle
{
    static ArrayList<Integer> primes;
    static ArrayList<Integer> factors;
    public static void main( String [] args )
    {
      primes = new ArrayList<Integer>();
      primes.add(2);
      primes.add(3);
      
      //counter for printing only powers of primes
      int pw = 1;

      try{
      //only check odd numbers
      for(int i = 5; i<Math.pow(10,3); i+=2)
      {     
            //a number is prime if no numbers upto its square root divide it
            //prime till proven inoccent
            boolean prime = true;
            int stop = (int)Math.sqrt(i);
            int pr = 0;
            while( prime && primes.get(pr) <= stop)
            {
                if(i % primes.get(pr) == 0)
                { prime = false;
                }
                pr++;
            }
            if(prime) // if indivisible by every preceding prime
            {
                if(i > Math.pow(10, pw))
                {
                    pw++;
                    System.out.print(i);
                    System.out.print("\t\t");
                    System.out.println(primes.size());
                }
                System.out.print(i);
                System.out.println();
                primes.add(i);
                //if the ith number was prime, the next will be even
                //if i and i+1 are not divisible by three then i+2 must be
                // so skip it
                if( (i+1)%3 != 0) {i+=2;}
            }
      }}
      catch (Exception e) {
        System.out.println(primes.get(primes.size()-1));
        }
      System.out.println("done/n");
      //intilize variables for the traingular number, the increment counter
      // and the largest factor so far encounterd
      int triNum = 0; 
      int add = 1;
      int maxFac = 0;
      while( maxFac != 500)
      {  
         triNum+= add;
         int product = 1;
         add += 1;
         //for every prime upto halfway point, try to factor
         //if its more than half of triNum, it won't divide it
         for(int pr = 0; primes.get(pr)<=triNum/2; pr++)
         {
             //a factor is a subset of the prime factorization of a number
             //every prime in the factorization can be included in the 
             //factor upto the number of times it appears in the number,
             //or not at all. But forevery prime there is at least one
             //combination, not being included at all, signified by a one
             product*= (1 + power(triNum, primes.get(pr), 0) );
         }
         //one is not a factor so is excluded
         if(product - 1 > maxFac && product<=500)
         {
             maxFac= product - 1;
             System.out.print(triNum);
             System.out.print("     ");
             System.out.println(maxFac);
         }
      }
      System.out.print(triNum);
    }
    public static int power(int num, int factor, int count)
    {
        if(num % factor == 0)
        {
         num/=factor;
         count++;
         count=power(num, factor, count);
        }
        return count;
    } 
}
