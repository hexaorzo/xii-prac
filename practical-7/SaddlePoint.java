import java.util.*;
public class SaddlePoint
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int N = sc.nextInt();
        if(N>=20||N<=0)
        {
            System.out.println("Invalid value of N");
            System.exit(0);
        }
        int[][] A = new int[N][N];
        System.out.println("MATRIX A[][] :");
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
            {
                A[i][j] = sc.nextInt();
                if(A[i][j]<0)
                {
                    System.out.println("Elements must be positive");
                    System.exit(0);
                }
            }
        System.out.println("\nMATRIX A[][] :");
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
                System.out.print(A[i][j]+" ");
            System.out.println();
        }
        int min,max;
        boolean f = false;
        for(int i=0;i<N;i++)
        {
            min = A[i][0];
            for(int j=0;j<N;j++)
                if(A[i][j]<min)
                    min = A[i][j];
            for(int j=0;j<N;j++)
                if(A[i][j]==min)
                {
                    max = A[0][j];
                    for(int k=0;k<N;k++)
                    {
                        if(A[k][j]>max)
                            max = A[k][j];
                        if(A[k][j]<min)
                            min = A[k][j];
                    }
                    if(max==min)
                    {
                        System.out.println("SADDLE POINT = "+max);
                        f = true;
                    }
                }
        }
        if(!f)
            System.out.println("NO SADDLE POINT");
        for(int i=1;i<N;i++)
        {
            int key = A[i][i];
            int j = i-1;
            while(j>=0&&A[j][j]>key)
            {
                A[j+1][j+1] = A[j][j];
                j--;
            }
            A[j+1][j+1] = key;
        }
        System.out.println("\nMATRIX AFTER SORTING THE PRINCIPAL DIAGONAL:");
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
                System.out.print(A[i][j]+" ");
            System.out.println();
        }
    }
}