
import java.util.*;
public class player2
{
    public static deck d = new deck();
    public static String hand2[] = new String[2];
    public static int suits[] = new int[2];
    public static int ranks[] = new int[2];
    public void deal()
    {
        d.shuffle();
        int random = 3;
        for(int i = 0; i<2;i++)
        {
           
            for(int j = 0; j<13; j++)
            {
                if(d.deck[random] == d.spades[j])
                suits[i] = 1;
                else if((d.deck[random] == d.hearts[j]))
                suits[i] = 2;
                else if(d.deck[random] == d.diamonds[j])
                suits[i] = 3;
                else if(d.deck[random] == d.clubs[j])
                suits[i]= 4;
                else
                continue;
            }
            for(int j = 0; j<4; j++)
            {
                if(d.deck[random]==d.aces[j])
                ranks[i] = 13;
                else if(d.deck[random]==d.kings[j])
                ranks[i] = 12;
                else if(d.deck[random]==d.queens[j])
                ranks[i] = 11;
                else if(d.deck[random]==d.jacks[j])
                ranks[i] = 10;
                else if(d.deck[random]==d.tens[j])
                ranks[i] = 9;
                else if(d.deck[random]==d.nines[j])
                ranks[i] = 8;
                else if(d.deck[random]==d.eights[j])
                ranks[i] = 7;
                else if(d.deck[random]==d.sevens[j])
                ranks[i] = 6;
                else if(d.deck[random]==d.sixes[j])
                ranks[i] = 5;
                else if(d.deck[random]==d.fives[j])
                ranks[i] = 4;
                else if(d.deck[random]==d.fours[j])
                ranks[i] = 3;
                else if(d.deck[random]==d.threes[j])
                ranks[i] = 2;
                else if(d.deck[random]==d.dueces[j])
                ranks[i] = 1;
                else
                continue;
            }
            hand2[i] = d.deck[random];
            for(int j = random; j<50;j++)
            {
                d.deck[i] = d.deck[i+1];
            }
            random += 2;
        }
    }
}
