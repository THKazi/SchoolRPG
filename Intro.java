/**
 * The intro scroll for Wren.
 *
 * @author (T.H. Kazi)
 * @version (April 3rd, 2019)
 */
public class Intro
{
    public static void main (String args[])
    {
        new Intro();
    }

    public Intro()
    {
        int i = 0;
        scroll("   .        .      .             . .     .        .         .          .",0);
        scroll("      .             .                  .                .",0);
        scroll("  .               A long time ago in a galaxy far, far away...   .",0);
        scroll("     .               .           .               .        .             .",0);
        scroll("    .        .                                                           .",0);
        scroll("    .     .                                                           .      .",0);
        scroll("  .     .                                                        .",i+=100);
        scroll("              .   While the Empire consolidates its control  .        .     .",i+=100);
        scroll("                    over the galaxy, they permit criminal    .  .",i+=100);
        scroll("     .       .  syndicates to run amok, even on the capital,            .",0);
        scroll(".        .                        Coruscant.                  .",0);
        scroll("   .          Sabine Wren and Ketsu Onyo, two escapees from the .      .",i+=25);
        scroll("             Imperial Academy on Mandalore, had set their sights",i+=25);
        scroll("          .     on joining the most feared of these syndicates, .   .",i+=25);
        scroll("   .       the Black Sun. Slave traders, bounty hunters, assassins, .     .  .",i+=25);
        scroll(".      .  and even more vile professions. Not the type to mess with.",i+=25);
        scroll("     .        Black Sun had a hideout on Coruscant. Level 1313,    .",i+=25);
        scroll("        Affectionately called Coruscant’s “Hive of Scum and Villainy”.     .",i+=25);
        scroll(".                 And Ketsu and Sabine were about to break in.      .     .         .",i+=25);
        scroll(".        .          .    .    .            .            .                   .",0);
        IBIO.inputInt("    . .    . .     .     .      .      >>     .          .        .");
        scroll("               .               ..       .       .   .             .",0);
        scroll(" .      .     T h i s   i s   t h e   g a l a x y   o f   . . .             .",i=-700);
        scroll("                     .              .       .                    .      .",i);
        scroll(".        .               .       .     .            .",i);
        scroll("   .           .        .                     .        .            .",i);
        scroll("          .               .    .          .              .   .         .",i);
        scroll("     .          ____",i);
        scroll("  .        .   /___/           .           .",i);
        scroll("      .          |     _______",i);
        scroll(".        .       |  ,-'       `-,       .   .     .         .",i);
        scroll("   .          .  | /             \\    .        .        .",i);
        scroll("      .         |`|   __/| |\\__   |           .        .          .",i);
        scroll(".               |]|_______________|      .         .",i);
        scroll(".  .        .   | ||___       ___||    .     .     .    .     .  ",i);
        scroll("        .       | |    `-. .-'    |       .          .",i);
        scroll("            .    \\`-,    | |    ,-'      .      .      .",i);
        scroll(".     .   .       |  \\   | |   /  |      .         .     ",i);
        scroll("                  |   \\  | |  /   |    .       .       .",i);
        scroll(".      .          |,_  | | | |  _,|.        .       .",i);
        scroll("            .        `-|_|-|_|-'    .     .       .         .     .",i);
        scroll(".       ____    __    ____ .______       _______ .__   __. ",i);
        scroll("        \\   \\  /  \\  /   / |   _  \\     |   ____||  \\ |  |      .   ",i);
        scroll("  .   .  \\   \\/    \\/   /  |  |_)  |    |  |__   |   \\|  |    .          .",i);
        scroll("          \\            /   |      /     |   __|  |  . `  |       .",i);
        scroll(".       .  \\    /\\    /    |  |\\  \\----.|  |____ |  |\\   | .       .",i);
        scroll(".           \\__/  \\__/     | _| `._____||_______||__| \\__|       .",i);
        scroll("              .                 .                                        .",i);
        scroll("     .              .  A   S t a r   W a r s   S t o r y        .               .                 .        .           .           .       .   .",i);
        scroll("                .     .                 .          .            .",i);
    }

    public void scroll(String a,int i)
    {
        System.out.println(a);
        try{        
            Thread.sleep(1000+i);
        }
        catch(InterruptedException m){
            ;    
        }
    }
}
