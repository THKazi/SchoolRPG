/**
 * This is the executable file for Wren. This is a directory of sorts, that calls on all of the other classes when they're needed.
 *
 * @author (Timurul Hoque Kazi)
 * @version (April 8th, 2019)
 */
public class Wren
{
    public static void main(String args[])
    {
        new Wren();

    }   

    //This is the "master class" - everything starts and ends here.
    public Wren()
    {
        Chapter1 c1 = new Chapter1();
        Chapter2 c2 = new Chapter2();
        Chapter3 c3 = new Chapter3();
        Chapt3A c3a = new Chapt3A();
        Chapter4 c4 = new Chapter4();
        char play;
        do
        {
            Text.clear();
            Intro intro = new Intro();//Introductory scroll
            //Chapter 1
            c1.chapt1();
            int fail = c1.fail;
            int a = c1.alpha;
            int b = c1.beta;
            //Chapter 2
            fail = c2.chapt2(a,fail);
            //Chapter 3
            fail = c3.chapt3(b,fail);
            int deadNum = Chapter3.deadNum;
            if (deadNum==1)
            {
                Text.speak(" \"She was so damn close!\" Ketsu slammed her fist into the table.");
                Text.speak(" \"I guess if you want something done right, you have to do it yourself.");
                System.out.println("YOU ACHIEVED 1 OF 8 POSSIBLE ENDINGS:\n {Unsuccessful Infiltrator}");
                System.exit(0);
            }
            else if (deadNum==2)
                b=3;
            fail = Chapt3A.datapad(fail);
            Chapt3A.divert(b);
            char slave = slave();
            if (slave=='y'||slave=='Y')
                Chapter4.detour();
            else if (fail<3)//
            {
                Text.speak(" No, you can't risk it. Waiting for just a bit longer, Ketsu arrives on The Firebird and begins to speak");
                Text.speak(" with a dock officer - right up to the point you knock him out cold. Even though Ketsu was wearing her helmet, Sabine could feel her smile.");
                Text.speak(" \"Well done, Sabine. This,\" she said, gesturing towards the datapad, \"is all we need to join some of the galaxy’s best hunters. ");
                Text.speak(" Now let’s bolt before anybody comes looking for poor Tommy here.\"");
                Text.speak(" A pang of guilt runs through you for abandoning the slaves - but you don't owe them anything. You're a bounty hunter.");
                IBIO.inputInt(">>\n");
                Text.speak(" Mere moments later, the small ship rose from the landing platform and streaked into Coruscant’s skies. ");
                Text.speak(" This is where the story of two of the galaxy’s most prominent bounty hunters truly began.");
                Text.speak("");
                Text.pause();
                System.out.println("YOU ACHIEVED 1 OF 8 POSSIBLE ENDINGS:\n {Clean Getaway}");
            }
            else
                betray();
            Text.speak("\n");
            Text.pause();
            play = IBIO.inputChar("Would you like to go back to the start and find another ending? (y/n)\n>> ");
        } while (play=='y'||play=='Y');
    }

    public static char slave()
    {
        Text.speak(" \"Sabine?\" A voice whispers on your comm.");
        Text.speak(" \"Ketsu - nice of you to check in. I’ve got the datapad - what’s the ETA?\"");
        Text.speak(" \"I’m already on my way; I shouldn’t be any more than 20 minutes away. What -\"");
        Text.speak(" You mute the comm as a patrolman walks by. Your eyes follow him for a while, to make sure he was out of range,");
        Text.speak(" then you flick the comm back on. \"Just lie low and don’t cause trouble. I mean it, Wren.\"");
        Text.speak(" \"I got it. Just get here and we can claim our prize.\"");
        IBIO.inputInt(">>\n");
        Text.speak(" As the comm channel closes, you immediately sneak off in the direction of the patrolman. Creeping up on him,");
        Text.speak(" you duck around a shipping container, eavesdropping on his report.");
        Text.speak(" \"Yes sir, the slaves are prepared. Yes - well, no, not entirely sir. Well, you see,");  
        Text.speak(" this one Wookie has been resistant to the shock collars, sir.");
        Text.speak(" But - sir, that could kill them... Don’t you think - yes sir, it will be done.\"");
        Text.speak("");
        Text.speak(" Switching channels, the patrolman (clearly an officer) spoke with solemn brevity.");
        Text.speak(" \"Prepare the syringes.\"");
        Text.speak(" You could probably save those slaves. Hell, it could even be the spectacle Black Sun would need to accept you and Ketsu into their ranks."); 
        Text.speak(" Then again, it could ruin the entire plan, and with it, your hopes of getting into Black Sun.");
        char slave = IBIO.inputChar("Intervene? (y/n)\n>> ");
        Text.speak("");
        return slave;        
    }

    public static void betray()
    {
        Text.speak(" Just as you get to the docks, Ketsu’s Firebird lands and extends its ramp. You run up to it - ");
        Text.speak(" then a laser bolt rams your knee out from under you.");
        Text.speak(" \"What the hell were you thinking Sabine!\" Ketsu growls as she descends.");
        Text.speak(" \"You idiot!\" She punctuated her shout with a kick to your ribs.");
        Text.speak(" \"I can’t have this on my hands - not if I want to get into Black Sun.\" ");
        Text.speak(" You lie on the ground, clutching your burning knee.");
        IBIO.inputInt(">> ");
        Text.speak("");
        Text.speak(" Picking up the datapad, she turned and paced up the ramp.");
        Text.speak(" \"No... KETSU! I didn't fail you! I got you the datapad!\"");
        Text.speak(" \"Goodbye, Wren.\"");
        IBIO.inputInt(">> ");
        Text.pause();
        System.out.println("YOU ACHIEVED 1 OF 8 POSSIBLE ENDINGS:\n {Betrayed}");
    }
}