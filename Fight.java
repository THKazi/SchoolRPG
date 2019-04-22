/**
 * The primary combat module of Wren.
 *
 * @author (Timurul H. Kazi)
 * @version (April 11th, 2019)
 */
public class Fight
{
    public static boolean combat(int fighters, int advantage)
    {
        Text.speak("//COMBAT INITIATED\\\\");
        //Initialization of variables
        int healP = 50+advantage*5;
        int healNP = fighters*10+10;
        boolean dead = false;

        while (healNP>0&&healP>0)
        {
            Text.speak("");
            IBIO.inputInt(">> ");
            //PLAYER
            int dmgP = (int)(Math.random()*15+advantage);
            healNP-=dmgP;
            if (dmgP==0)
                Text.speak("You send a bolt at the guards, but it goes wide. The guards have "+healNP+" health left.");
            else
                Text.speak("Firing a shot at the guards, you do "+dmgP+" - they have "+healNP+" health left.");
            if (healNP<1)
            {
                dead = false;
                break;
            }

            //NPC
            int dmgNP = (int)(Math.random()*8+(2*fighters));
            healP-=dmgNP;
            if (dmgNP==0)
                Text.speak("The guards fire back - miss. You still have "+healP+" health left");
            else
                Text.speak("The guards fire back, doing "+dmgNP+" damage - you have "+healP+" health left.");

            if (healP<1)
                dead = true;
        }
        return dead;
    }

    public static boolean bulletTime() //time-based inputs; gives player advantage in combat
    {
        Text.speak("//Bullet Time\\\\");
        Text.speak("::Type in the given series of words within 15 seconds");
        IBIO.inputInt(">> ");
        for (int i=3; i>0; i--) //Countdown
            Text.var(""+i,1000); //1000 milliseconds (i.e. 1 second)
        long time = (System.currentTimeMillis()/1000)+15;//Sets start time
        long time2 = (System.currentTimeMillis()/1000);//Calculates time left
        long curTime;
        
        String word="";
        int correct = 0;
        int rep = 0;
        while (time2<time)
        {
            int numTxt = (int)(Math.random()*20+1);
            switch (numTxt)
            {
                case 1: word="Kenobi";break;
                case 2: word="Vader";break;
                case 3: word="Saber";break;
                case 4: word="Mandalore";break;
                case 5: word="Coruscant";break;
                case 6: word="Republic";break;
                case 7: word="Destiny";break;
                case 8: word="Force";break;
                case 9: word="Solo";break;
                case 10: word="Rogue";break;
                case 11: word="Empire";break;
                case 12: word="Fate";break;
                case 13: word="Black Sun";break;
                case 14: word="Terra Firma";break;
                case 15: word="Palpatine";break;
                case 16: word="Alderaan";break;
                case 17: word="Knight";break;
                case 18: word="Meditation";break;
                case 19: word="Dark Saber";break;
                case 20: word="Skywalker";break;
            }
            String ans = IBIO.inputString(word+"\n>>");
            if (ans.equalsIgnoreCase(word))
                correct++;
            rep++;
            time2 = (System.currentTimeMillis()/1000);
            curTime = time-(System.currentTimeMillis()/1000);//Calculates time left
            System.out.println(curTime+" seconds\n");
        }
        Text.speak("Focus: "+correct+"/"+rep);
        boolean result = correct>5? true: false;
        return result;
    }
}
