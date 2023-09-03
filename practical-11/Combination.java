import java.util.*;
public class Combination
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int n = sc.nextInt();
        int m = (int)Math.pow(2, n);
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) 
        {
            int k = i;
            for (int j = n - 1; j >= 0; j--) 
            {
                if (k % 2 == 0)
                    a[i][j] = j+1;
                else
                    a[i][j] = -(j+1);
                k /= 2;
            }
        }
        int f = 0;
        for (int i = 0; i < m; i++) 
        {
            int sum = 0;
            for (int j = 0; j < n; j++) 
                sum += a[i][j];
            if (sum == 0) 
            {
                for (int j = 0; j < n; j++) 
                    System.out.print(a[i][j] + "\t");
                System.out.println();
                f++;
            }
        }
        System.out.println("Total number of combinations = " + f);
    }
}