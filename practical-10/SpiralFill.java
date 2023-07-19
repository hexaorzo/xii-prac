import java.util.*;
public class SpiralFill 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int N = sc.nextInt();
        if(N>10||N<2)
        {
            System.out.println("Infid fue of N");
            System.exit(0);
        }
        int[][] A = new int[N][N];
        int[][] B = new int[N][N];
        int f = 1, k = 0, l = 0, m = N, n = N;
        while (k < m && l < n) 
        {
            for (int i = l; i < n; i++)
                A[k][i] = f++;
            k++;
            for (int i = k; i < m; i++)
                A[i][n - 1] = f++;
            n--;
            if (k < m) 
            {
                for (int i = n - 1; i >= l; i--)
                    A[m - 1][i] = f++;
                m--;
            }
            if (l < n) 
            {
                for (int i = m - 1; i >= k; i--)
                    A[i][l] = f++;
                l++;
            }
        }
        f = 1; k = 0; l = 0; m = N; n = N;
        while (k < m && l < n) 
        {
            for (int i = k; i < m; i++)
                B[i][l] = f++;
            l++;
            for (int i = l; i < n; i++)
                B[m - 1][i] = f++;
            m--;
            if (l < n) 
            {
                for (int i = m - 1; i >= k; i--)
                    B[i][n - 1] = f++;
                n--;
            }
            if (k < m) 
            {
                for (int i = n - 1; i >= l; i--)
                    B[k][i] = f++;
                k++;
            }
        }
        System.out.println("1. Clockwise Spiral Fill");
        System.out.println("2. Anti-Clockwise Spiral Fill");
        System.out.println("Press any other key to exit");
        while(true)
        {
            System.out.print("Enter your choice: ");
            char ch = sc.next().charAt(0);
            switch(ch)
            {
                case '1':
                    for (int i = 0; i < N; i++) 
                    {
                        for (int j = 0; j < N; j++)
                            System.out.print(A[i][j] + "\t");
                        System.out.println();
                    }
                    break;
                case '2':
                    for (int i = 0; i < N; i++) 
                    {
                        for (int j = 0; j < N; j++)
                            System.out.print(B[i][j] + "\t");
                        System.out.println();
                    }
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}