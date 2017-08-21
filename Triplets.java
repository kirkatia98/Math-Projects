
/**
 * Write a description of class Triplets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Triplets
{
  public static void main( String [] args)
  {
      for(int c = 499; c >333; c--)
      {
          for(int b = c-1; b >= (c-1)/2; b--)
          {
              int a = 1000 - c - b;
              if( Math.pow(c,2) == Math.pow(a,2) + Math.pow(b,2))
              {
                  System.out.print(a*b*c);
                }
            }
        }
    }
}
