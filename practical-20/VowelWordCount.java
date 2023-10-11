import java.util.Scanner;
public class VowelWordCount 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Sentences : ");
        String s = " " + sc.nextLine().toUpperCase().trim();
        int[][] a = new int[10][2];
        int i=0, j=0;
        for (i = 0; i < s.length(); i++)
        {
            if (".!?".indexOf(s.charAt(i)) != -1)
            {
                j++;
                continue;
            }
            if ("AEIOU".indexOf(s.charAt(i)) != -1)
                a[j][0]++;
            if (s.charAt(i) == ' ')
                a[j][1]++;
        }
        System.out.println("\nSentence\tNo. of vowels\tNo. of words");
        for (i = 0; i < j; i++)
            System.out.println((i + 1) + "\t\t" + a[i][0] + "\t\t" + a[i][1]);
        System.out.println("\nSentence\tNo. of vowels/words");
        for (i = 0; i < j; i++)
        {
            System.out.print((i + 1) + "\t\t");
            for (int k = 0; k < a[i][0]; k++)
                System.out.print("v v v ");
            System.out.print("\n\t\t");
            for (int k = 0; k < a[i][1]; k++)
                System.out.print("w w w ");
            System.out.println();
        }
    }
}