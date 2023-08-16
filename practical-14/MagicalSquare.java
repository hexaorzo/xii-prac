import java.util.Scanner;
public class MagicalSquare 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int n = sc.nextInt();
        if(n % 2 == 0)
        {
            System.out.println("INVALID. ORDER IS EVEN.");
            System.exit(0);
        }
        int[][] a = new int[n][n];
        int i = n/2, j = n-1;
        for (int k = 1; k <= n * n; k++)
        {
            a[i][j] = k;
            if (a[(i - 1 + n) % n][(j + 1) % n] == 0)
            {
                i = (i-1+n) % n;
                j = (j+1) % n;
            }
            else
                j = (j-1+n) % n;
        }
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
                System.out.print(a[i][j] + "\t");
            System.out.println();
        }
        System.out.println("Sum = " + (int)(0.5*n*(n*n+1)));
    }
}