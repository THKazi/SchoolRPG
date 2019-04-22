/**
 * Chapter 4 - the Slave Detour
 *
 * @author (Timurul H. Kazi)
 * @version (April 12th, 2019)
 */
public class Chapter4
{
    public static void detour() //primary method for this story branch
    {
        Text.speak(" \"I mean it, Wren.\" Ketsu’s words flash through your mind. You were like sisters, but you know Ketsu never put feelings above the job. Even for you. ");
        Text.speak(" But you couldn’t just leave the slaves to suffer. ");
        Text.speak(" As the officer turns about and paces you way, you spring out and drag him back into a nook between containers. Minutes later, ");
        Text.speak(" you emerge with a sore knuckle and a location. Scaling the nearest building, you begin to make your way to the west side of the compound - it's pretty ");
        Text.speak(" easy to tell the prison from the rest of the buildings. Silently lifting the roof access, you slip into the building.");
        Text.speak("");
        
        char LR = IBIO.inputChar("Left or right? (L/R) >>");
        if (LR=='l'||LR=='L')
            Text.speak(" Taking a left, you passed by the control room - that could come in handy later. Turning around,");
        Text.speak(" You take the right path to the slave cells. Just as you get there, a man clad in a white lab coat brings a syringe to a small Rodian slave’s neck.");
        Text.speak("");
        
        char SW = IBIO.inputChar("Shoot or wait? (S/W) >>");
        if (SW=='s'||SW=='S')
        {
            Text.speak(" Drawing your pistol, you blast the syringe out of the scientist’s hand.");
            Text.speak(" This was going to get messy.");
        }  
        else
        {
            Text.speak(" Crouching low, you watch as the serum is injected. The Rodian has no reaction at first - then his eyes grow wide and intense.");
            Text.speak(" He begins to hyperventilate, then to whimper, then finally just lie on the ground, shivering.");
            Text.speak(" \"INTRUDER!\" yelled a guard, and a volley of bolts come your way. There was no backing out now.");            
        }
        Text.speak("");
        IBIO.inputInt(">> ");
        boolean advantage = Fight.bulletTime();
        int adv = advantage? 2:0;
        if (adv==2)
            Text.speak(" You zone in and let your instincts guide you (advantage on health & damage)");
        Text.speak(" Snapping out of your concentration, you stand amidst a mound of bodies.");
        Text.speak(" Having taken out all of the guards in the room, you pace menacingly towards the scientist. ");
        Text.speak(" The terror is clear in his eyes as he staggers back. His eyes only grow wider when you place your finger on ");
        Text.speak(" the release switch - with a flick of the finger, the barrier lifts and the slaves were upon him.");
        IBIO.inputInt(">>\n");
        Text.speak(" As the alarm sirens begin to ring outside, you raise your voice.");
        Text.speak(" \"Alright, we need to get out of here, now!\"");
        Text.speak(" The escaped slaves all grab guns and rush past you. The hideout was in a state of frenzy with a near equal number");
        Text.speak(" of Black Sun and slaves. If you don't help them, it's likely that more than half of the slaves would die.");
        Text.speak(" If you do, though, there's a good chance you’d die in their place.");

        //BRANCHCING QUESTION    
        char hero = IBIO.inputChar(" You have freed the slaves - now will you \na) fight with them \n  OR \nb) use them as a diversion to escape?\n>>");
        if (hero=='a'||hero=='A')
            freePath(adv);
        else
            escape(adv);
    }

