/**
 * Testing various individual functions.
 *
 * @author (Timurul H. Kazi)
 * @version (April 9th, 2019)
 */
public class Test
{
    public static void vent()
    {
        int a=1;
        while(a!=100){
            char b=(char)(Math.random()*57+65);
            System.out.println(b);
        }
    }

    public static void randTest()
    {
        int a = (int)(Math.random()*9);
        int b = 7-a;
        int c = (int)(Math.random()*15);
        int d = 14-c;
        for (int i=0; i<a; i++)
        {
            for (int j=0; j<20; j++)
            {
                char rand = (char)(Math.random()*58+65);
                System.out.print(rand);
            }
            System.out.println("");
        }
        for (int j=0; j<c; j++)
        {
            char rand = (char)(Math.random()*58+65);
            System.out.print(rand);
        }
        int select = (int)(Math.random()*5+1);
        String rando;
        if (select==1)
            rando="VOYAGE";
        else if (select==2)
            rando="LOUDER";
        else if (select==3)
            rando="MENACE";
        else if (select==4)
            rando="STREET";
        else
            rando="LAUREL";
        System.out.print(rando);
        for (int j=0; j<d; j++)
        {
            char rand = (char)(Math.random()*58+65);
            System.out.print(rand);
        }
        for (int i=0; i<b; i++)
        {
            System.out.println("");
            for (int j=0; j<20; j++)
            {
                char rand = (char)(Math.random()*58+65);
                System.out.print(rand);
            }
        }   
    }
    public static boolean joe;
    public static void boole()
    {
        System.out.println(joe);
    }

    public static void charray(String a)
    {
        for (char c: a.toCharArray())
            Text.var(""+c,700);
    }
}
