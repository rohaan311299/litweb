import java.util.*;
import java.io.*;
public class poker
{
    public static deck d = new deck();
    public static hand h = new hand();
    public static player p1 = new player();
    public static player2 p2 = new player2();
    public static int money_1 = 100;
    public static int money_2 = 100;
    public static int turn = 1;
    public static int pot = 0;
    public static int check = 0;
    public static void clrscr(){
    //Clears Screen in java
    try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
    }
    public static void play_round()
    {
        int played = 0;
        
        int match = 0;
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("It is Player "+turn+"'s turn");
            if(match == 0)
            {
                System.out.println("Press 1 for check, 2 for bet and 3 for fold");
                int input = sc.nextInt();
                if(input == 1)
                {
                    if(turn == 1)
                    turn = 2;
                    else
                    turn = 1;
                    played++;
                    if(played == 1)
                    continue;
                    else
                    break;
                }
                else if(input == 2)
                {
                    System.out.println("Enter bet amount: ");
                    int bet = sc.nextInt();
                    if(turn == 1)
                    {money_1 -= bet;
                        turn = 2;}
                    else
                    {money_2 -= bet;
                        turn = 1;}
                    pot += bet;
                    match = bet;
                    continue;
                }
                else
                {
                    if(turn == 1)
                    {
                        money_2 += pot;
                        pot = 0;
                        check = 1;
                        System.out.println("Player 1 folds, Player 2 takes the hand");
                        break;
                    }
                    if(turn == 2)
                    {
                        money_1 += pot;
                        pot = 0;
                        check = 1;
                        System.out.println("Player 2 folds, Player 1 takes the hand");
                        break;
                    }
                }
            }
            else
            {
                System.out.println("Press 1 for match, 2 for raise and 3 for fold");
                int input = sc.nextInt();
                if(input == 1)
                {
                    if(turn == 1)
                    {
                        money_1 -= match;
                        turn = 2;
                        pot += match;
                        match = 0;
                        System.out.println("Player 1 makes the match");
                        break;
                    }
                    else if(turn == 2)
                    {
                        money_2 -= match;
                        pot += match;
                        match = 0;
                        turn = 1;
                        System.out.println("Player 2 makes the match");
                        break;
                    }
                }
                else if(input == 2)
                {
                    System.out.println("Enter raise amount: ");
                    int raise = sc.nextInt();
                    if(turn == 1)
                    {
                        money_1 -= (match + raise);
                        pot += (match + raise);
                        match = raise;
                        turn = 2;
                        System.out.println("Player 1 raises by "+raise);
                        continue;
                    }
                    if(turn == 2)
                    {
                        money_2 -= (match + raise);
                        pot += (match + raise);
                        match = raise;
                        turn = 1;
                        System.out.println("Player 2 raises by "+raise);
                        continue;
                    }
                }
                else
                {
                    if(turn == 1)
                    {
                        money_2 += pot;
                        pot = 0;
                        check = 1;
                        System.out.println("Player 1 folds, Player 2 takes the hand");
                        break;
                    }
                    if(turn == 2)
                    {
                        money_1 += pot;
                        pot = 0;
                        check = 1;
                        System.out.println("Player 2 folds, Player 1 takes the hand");
                        break;
                    }   
                }
            }
            
        }
    }
    public static void main(String[] args)
    {
        int round = 0;
        System.out.println("Welcome to 2 player poker!");
        System.out.println("Both players have a spend limit of 100");
        while(true)
        {
            System.out.println();
            Scanner sc = new Scanner(System.in);
            d.make_deck();
            d.shuffle();
            p1.deal();
            p2.deal();
            System.out.print("Player 1 hand is: ");
            for(int i = 0; i<2;i++)
            {
                System.out.print(p1.hand1[i]+" ");
            }
            System.out.println();
            System.out.println("Press any key to hide player 1 hand and show player 2 hand");
            String csr = sc.next();
            clrscr();
            System.out.print("Player 2 hand is: ");
            for(int i = 0; i<2;i++)
            {
                System.out.print(p2.hand2[i]+" ");
            }
            System.out.println();
            System.out.println("Press any key to hide player 2 hand and start the game!");
            String csr1 = sc.next();
            clrscr();
            play_round();
            round++;
            if(check == 1)
            {
                check = 0;
                round = 0;
                continue;
            }
            System.out.println();
            System.out.println("After round "+round+", player 1 has "+money_1+" left in the wallet and player 2 has "+money_2+" left in the wallet");
            d.flop();
            System.out.println();
            System.out.print("The flop is: ");
            for(int i = 0; i<3; i++)
            {
                System.out.print(d.flops[i]+" ");
            }
            System.out.println();
            play_round();
            round++;
            if(check == 1)
            {
                check = 0;round = 0;
                continue;
            }
            System.out.println();
            System.out.println("After round "+round+", player 1 has "+money_1+" left in the wallet and player 2 has "+money_2+" left in the wallet");
            System.out.println();
            d.turn();
            System.out.print("The turn is: "+d.turns[0]);
           
            System.out.println();
            System.out.print("The current board is: ");
            for(int i = 0; i<3; i++)
            {
                System.out.print(d.flops[i]+" ");
            }
            System.out.print(""+d.turns[0]);
            System.out.println();
            play_round();
            round++;
            if(check == 1)
            {
                check = 0;round = 0;
                continue;
            }
            System.out.println();
            System.out.println("After round "+round+", player 1 has "+money_1+" left in the wallet and player 2 has "+money_2+" left in the wallet");
            System.out.println();
            d.river();
            System.out.println("The river is: "+d.rivers[0]);
            System.out.print("The current board is: ");
            for(int i = 0; i<3; i++)
            {
                System.out.print(d.flops[i]+" ");
            }
            System.out.print(""+d.turns[0]+" ");
            System.out.println(""+d.rivers[0]);
            System.out.println();
            play_round();
            round++;
            if(check == 1)
            {
                check = 0;round = 0;
                continue;
            }
            int final_hand_1_suits[] = new int[7];
            int final_hand_1_ranks[] = new int[7];
            int final_hand_2_suits[] = new int[7];
            int final_hand_2_ranks[] = new int[7];
            for(int i = 0; i<2;i++)
            {
                final_hand_1_suits[i] = p1.suits[i];
                final_hand_1_ranks[i] = p1.ranks[i];
                final_hand_2_suits[i] = p2.suits[i];
                final_hand_2_ranks[i] = p2.ranks[i];
            }
            for(int i = 0, j = 2; i<3; i++,j++)
            {
                final_hand_1_suits[j] = d.flop_suits[i];
                final_hand_1_ranks[j] = d.flop_ranks[i];
                final_hand_2_suits[j] = d.flop_suits[i];
                final_hand_2_ranks[j] = d.flop_ranks[i];
            }
            final_hand_1_suits[5] = d.turn_suit;
            final_hand_1_suits[6] = d.river_suit;
            final_hand_1_ranks[5] = d.turn_rank;
            final_hand_1_ranks[6] = d.river_rank;
            final_hand_2_suits[5] = d.turn_suit;
            final_hand_2_suits[6] = d.river_suit;
            final_hand_2_ranks[5] = d.turn_rank;
            final_hand_2_ranks[6] = d.river_rank;
            int hand_1 = h.evaluate(final_hand_1_suits, final_hand_1_ranks);
            int hand_2 = h.evaluate(final_hand_2_suits, final_hand_2_ranks);
            System.out.println();
            print(hand_1,1);
            print(hand_2,2);
            if(hand_1<hand_2)
            {
                System.out.println("Player 1 takes the pot");
                money_1 += pot;
                pot = 0;
            }
            else if(hand_2<hand_1)
            {
                System.out.println("Player 2 takes the pot");
                money_2 += pot;
                pot = 0;
            }
            else
            {
                System.out.println("Both have same hand rank. We split the pot");
                pot = pot/2;
                money_1 += pot;
                money_2 += pot;
                pot = 0;
            }
            System.out.println();
            System.out.println("After round "+round+", player 1 has "+money_1+" left in the wallet and player 2 has "+money_2+" left in the wallet");
            if(money_1<=0 || money_2<=0)
            break;
            System.out.println();
            System.out.println("Enter 1 to continue playing and 2 to quit");
            int quit = sc.nextInt();
            if(quit == 2)
            break;
            else
            continue;
        }
    }
    public static void print(int hand, int p)
    {
        if(hand == 1)
        System.out.println("Player "+p+" has Royal Flush");
        else if(hand == 2)
        System.out.println("Player "+p+" has Straight Flush");
        else if(hand == 3)
        System.out.println("Player "+p+" has Quads");
        else if(hand == 4)
        System.out.println("Player "+p+" has Full House");
        else if(hand == 5)
        System.out.println("Player "+p+" has Flush");
        else if(hand == 6)
        System.out.println("Player "+p+" has Straight");
        else if(hand == 7)
        System.out.println("Player "+p+" has Three of a kind");
        else if(hand == 8)
        System.out.println("Player "+p+" has Two Pair");
        else if(hand == 9)
        System.out.println("Player "+p+" has Pair");
        else if(hand == 10)
        System.out.println("Player "+p+" has High Card");
    }
}