    public static void freePath(int advantage) //Branch 1 - fight alongside the slaves (combat system)
    {
        Text.speak("Rushing in to join the fray, you deftly fire off vollies of shots into the masses of guards.");
        boolean dead = Fight.combat(4,advantage); 
        IBIO.inputInt("\n>>");
        if (dead)
        {
            Text.speak(" As you fell another guard, a laser slams into your shoulder - then another through your chest.");
            Text.speak(" As you lie in agony, a blast rocked the compound - the slaves breached the gate and made it out.");
            Text.speak(" Dozens of slaves escaped due to your actions. But was it worth it?");
            IBIO.inputInt(">>\n");
            Text.pause();
            System.out.println("YOU ACHIEVED 1 OF 8 POSSIBLE ENDINGS:\n {The Martyr}");
        }
        else
        {
            Text.speak(" You'd think that they'd eventually get tired of throwing bodies at you.");
            Text.speak(" As another batch of Black Sun guardsmen ran around a corner, a blast rocked the compound - the slaves breached the gate.");
            Text.speak(" You know Ketsu would never let you live this down - if she ever let you find her again.");
            Text.speak(" But you know that these dozens of slaves wouldn't be alive in a year if you hadn't stepped in.");
            IBIO.inputInt(">>\n");
            Text.pause();
            System.out.println("YOU ACHIEVED 1 OF 8 POSSIBLE ENDINGS:\n {The Liberator}");
        }
    }

    public static void escape(int advantage) //Use slaves to escape - Daisy chain or instant ending.
    {
        Text.speak("As the slaves clash with the Black Sun guards, you slip out of the fray.");
        int toss = (int)(Math.random()*4+1);
        if (toss==1)
            Wren.betray();
        else
        {
            Text.speak("You know Ketsu wouldn't come for you in all of this. Scaling a wall with the assistance of your jetpack, you spot");
            Text.speak("a speeder and make for it. Blasting a Black Sun member off of the adjacent bike, you get to it and wrench the circuitry open.");
            IBIO.inputInt(">>\n");
            Text.speak("Gazing upon the wires, you shrug - \"to hell with it,\" you say, shoving your hand into the circuits.");
            String works = "";
            int i = (int)(Math.random()*15+1);
            while (i>0)
            {
                works = (i%2==0)? "sparks":"fizzes";
                Text.var("The circuit "+works+"...",200);
                i--;
            }
            IBIO.inputInt(">>\n");
            if (works.equals("sparks"))
            {
                Text.speak("With a brief spark, the bike rose off of the ground. Ketsu was going to have your head for all of this -");
                Text.speak("but at least you get to leave with your life. And the Black Sun datapad.");
                IBIO.inputInt(">>\n");
                Text.pause();
                System.out.println("YOU ACHIEVED 1 OF 8 POSSIBLE ENDINGS:\n {The Escape}");
            }
            else
            {
                Text.speak("With a pop and a fizz, the bike rose off of the ground then abruptly slammed back down.");
                Text.speak("Only then do you notice that all of the mayhem of the battle had ceased.");
                Text.speak("\"Stay right there, bounty hunter.\"");
                char decision = IBIO.inputChar("Fight or Submit? (F/S)\n>>");
                if (decision=='F'||decision=='f')
                {
                    Text.speak("You whip your blaster out and fire a single shot - then a cascade of a dozen bolts scorch your body.");
                    Text.speak("As you fall, you spot a single figure watching the events from above."); 
                    Text.speak("Ketsu simply shakes her head and walks away into the shadows.");
                    IBIO.inputInt(">>\n");
                    Text.pause();
                    System.out.println("YOU ACHIEVED 1 OF 8 POSSIBLE ENDINGS:\n {The Defiant}");
                }
                else
                {
                    Text.speak("Before you could utter a word, the officer pistol-whips you and cuffs your hands behind your back");
                    Text.speak("\"That's it. You're spending the rest of your pitiful existence with us, sweets.\"");
                    Text.speak("As they drag you towards the slave pens, you spot a single figure watching the events from above");
                    Text.speak("Ketsu simply glares and walks off into the shadows.");
                    IBIO.inputInt(">>\n");
                    Text.pause();
                    System.out.println("YOU ACHIEVED 1 OF 8 POSSIBLE ENDINGS:\n  {The Slave}");
                }
            }
        }
    }
}
