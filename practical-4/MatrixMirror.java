import java.util.*;
public class MatrixMirror
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("M = ");
        int M = sc.nextInt();
        System.out.print("N = ");
        int N = sc.nextInt();
        if(M>2&&M<10&&N>2&&N<10)
        {
            int[][] A = new int[M][N];
            System.out.println("Enter the elements of the matrix:");
            for(int i=0; i<M; i++)
                for(int j=0; j<N; j++)
                {
                    if (!sc.hasNextInt())
                    {
                        System.out.println("INVALID INPUT");
                        System.exit(0);
                    }
                    A[i][j] = sc.nextInt();
                }
            System.out.println("ORIGINAL MATRIX");
            for(int i=0; i<M; i++)
            {
                for(int j=0; j<N; j++)
                    System.out.print(A[i][j] + "\t");
                System.out.println();
            }
            int[][] mir = new int[M][N];
            for(int i=0; i<M; i++)
                for(int j=0; j<N; j++)
                    mir[i][j] = A[i][N-j-1];
            System.out.println("MIRROR MATRIX");
            for(int i=0; i<M; i++)
            {
                for(int j=0; j<N; j++)
                    System.out.print(mir[i][j] + "\t");
                System.out.println();
            }
            int sum = A[0][0] + A[0][N-1] + A[M-1][0] + A[M-1][N-1];
            System.out.println("SUM OF THE CORNER ELEMENTS = " + sum);
        }
        else
            System.out.println("INVALID INPUT");
    }
}
