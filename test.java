
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test
{
    public static void main( String [] args)
    {
        int i = 0;
        search:
        if(i==0)
        {
          for(;;i++)
          {
              if(i>10)
              {
                  System.out.print("break");
                  break search;}
          } 
          System.out.print("k");
        }
    }
}
