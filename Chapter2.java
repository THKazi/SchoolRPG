/**
 * Entering to the Black Sun Hideout.
 *
 * @author (Timurul Hoque Kazi)
 * @version (a version number or a date)
 */
public class Chapter2
{
    public static int chapt2(int alpha,int fail)//Uses decision made in Chapter 1 & adds to failure
    {
        Text.clear();
        Text.speak("//***********************\\\\\n||Chapter 2: Gatecrashing||\n\\\\***********************//");
        Text.speak("           22:30");
        Text.speak("");
        System.out.print(" Leaping down from the pipes running up to the walls of the compound, you");

        //Chapter 1 decision causes branching path:
        if (alpha==1)
            fail = hacker(fail);
        else
            fail = sneak(fail);
        return fail;//After branching path, return total number of times the user failed to class Wren.
    }

    public static int hacker(int fail)//Hacking path 
    {
        Text.speak(" shimmy along the wall, ");
        Text.speak("reaching the door without being detected by the sentries.");
        Text.speak(" Running a cord from your wrist kit to the panel, you try to lift the passcode from");
        Text.speak(" the system, but only broken fragments run across the screen. You'll have to unscramble them...");
        IBIO.inputInt(">>");
        Text.speak("");
        Text.speak("//HACKER\\\\");
        Text.speak("");
        int hack1 = hack("Planet","taursCcon","Coruscant");
        int hack2 = hack("Gang Gang!","nSak lBuc","Black Sun");
        int hack3 = hack("Our lord, Darth","dVrae","Vader");
        int hack4 = hack("I am the","entaSe","Senate");
        if ((hack1+hack2+hack3+hack4)>2)
        {
            Text.speak("The doors slide open with a hiss and you slip in, crouch-running behind a pile of crates to avoid patrols.");
        }
        else
        {
            Text.speak(" With a loud buzz, the console locks. They were bound to send someone");
            Text.speak(" down here - you should find another way in.");
            fail++;
            System.out.print(" You");
            sneak(fail);
        }
        return fail;
    }

    public static int hack(String text, String scramble, String trueAns)//Hacking path task - unscramble word
    {
        Text.var(".-----------------------------.",50);
        Text.var("| # DeltaSec            TI-82 |",50);
        Text.var("| .-------------------------. |",50);
        Text.var("| |                         | |",50);
        Text.var("| |_________________________| |___",50);
        Text.var("| |   "+text,50);
        Text.var("| |      "+scramble,50);
        Text.var("| |                         | |---",50);
        Text.var("| '-------------------------' |",50);
        Text.var("| [   ][   ][   ][   ] [   ]  |",50);
        Text.var("| [   ][   ][   ][   ] [   ]  |",50);
        Text.var("| [   ][   ][   ][   ] [   ]  |",50);
        Text.var("'-------               -------'",50);
        Text.var("       |       |",50);
        String ans = IBIO.inputString("        Unscrambled: ");
        if (ans.equalsIgnoreCase(trueAns))
        {
            Text.var("<<CORRECT>>",1500);
            return 1;
        }
        else
        {
            Text.var("<<INCORRECT>>",1500);
            return 0;
        }
    }

    public static int sneak(int fail)//Sneaking path
    {
        Text.speak(" creep around the perimeter searching for - that. A vent.");
        Text.speak("");
        Text.speak("\"Ket, can you trace an entry point?\"");
        System.out.print("\"Sure -");
        try{Thread.sleep(1500);}
        catch(InterruptedException m) {;}
        Text.speak(" it's just northwest, by a Correllian Grill. The vent blocks comms though.");
        Text.speak("");
        IBIO.inputInt(">>");
        //THE VENT
        Text.speak("");
        Text.speak("//THE VENT\\\\");
        Text.speak("");
        Text.speak("\"You'll only have a 30 seconds to get through the vents while the scanners are down,");
        System.out.print("so listen carefully. ");
        int crawl=1;
        while (crawl==1)
        {
            //Directions
            Text.speak("You ready for directions?\"");
            IBIO.inputInt(">>");
            ventInstruct("Left");
            ventInstruct("Right");
            ventInstruct("Right");
            ventInstruct("Left");
            ventInstruct("Right");
            ventInstruct("Left");
            ventInstruct("Left");
            ventInstruct("Right");
            Text.speak("(Type L or R and press enter to keep crawling through the vent)");
            IBIO.inputInt("\"Get going.\"\n(Press enter to begin)");

            //GAME
            Text.clear();
            long time = (System.currentTimeMillis()/1000)+15;//Sets timer for 15 seconds
            boolean a = vent(1,time,'l','L');//Assigns every user input to a variable
            boolean b = vent(2,time,'r','R');
            boolean c = vent(3,time,'r','R');
            boolean d = vent(4,time,'l','L');
            boolean e = vent(5,time,'r','R');
            boolean f = vent(6,time,'l','L');
            boolean g = vent(7,time,'l','L');
            boolean h = vent(8,time,'r','R');
            if (a&&b&&c&&d&&e&&f&&g&&h) //If every turn is correct, success.
            {
                Text.speak("Rounding the corner, the final grate was in sight. Nimbly lifting and pulling it into the vent,");
                Text.speak("you drop into a massive chamber, quickly rolling behind a pile of crates as a patrol passes by.");
                crawl=0;
            }
            else
            {
                Text.speak("All of a sudden, you hear laser grids snap back on ahead of you - and they're moving towards you."); 
                Text.speak("Quickly flipping around inside of the vent, you use your jetpack to blast out the way you came in.");
                Text.speak("\"You didn't make it through,\" a voice declares over the comms.");
                Text.speak("\"You better get through this time - we're running out of time.\"");
                fail++;
            }
        }
        return fail;
    }

    public static void ventInstruct(String direction) //Use Text class for variable Thread.sleep()
    {
        Text.var(direction,500);//Just so one doesn't have to type ",500" in each line this method is used.
    }

    public static boolean vent(int turn, long time, char direct, char Direct) //Sneaking path task - vent crawl
    {
        char a = IBIO.inputChar("Turn "+turn+": ");//Takes user input
        long curTime = time-(System.currentTimeMillis()/1000);//Calculates time left
        System.out.println(curTime+" seconds");//Outputs time left
        if ((a==direct||a==Direct)&&curTime>0)
            return true;
        else
            return false;
    }
}
