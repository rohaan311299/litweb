import java.util.*;
public class hand
{
    public int evaluate(int suits[], int ranks[])
    {
        if(is_Royal_flush(suits, ranks)==true)
        return 1;
        else if(is_Straight_flush(suits, ranks)==true)
        return 2;
        else if(is_quads(suits, ranks)==true)
        return 3;
        else if(is_full_house(suits, ranks)==true)
        return 4;
        else if(is_flush(suits, ranks)==true)
        return 5;
        else if(is_straight(suits, ranks)==true)
        return 6;
        else if(is_set(suits, ranks)==true)
        return 7;
        else if(is_two_pair(suits, ranks)==true)
        return 8;
        else if(is_pair(suits, ranks)==true)
        return 9;
        else
        return 10;
    }
    public boolean is_Royal_flush(int suits[], int ranks[])
    {
        Arrays.sort(ranks);
        Arrays.sort(suits);
        int c = 0;
        for(int i = 0; i<=5; i++)
        {
            if(suits[i] == suits[i+1])
            {c++;}
        }
        if(c<5)
        return false;
        else 
        {
            int f1 = 0, f2 = 0, f3 = 0, f4 = 0, f5 = 0;
            for(int i = 0; i<7;i++)
            {
                if(ranks[i] == 13)
                {f1++;continue;}
                else if(ranks[i] == 12)
                {f2++;continue;}
                else if(ranks[i] == 11)
                {f3++;continue;}
                else if(ranks[i] == 10)
                {f4++;continue;}
                else if(ranks[i] == 9)
                {f5++;continue;}
            }
            if(f1>=1 && f2>=1 && f3>=1 && f4>=1 && f5>=1)
            return true;
            else
            return false;
        }
    }
    public boolean is_Straight_flush(int suits[], int ranks[])
    {
        Arrays.sort(ranks);
        Arrays.sort(suits);
        int c = 0, a = 0;
        for(int i = 0; i<6; i++)
        {
            if(suits[i] == suits[i+1])
            {c++;
            }
        }
        if(c<5) 
        return false;
        else
        {
            int c1 = 0, c2 = 0, c3 = 0;
            for(int i = 0,j=1,k=2; i<4;i++,j++,k++)
            {
                if(ranks[i] == (ranks[i+1] - 1))
                c1++;
                if(ranks[j] == (ranks[j+1] - 1))
                c2++;
                if(ranks[k] == (ranks[k+1] - 1))
                c3++;
            }
            if(c1 == 4 || c2 == 4 || c3 == 4)
            return true;
            else
            return false;
        }
        
    }
    public boolean is_straight(int suits[], int ranks[])
    {
        Arrays.sort(ranks);
        int c1 = 0, c2 = 0, c3 = 0;
        if(ranks[0]==13 && ranks[6] == 2 && ranks[5] == 3 && ranks[4] == 4 && ranks[3] == 5)
        return true;
        for(int i = 0,j=1,k=2; i<4;i++,j++,k++)
        {
           if(ranks[i] == (ranks[i+1] - 1))
           c1++;
           if(ranks[j] == (ranks[j+1] - 1))
           c2++;
           if(ranks[k] == (ranks[k+1] - 1))
           c3++;
        }
        if(c1 == 4 || c2 == 4 || c3 == 4)
        return true;
        else
        return false;
    }
    public boolean is_flush(int suits[], int ranks[])
    {
        Arrays.sort(suits);
        int c1 = 0, c2=0,c3=0,c4=0, a = 0;
        for(int i = 0; i<7; i++)
        {
            if(suits[i] == 1)
            c1++;
            else if(suits[i] == 2)
            c2++;
            else if(suits[i] == 3)
            c3++;
            else
            c4++;
        }
        if(c1>=5 || c2>=5 || c3>=5 || c4>=5) 
        return true;
        return false;
    }
    public boolean is_quads(int suits[], int ranks[])
    {
        Arrays.sort(ranks);
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        for(int i = 0,j=1,k=2,l=3; i<3; i++,k++,j++,l++)
        {
            if(ranks[i] == ranks[i+1])
            c1++;
            if(ranks[j] == ranks[j+1])
            c2++;
            if(ranks[k] == ranks[k+1])
            c3++;
            if(ranks[l] == ranks[l+1])
            c4++;
        }
        if(c1==3||c2==3||c3==3||c4==3)
        return true;
        else
        return false;
    }
    public boolean is_set(int suits[], int ranks[])
    {
        Arrays.sort(ranks);
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0;
        for(int i = 0,j=1,k=2,l=3,m=4; i<2; i++,k++,j++,l++,m++)
        {
            if(ranks[i] == ranks[i+1])
            c1++;
            if(ranks[j] == ranks[j+1])
            c2++;
            if(ranks[k] == ranks[k+1])
            c3++;
            if(ranks[l] == ranks[l+1])
            c4++;
            if(ranks[m] == ranks[m+1])
            c5++;
        }
        if(c1==2||c2==2||c3==2||c4==2||c5==2)
        return true;
        else
        return false;
    }
    public boolean is_pair(int suits[], int ranks[])
    {
        Arrays.sort(ranks);
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0,c6=0;
        for(int i = 0,j=1,k=2,l=3,m=4,n=5; i<1; i++,k++,j++,l++,m++,n++)
        {
            if(ranks[i] == ranks[i+1])
            c1++;
            if(ranks[j] == ranks[j+1])
            c2++;
            if(ranks[k] == ranks[k+1])
            c3++;
            if(ranks[l] == ranks[l+1])
            c4++;
            if(ranks[m] == ranks[m+1])
            c5++;
            if(ranks[m] == ranks[n+1])
            c6++;
        }
        if(c1==1||c2==1||c3==1||c4==1||c5==1||c6==1)
        return true;
        else
        return false;
    }
    public boolean is_full_house(int suits[], int ranks[])
    {
        int c13 = 0, c12 = 0, c11 = 0, c10 = 0, c9 = 0, c8 = 0, c7 = 0, c6 = 0, c5 = 0, c4 = 0, c3 = 0, c2 = 0, c1 = 0;
        for(int i = 0; i<7; i++)
        {
            switch(ranks[i])
            {
                case 13: c13++;break;
                case 12: c12++;break;
                case 11: c11++;break;
                case 10: c10++;break;
                case 9: c9++;break;
                case 8: c8++;break;
                case 7: c7++;break;
                case 6: c6++;break;
                case 5: c5++;break;
                case 4: c4++;break;
                case 3: c3++;break;
                case 2: c2++;break;
                case 1: c1++;break;
            }
        }
        if(c13 == 3)
        {
            if(c12 == 2 || c11 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c12 == 3)
        {
            if(c13 == 2 || c11 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c11 == 3)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c10 == 3)
        {
            if(c12 == 2 || c13 == 2 || c11 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c9 == 3)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c11 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c8 == 3)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c11 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c7 == 3)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c11 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c6 == 3)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c11 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c5 == 3)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c11 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c4 == 3)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c11 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c3 == 3)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c11 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c2 == 3)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c11 == 2 || c1 == 2)
            return true;
        }
        else if(c1 == 3)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c11 == 2)
            return true;
        }
        return false;
    }
    public boolean is_two_pair(int suits[], int ranks[])
    {
        int c13 = 0, c12 = 0, c11 = 0, c10 = 0, c9 = 0, c8 = 0, c7 = 0, c6 = 0, c5 = 0, c4 = 0, c3 = 0, c2 = 0, c1 = 0;
        for(int i = 0; i<7; i++)
        {
            switch(ranks[i])
            {
                case 13: c13++;break;
                case 12: c12++;break;
                case 11: c11++;break;
                case 10: c10++;break;
                case 9: c9++;break;
                case 8: c8++;break;
                case 7: c7++;break;
                case 6: c6++;break;
                case 5: c5++;break;
                case 4: c4++;break;
                case 3: c3++;break;
                case 2: c2++;break;
                case 1: c1++;break;
            }
        }
        if(c13 == 2)
        {
            if(c12 == 2 || c11 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c12 == 2)
        {
            if(c13 == 2 || c11 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c11 == 2)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c10 == 2)
        {
            if(c12 == 2 || c13 == 2 || c11 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c9 == 2)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c11 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c8 == 2)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c11 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c7 == 2)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c11 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c6 == 2)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c11 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c5 == 2)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c11 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c4 == 2)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c11 == 2 || c3 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c3 == 2)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c11 == 2 || c2 == 2 || c1 == 2)
            return true;
        }
        else if(c2 == 2)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c11 == 2 || c1 == 2)
            return true;
        }
        else if(c1 == 2)
        {
            if(c12 == 2 || c13 == 2 || c10 == 2 || c9 == 2 || c8 == 2 || c7 == 2 || c6 == 2 || c5 == 2 || c4 == 2 || c3 == 2 || c2 == 2 || c11 == 2)
            return true;
        }
        return false;
    }
}
