/**
 * Wren: Chapter 1 - Beginning to Black Sun Hideout.
 *
 * @author (T.H. Kazi)
 * @version (April 7th, 2019)
 */
public class Chapter1
{
    public static int alpha;//Referenced for Chapter 2
    public static int beta;//Referenced for Chapter 3
    public static int fail=0;//Used to track number of game failures throughout chapters - changes ending.
    public static int chapt1()
    {
        Text.clear();
        Text.speak("\n//****************\\\\\n||Chapter 1: Ketsu||\n\\\\****************//\n");
        Text.speak("//Meet me where the spice flows under the imperial’s noses; I bet you can’t make it in less than 12 parsecs.\\\\");
        String kes = IBIO.inputString("\"Huh... A riddle... where could that be?\"\n>>");
        if (!(kes.equalsIgnoreCase("Kessel")))
        {
            System.out.println("\n//I thought you could figure that out, at least. Fine - I'll test your hacking skills then.");
            System.out.println("Let's go with some basic ASCII code to character translations, shall we?\\\\");
            Convert();
        }
        Text.speak(" \"Kessel; Kessel’s Respite then. That’s just by the terminal.\"");
        Text.speak("\n Breaking off into a sprint, you hop along the pipes over the streets using your jetpack.");
        Text.speak(" Leaping from above, you land deftly on the roof of the Kessel Respite.");
        Text.speak(" Dropping through the roof access, the wave of techno music washes over you.");
        Text.speak(" Looking down, you immediately blush and avert your gaze.");
        Text.speak(" Still, it wasn't hard to find Ketsu with her distinctive Mandalorian armour.");
        IBIO.inputInt(">>\n");
        if (fail>0)
            Text.speak(" \"Finally. I thought you'd never get here.\"");
        Text.speak(" \"Hey, Ket. You found an in?\"");
        Text.speak(" \"Yeah - it's a good one too.\"");
        Text.speak(" As you walk, Ketsu fills you in.");
        Text.speak("\"Here's the brief - last night, a Black Sun operative arrived at their justicar hideoout with a datapad.");
        Text.speak(" The operative? He's the core worlds recordkeeper. And the datapad he was carrying details every");
        Text.speak(" Black Sun operation in the Core Worlds over the past year.");
        Text.speak(" And we're going to steal it.\"");
        IBIO.inputInt(">>\n");
        
        //MAIN DECISION DIALOGUE - uses ints alpha & beta to affect Chapters 3 & 4.
        Text.speak(" \"Bold. So what's the plan?\"");
        Text.speak(" \"That's where you come in. The compund's surrounded by a military-grade blast wall.");
        Text.speak(" Since you'll be going in, I figure you should choose - do you want to try your hand at hacking the door,");
        System.out.println(" or find a way through the wall?\"\n");
        //INT ALPHA
        alpha = IBIO.inputInt("(1) \"I'll hack my way in\"\n(2) \"I'd rather sneak in the old-fashioned way.\"\n>>\n");
        System.out.print(" \"Alright, ");
        String word = alpha==1? "hacking":"sneaking";
        System.out.print(word);
        Text.speak(" it is. When you're in, what's the action plan?\"");
        //INT BETA
        do
        {
            beta = IBIO.inputInt("(1) \"You think I can disguise as a guard?\"\n(2) \"I wanna try playing it stealthily.\"\n(3) \"Guns blazing. I wanna light that place up!\"\n>>\n");
            if (beta==1)
                Text.speak(" \"That’ll be fun to watch. Never figured you for an actress.\"");
            if (beta==2)
                Text.speak(" \"Keep it nice and quiet - I like it.\"");
            if (beta==3)
                Text.speak(" \"Are you out of your mind? There are way too many of them. Any other ideas?\"");
            else
                ;
        }while (beta!=1&&beta!=2);
        Text.speak("\n \"After you nick the datapad, head straight for the terminal; I'll be waiting there with my ship.");
        Text.speak(" Now grab a gun and get to these coordinates. We'll start our adventure at 22:30.\"");
        Text.speak(" Ketsu gestures to the back of the speeder as you approach it. A staff and a blaster pistol lay there.");
        int charlie =0;
        charlie = IBIO.inputInt("(1) Take the staff\n(2) Take the pistol\n>>");
        if (charlie==1)
        {
            Text.speak(" \"Nuh uh - that one's mine.\"");
            System.out.print(" Rolling your eyes, you grab the pistol. ");
        }
        Text.speak(" Stowing the pistol in your holster, you make your way to the destination.");
        IBIO.inputInt(">>");
        return fail;
    }

    public static boolean Convert() //ASCII conversion game (See top of method chapt1())
    {
        int kes = 444;
        int rep = 0;
        while (kes!=455&&kes!=647)
        {
            if (rep>0)
            {
                System.out.println("//Incorrect.\\\\");
                fail++;
            }
            System.out.println(" 65 -> A");
            char k = IBIO.inputChar(" 75 -> ");
            char e = IBIO.inputChar(" 69 -> ");
            char s = IBIO.inputChar(" 83 -> ");
            char s2 = IBIO.inputChar(" 83 -> ");
            char e2 = IBIO.inputChar(" 69 -> ");
            char l = IBIO.inputChar(" 76 -> ");
            kes = k+e+s+s2+e2+l;
            rep++;
        }
        return true;
    }
}
