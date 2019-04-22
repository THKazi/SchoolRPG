/**
 * Chapter 3 - the bridge between getting inside the compound and reaching the datapad.
 *
 * @author (Timurul H. Kazi)
 * @version (April 10th, 2019)
 */
public class Chapter3
{
    public static int chapt3(int beta, int fail) //Uses choice from Chapter 1 to branch
    {
        IBIO.inputInt(">>");
        Text.clear();
        Text.speak("//**********************\\\\\n||Chapter 3: The Datapad||\n\\\\**********************//");
        Text.speak("");
        if (beta==1)
            fail = guise(fail); //Disguise path
        else if (beta==2)
        {
            Text.speak(" Swiftly dashing from crate to crate, you rush up behind a guard in front of the command hub.");
            fail = sneak(fail); //Sneak path
        }
        return fail;
    }

    public static int guise(int fail) //Disguise path
    {
        Text.speak(" Eventually, a lone guard rounds the corner, only to receive a firm");
        Text.speak(" knee to the gut and an uppercut across the jaw.");
        Text.speak(" Stashing your kit in a vent, you stand and stride out to assume the guard’s duties.");
        Text.speak(" Making an extra round for assurance, you swiftly turn a corner");
        Text.speak(" and march towards the command hub. Mere steps away,");
        Text.speak(" a meaty hand grabs you on the shoulder and spin you about.");
        IBIO.inputInt(">>");
        Text.speak("");
        Text.speak(" \"Hey, kid, uh - what was your name again? Trent? Trebor? Tellys?\"");

        //Dialogue game: Series of multiple choice questions - if two are incorrect, player fails -> redirected to sneak path
        int name = IBIO.inputInt("1) Trent\n2) Trebor\n3) Tellys\n4) Tessie\n>> ");
        System.out.print(" \"Yeah, that's what I thought.");
        int convo = 0;
        if (name==1||name==3)
            Text.speak(" I was just testing you.\" He smiles candidly and continues. ");
        else
        {
            Text.speak(" \" He frowns slightly and continues. ");
            convo++;
        }
        Text.speak("");
        Text.speak(" \"What're you headed in there for anyways?\"");
        int visit = IBIO.inputInt("1) \"Just visiting a friend.\"\n2) \"Just on my patrol.\"\n3) \"Going in for a weapons check.\"\n4) \"The bookkeeper requested me.\"");
        if (visit==1)
        {
            Text.speak(" \"I heard that you and - what's it?");
            Text.speak(" Clarys! I heard that you two got hitched!\"");
            int clarys = IBIO.inputInt("1)\"Yeah.\"\n2)\"No...\"\n3)\"It's complicated...\"");
            if (clarys==1)
            {
                Text.speak(" \"Congrats, kid!\" He tossed a glance over his shoulder. \"I'll, uh, cover for you while you're in there.");
                Text.speak(" Have fun, kid,\" he said with a sly grin.");
            }
            else if (clarys==3)
                Text.speak(" \"Ain't it always? Now go, uh, 'visit' that friend of yours,\" he said with a sly grin.");
            else
            {
                Text.speak(" \"Oh, sorry then.\"");
                convo++;
            }

        }
        else if (visit==4)
        {
            Text.speak(" \"You poor sod - I hear the bookkeeper's a menace. I won't keep you from him then.\"");
        }
        else if (visit==3)
        {
            Text.speak(" \"The armoury is out over that way...\" he says, eyeing you suspiciously.");
            convo++;
        } 
        else
        {
            Text.speak(" \"No patrol goes in there...\" he says, eyeing you suspiciously.");
            convo++;
        }
        if (convo>1)
        {
            Text.speak(" \"Wait...\" he begins - ");
            fail++;
            fail = sneak(fail);
        }
        else
        {
            Text.speak("");
            Text.speak(" \"I should get going\" you say.");
            Text.speak(" Moving past him, you rush up the stairs, rounding a corner into the Overseer’s office.");
            Text.speak(" The datapad is laid out before you like a prize.");
        }
        return fail;
    }

    public static int deadNum=0;

    public static int sneak(int fail)//Sneak path
    {
        Text.speak(" In one rapid motion, you strike the guard over the had and dash inside -");
        Text.speak(" it would be safer to stay out of sight from here on. Bolting up the stairs,");
        Text.speak(" You almost run head first into a guard patrol. Ducking into an alcove, you hold your breath.");
        IBIO.inputInt(">>");
        Text.speak("");
        Text.speak("//HOLD YOUR BREATH\\\\");
        Text.speak("");
        Text.speak("(Press enter when prompted to maintain your stealth. The enemy will roll to detect you. Best of 3.)");

        //Sneak path task - roll & compare values
        int stat=1;
        int a=1,b=1,c=1;
        a = sneakRoll("first","pauses briefly.",stat);
        if (a!=17&&a!=21)
        {
            if (a==0)
                stat+=2;
            b = sneakRoll("second","casts a glance about.",stat);
            if (b!=17&&b!=21)
            {
                if (b==0)
                    stat+=2;
                c = sneakRoll("third","seems to look right at you.",stat);
            }
        }

        Text.speak(" The guard takes a step back, sweeps the hall with his gaze, and moves along.");
        Text.speak(" You wait a second before letting out a long sigh of relief.");
        Text.pause();
        Text.speak("");

        //if player fails sneak, they are directed to combat; otherwise, they progress to Chapter 3A
        boolean win=true;
        if ((a+b)==0||(a+c)==0||(b+c)==0)
            win=false;
        if (win==false)
        {
            Text.speak(" All of a sudden, a streak of red scorches your shoulder. Two guards rush you from down the hall.");
            Text.speak(" \"You want some?\" you yell.");
            Text.speak(" \"Then come and get it!\"");
            IBIO.inputInt(">>");
            Text.speak("");
            Text.speak("");
            boolean dead = Fight.combat(2,0);
            fail=100;
            deadNum = dead? 1: 2;
            if (deadNum==2)
            {
                Text.speak("");
                IBIO.inputInt(">>");
                Text.speak(" Sending the last guard standing down with a laserbolt to the chest, you slam through the door");
                Text.speak(" into the Overseer's office, barring it behind you.");
            }
        }
        else
        {
            Text.speak("");
            IBIO.inputInt(">>");
            Text.speak(" As the guards leave your sight, you swiftly slip into the Overseer’s office.");
            Text.speak(" The datapad lies before you like a reward for your troubles getting here.");
        }
        return fail;
    }

    public static int sneakRoll(String round, String notice,int stat) //SNEAK GAME
    {
        //PLAYER
        Text.speak("");
        IBIO.inputInt(" (Press enter to stay stealthed)\n>>");
        Text.speak(" Your stealth score is: ");
        int playSneak = (int)(Math.random()*20+1);
        System.out.println(playSneak);
        Text.speak("");
        //NPC
        Text.speak(" The guard's detection score is: ");
        int npcDetect = (int)(Math.random()*15+1);
        System.out.println(npcDetect);
        Text.pause();
        Text.speak("");
        if (playSneak==17||playSneak==21)//17 & 21 are critical success values
        {
            Text.speak(" Your fiddling with your wrist kit paid off - just as the guards come about, you turn completely invisible. Critical success.");
            return playSneak;
        }
        else if (playSneak>=npcDetect)
        {
            Text.speak(" You stay hidden for the "+round+" round.");
            return 1;
        }
        else
        {
            Text.speak(" The guard "+notice);
            return 0;
        }
    }
}
