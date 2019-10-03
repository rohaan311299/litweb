import java.util.*;
public class deck
{
    public static String deck[] = new String[52];
    public static String flops[] = new String[3];
    public static int flop_suits[] = new int[3];
    public static int flop_ranks[] = new int[3];
    public static String turns[] = new String[1];
    public static int turn_suit;
    public static int turn_rank;
    public static String rivers[] = new String[1];;
    public static int river_suit;
    public static int river_rank;
    public static void shuffle()
    {
        String temp;        
        for(int i = 0;i<51;i++)
        {
            double r = Math.random();
            double rand = r*52;
            int random = (int)rand;
            temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }
    }
        public static String spades[] = {"A-Spade","K-Spade","Q-Spade","J-Spade","10-Spade","9-Spade","8-Spade","7-Spade","6-Spade","5-Spade","4-Spade","3-Spade","2-Spade"};
        public static String hearts[] = {"A-Heart","K-Heart","Q-Heart","J-Heart","10-Heart","9-Heart","8-Heart","7-Heart","6-Heart","5-Heart","4-Heart","3-Heart","2-Heart"};
        public static String diamonds[] = {"A-Diamond","K-Diamond","Q-Diamond","J-Diamond","10-Diamond","9-Diamond","8-Diamond","7-Diamond","6-Diamond","5-Diamond","4-Diamond","3-Diamond","2-Diamond"};
        public static String clubs [] = {"A-Club","K-Club","Q-Club","J-Club","10-Club","9-Club","8-Club","7-Club","6-Club","5-Club","4-Club","3-Club","2-Club"};
        public static String aces[] = {"A-Spade","A-Heart","A-Diamond","A-Club"};
        public static String kings[] = {"K-Spade","K-Heart","K-Diamond","K-Club"};
        public static String queens[] = {"Q-Spade","Q-Heart","Q-Diamond","Q-Club"};
        public static String jacks[] = {"J-Spade","J-Heart","J-Diamond","J-Club"};
        public static String tens[] = {"10-Spade","10-Heart","10-Diamond","10-Club"};
        public static String nines[] = {"9-Spade","9-Heart","9-Diamond","9-Club"};
        public static String eights[] = {"8-Spade","8-Heart","8-Diamond","8-Club"};
        public static String sevens[] = {"7-Spade","7-Heart","7-Diamond","7-Club"};
        public static String sixes[] = {"6-Spade","6-Heart","6-Diamond","6-Club"};
        public static String fives[] = {"5-Spade","5-Heart","5-Diamond","5-Club"};
        public static String fours[] = {"4-Spade","4-Heart","4-Diamond","4-Club"};
        public static String threes[] = {"3-Spade","3-Heart","3-Diamond","3-Club"};
        public static String dueces[] = {"2-Spade","2-Heart","2-Diamond","2-Club"};
    public void make_deck()
    {
        for(int i = 0;i<13;i++)
        {
            deck[i] = spades[i];
        }
        for(int i = 0,j = 13;i<13;i++,j++)
        {
            deck[j] = hearts[i];
        }
        for(int i = 0,j = 26;i<13;i++,j++)
        {
            deck[j] = diamonds[i];
        }
        for(int i = 0,j = 39;i<13;i++,j++)
        {
            deck[j] = clubs[i];
        }
        
    }
    public static void river()
    {
        int random = 15;
        for(int j = 0; j<13; j++)
            {
                if(deck[random] == spades[j])
                river_suit = 1;
                else if((deck[random] == hearts[j]))
                river_suit = 2;
                else if(deck[random] == diamonds[j])
                river_suit = 3;
                else if(deck[random] == clubs[j])
                river_suit = 4;
                else
                continue;
            }
            
            for(int j = 0; j<4; j++)
            {
                if(deck[random]==aces[j])
                river_rank = 13;
                else if(deck[random]==kings[j])
                river_rank = 12;
                else if(deck[random]==queens[j])
                river_rank = 11;
                else if(deck[random]==jacks[j])
                river_rank = 10;
                else if(deck[random]==tens[j])
                river_rank = 9;
                else if(deck[random]==nines[j])
                river_rank = 8;
                else if(deck[random]==eights[j])
                river_rank = 7;
                else if(deck[random]==sevens[j])
                river_rank = 6;
                else if(deck[random]==sixes[j])
                river_rank = 5;
                else if(deck[random]==fives[j])
                river_rank = 4;
                else if(deck[random]==fours[j])
                river_rank = 3;
                else if(deck[random]==threes[j])
                river_rank = 2;
                else if(deck[random]==dueces[j])
                river_rank = 1;
                else
                continue;
            }
            rivers[0] = deck[random];
            for(int j = random; j<46; j++)
            {
               deck[j] = deck[j+1];
            }
    }
    public static void turn()
    {
            int random = 10;
            for(int j = 0; j<13; j++)
            {
                if(deck[random] == spades[j])
                turn_suit = 1;
                else if((deck[random] == hearts[j]))
                turn_suit = 2;
                else if(deck[random] == diamonds[j])
                turn_suit = 3;
                else if(deck[random] == clubs[j])
                turn_suit = 4;
                else
                continue;
            }
            
            for(int j = 0; j<4; j++)
            {
                if(deck[random]==aces[j])
                turn_rank = 13;
                else if(deck[random]==kings[j])
                turn_rank = 12;
                else if(deck[random]==queens[j])
                turn_rank = 11;
                else if(deck[random]==jacks[j])
                turn_rank = 10;
                else if(deck[random]==tens[j])
                turn_rank = 9;
                else if(deck[random]==nines[j])
                turn_rank = 8;
                else if(deck[random]==eights[j])
                turn_rank = 7;
                else if(deck[random]==sevens[j])
                turn_rank = 6;
                else if(deck[random]==sixes[j])
                turn_rank = 5;
                else if(deck[random]==fives[j])
                turn_rank = 4;
                else if(deck[random]==fours[j])
                turn_rank = 3;
                else if(deck[random]==threes[j])
                turn_rank = 2;
                else if(deck[random]==dueces[j])
                turn_rank = 1;
                else
                continue;
            }
            turns[0] = deck[random];
            for(int j = random; j<46; j++)
            {
               deck[j] = deck[j+1];
            }
    }
    public static void flop()
    {
        int random = 6;
        for(int i = 0; i<3; i++)
        {
          
           for(int j = 0; j<13; j++)
            {
                if(deck[random] == spades[j])
                flop_suits[i] = 1;
                else if((deck[random] == hearts[j]))
                flop_suits[i] = 2;
                else if(deck[random] == diamonds[j])
                flop_suits[i] = 3;
                else if(deck[random] == clubs[j])
                flop_suits[i] = 4;
                else
                continue;
            }
            
            for(int j = 0; j<4; j++)
            {
                if(deck[random]==aces[j])
                flop_ranks[i] = 13;
                else if(deck[random]==kings[j])
                flop_ranks[i] = 12;
                else if(deck[random]==queens[j])
                flop_ranks[i] = 11;
                else if(deck[random]==jacks[j])
                flop_ranks[i] = 10;
                else if(deck[random]==tens[j])
                flop_ranks[i] = 9;
                else if(deck[random]==nines[j])
                flop_ranks[i] = 8;
                else if(deck[random]==eights[j])
                flop_ranks[i] = 7;
                else if(deck[random]==sevens[j])
                flop_ranks[i] = 6;
                else if(deck[random]==sixes[j])
                flop_ranks[i] = 5;
                else if(deck[random]==fives[j])
                flop_ranks[i] = 4;
                else if(deck[random]==fours[j])
                flop_ranks[i] = 3;
                else if(deck[random]==threes[j])
                flop_ranks[i] = 2;
                else if(deck[random]==dueces[j])
                flop_ranks[i] = 1;
                else
                continue;
            }
            flops[i] = deck[random];
           
           for(int j = random; j<49; j++)
           {
               deck[j] = deck[j+1];
            }
            random += 1;           
        }
        
    }
}

