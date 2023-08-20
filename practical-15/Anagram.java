import java.util.*;
public class Anagram
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER A WORD : ");
        String word = sc.next().toUpperCase();
        System.out.println("ANAGRAMS OF " + word + " ARE : ");
        int n = word.length();
        if(n>7)
        {
            System.out.println("WORD SHOULD CONTAIN MAX 7 ALPHABETS");
            System.exit(0);
        }
        char[] la = new char[n]; int t=1; char temp;
        for(int i = 0; i < n; i++)
            la[i] = word.charAt(i);
        for(int i=1;i<=n;i++)
            t*=i;
        for(int i=0;i<n;i++)
            for(int j=0;j<n-i-1;j++)
                if(la[j]>la[j+1])
                {
                    temp=la[j];
                    la[j]=la[j+1];
                    la[j+1]=temp;
                }
        System.out.print(la);
        for (int i = 1; i < t; i++) 
        {
            int j = n - 1;
            while (la[j - 1] >= la[j]) 
                j--;
            int k = n;
            while (la[j - 1] >= la[k - 1]) 
                k--;
            temp = la[j - 1];
            la[j - 1] = la[k - 1];
            la[k - 1] = temp;
            j++;
            k = n;
            while (j < k) 
            {
                temp = la[j - 1];
                la[j - 1] = la[k - 1];
                la[k - 1] = temp;
                j++;
                k--;
            }
            System.out.print("  ");
            System.out.print(la);
        }
        System.out.println("\nTOTAL ANAGRAMS : " + t);
    }
}
