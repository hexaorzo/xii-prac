import java.util.*;
public class SaddlePoint 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int N = sc.nextInt();
        if (N >= 20 || N <= 0) 
        {
            System.out.println("Invalid value of N");
            System.exit(0);
        }
        int[][] A = new int[N][N];
        System.out.println("MATRIX A[][] :");
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) 
            {
                A[i][j] = sc.nextInt();
                if (A[i][j] < 0) 
                {
                    System.out.println("Elements must be positive");
                    System.exit(0);
                }
            }
        System.out.println("\nMATRIX A[][] :");
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++)
                System.out.print(A[i][j] + "\t");
            System.out.println();
        }
        boolean f=false;
        for (int i = 0; i < N; i++) 
        {
            int min_row = A[i][0], col_ind = 0;
            for (int j = 1; j < N; j++) 
            {
                if (min_row > A[i][j]) 
                {
                    min_row = A[i][j];
                    col_ind = j;
                }
            }
            int k;
            for (k = 0; k < N; k++)
                if (min_row < A[k][col_ind])
                    break;
            if (k == N) 
            {
                System.out.println("SADDLE POINT = " + min_row);
                f=true;
            }
        }
        if(!f)
            System.out.println("NO SADDLE POINT");
        for (int i = 1; i < N; i++) 
        {
            int key = A[i][i];
            int j = i - 1;
            while (j >= 0 && A[j][j] > key) 
            {
                A[j + 1][j + 1] = A[j][j];
                j--;
            }
            A[j + 1][j + 1] = key;
        }
        System.out.println("\nMATRIX AFTER SORTING THE PRINCIPAL DIAGONAL:");
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++)
                System.out.print(A[i][j] + "\t");
            System.out.println();
        }
    }
}