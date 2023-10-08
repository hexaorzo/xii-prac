import java.util.*;
public class DiagonalOscillate 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = sc.nextInt();
        if(n<3)
        {
            System.out.println("n should not be less than 3");
            System.exit(0);
        }
        int[][] arr = new int[n][n];
        int i, j, k = 1;
        for (int l = 0; l < n; l++)
        {
            for (i = 0; i < n; i++)
                for (j = 0; j < n; j++)
                    if (j - i == l)
                        arr[i][j] = k++;
            if (l == 0)
                continue;
            for (i = 0; i < n; i++)
                for (j = 0; j < n; j++)
                    if (i - j == l)
                        arr[i][j] = k++;
        }
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }
    }
}
