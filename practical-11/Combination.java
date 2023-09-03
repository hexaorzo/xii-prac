import java.util.*;
public class Combination
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int n = sc.nextInt();
        int m = (int)Math.pow(2, n);
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = (i+1);
        int f = 0;
        for (int i = 0; i < m; i++) 
        {
            int sum = 0;
            for (int j = 0; j < n; j++) 
                sum += a[j];
            if (sum == 0) 
            {
                for (int j = 0; j < n; j++) 
                    System.out.print(a[j] + "\t");
                System.out.println();
                f++;
            }
            for (int j = n-1; j >= 0; j--)
            {
                a[j] = -a[j];
                if (a[j] < 0)
                    break;
            }
        }
        System.out.println("Total number of combinations = " + f);
    }
}