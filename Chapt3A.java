/**
 * Part 2 of Chapter 3 - The datapad hacking game.
 *
 * @author (Timurul H. Kazi)
 * @version (April 11th, 2019)
 */
public class Chapt3A
{
    public static int datapad (int fail) 
    {
        Text.speak(" Sitting down and kicking your legs up on the desk for maximal disrespect, you get to work on the datapad.");
        Text.speak(" The datapad’s encryption was tougher than you’d anticipated. Furiously tapping away at the screen");
        Text.speak(" while monitoring the firewall on her wrist kit, Sabine finally got past the initial firewall.");
        Text.speak(" Now, the real challenge begins.");
        IBIO.inputInt(">>");
        Text.speak("");

        //DATAPAD HACKING
        fail = padHack(fail);
        Text.speak("");
        Text.speak(" The firewall tracers were just about to detect your intrusion - then the datapad clicked.");
        Text.speak(" Breathing a sigh of relief, you stand up and download the datapad's info to your wrist kit.");
        IBIO.inputInt(">>");
        Text.speak("");
        return fail;
    }

    public static int padHack(int fail) //Loops used to print out an ASCII art filled with a rectangle of random characters with 1 word amongst them
    {
        int z = 0;
        while (z==0)
        {
            Text.var(" .---------------------------------.",50);
            Text.var(" |  .---------------------------.  |",50);
            Text.var(" |[]|                           |[]|",50);
            int a = (int)(Math.random()*9);
            int b = 7-a;
            int c = (int)(Math.random()*15);
            int d = 14-c;
            for (int i=0; i<a; i++)
            {
                Text.printVar(" |  |  ",50);
                for (int j=0; j<20; j++)
                {
                    char rand = (char)(Math.random()*58+65);
                    Text.printVar(""+rand,10);
                }
                System.out.println("     |  |");
            }
            Text.printVar(" |  |  ",10);
            for (int j=0; j<c; j++)
            {
                char rand = (char)(Math.random()*58+65);
                System.out.print(rand);
            }
            int select = (int)(Math.random()*5+1);
            String rando="";
            switch (select)
            {
                case 1: rando="VOYAGE"; break;
                case 2: rando="LOUDER"; break;
                case 3: rando="MENACE"; break;
                case 4: rando="STREET"; break;
                case 5: rando="LAUREL"; break;
            }
            System.out.print(rando);
            for (int j=0; j<d; j++)
            {
                char rand = (char)(Math.random()*58+65);
                System.out.print(rand);
            }
            System.out.println("     |  |");
            for (int i=0; i<b; i++)
            {
                Text.printVar(" |  |  ",10);
                for (int j=0; j<20; j++)
                {
                    char rand = (char)(Math.random()*58+65);
                    Text.printVar(""+rand,10);
                }
                System.out.println("     |  |");
            }
            Text.var(" |  `---------------------------'  |",50);         
            Text.var(" |      __________________ _____   |",50);   
            Text.var(" |     |   ___            |     |  |",50);   
            Text.var(" |     |  |   |           |     |  |",50);   
            Text.var(" |     |  |   |           |     |  |",50);
            Text.var(" |     |  |   |           |     |  |",50);
            Text.var(" |     |  |___|           |     |  |",50);
            Text.var(" \\_____|__________________|_____|__|",50);
            String scromble = IBIO.inputString(" Find the 6 letter word>>");

            if (scromble.equalsIgnoreCase(rando))
                z=1;
            else
                fail++;
        }
        return fail;
    }

    public static void divert(int a) //Small text divergence depending on approach (for roleplaying purposes)
    {
        if (a==1)
        {
            Text.speak(" Striding out of the room, you 'resume your rounds'. The man that");
            Text.speak(" interrupted you before gave you a knowing wink -");
            Text.speak(" \"If only you really knew what I was doing,\" you laugh to yourself.");
            Text.speak(" You keep walking until you reach the docks - after all,");
            Text.speak(" you're just here to perform a routine ship inspection.");
        }
        else if (a==2)
        {
            Text.speak(" Stepping out onto the balcony, you leap down and move swiftly from");
            Text.speak(" container to machine to building, staying out of sight. Eventually,");
            Text.speak(" you reach the peak of a stack of shipping containers with a clear view");
            Text.speak(" of the dock - now it was up to Ketsu to get her out of here.");
        }
        else
        {
            Text.speak(" Dashing out of the room with your pistol raised, you run the stretch to the docks.");
            Text.speak(" Ketsu would be on your case for causing all of this noise, but at least you got the datapad.");
        }
        IBIO.inputInt(">>");
        Text.speak("");
    }
}
