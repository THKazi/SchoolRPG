/**
 * Create methods that utilise the Thread.sleep() function, so it is easier to deploy repeatedly - because a normal block of text is boring.
 *
 * @author (Timurul H. Kazi)
 * @version (April 8th, 2019)
 */
public class Text
{
    public static void speak(String a) //Standard println with set timing
    {
        System.out.println(a);
        try{        
            Thread.sleep(200);
        }
        catch(InterruptedException m){
            ;    
        }
    }

    public static void var(String a,int i) //Variable timing println
    {
        System.out.println(a);
        try{        
            Thread.sleep(i);
        }
        catch(InterruptedException m){
            ;    
        }
    }

    public static void printVar(String a, int i) //Variable timing print
    {
        System.out.print(a);
        try{        
            Thread.sleep(i);
        }
        catch(InterruptedException m){
            ;    
        }
    }
    
    public static void clear() //Clears screen via repeat black print
    {
        try{Thread.sleep(1500);}
        catch(InterruptedException m) {;}
        for (int i=0; i<35; i++)
            Text.var("",50);
        try{Thread.sleep(1000);}
        catch(InterruptedException m) {;}
    }
    
    public static void pause() //Longer pause when necessary
    {
        try{Thread.sleep(1500);}
        catch(InterruptedException m) {;}
    }
    
    public static void run(String a)
    {
        //LEARN HOW TO USE "<String>.toCharArray()" to create an array of characters
        //Purpose: print a run of characters from an inputted string (Legend of Zelda style)
    }
}
