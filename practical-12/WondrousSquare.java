import java.util.*;
public class WondrousSquare 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("N = ");
        int n=sc.nextInt();
        if(n<2||n>10)
        {
            System.out.print("Invalid input");
            System.exit(0);
        }
        int a[][]=new int[n][n];
        System.out.println("Enter elements of matrix: ");
        for(int i=0;i<n;i++)
            for( int j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
                if(a[i][j]<0)
                {
                    System.out.println("Invalid input");
                    System.exit(0);
                }
            }
        int num=1;
        boolean flag=true;
        while(num<=n*n)
        {
            int occ=0;
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    if(a[i][j]==num)
                        occ++;
            if(occ!=1)
            {
                flag=false;
                break;
            }
			num++;
        }
        int tsum=(int) (0.5*n*(Math.pow(n,2)+1));
        int j=0;
        int sumr=0,sumc=0;
        for(int i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                sumr=sumr+a[i][j];
                sumc=sumc+a[j][i];
            }
            if(sumr!=tsum||sumc!=tsum)
            {
                flag=false;
                break;
            }
            sumr=0; sumc=0;
        }
        if(flag==true)
          System.out.println("YES IT REPRESENTS A WONDROUS SQUARE");
        else
            System.out.println("NOT A WONDROUS SQUARE");
        System.out.println("PRIME\tROW INDEX\tCOLUMN INDEX");
        int c;
        int m=(int) Math.pow(n,2);
        a:
        for(int k=2;k<=m;k++)
        {
            c=0;
            for(int l =1;l<=k;l++)
				if(k%l==0)
					c++;
            if(c==2)
                for(int i=0;i<n;i++)
                    for( j=0;j<n;j++)
                        if(a[i][j]==k)
                        {
                                System.out.println(a[i][j]+"\t"+i+"\t\t"+j);
                                continue a;
                        }
        }
    }
}