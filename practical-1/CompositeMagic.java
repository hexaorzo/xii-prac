import java.util.*;
public class CompositeMagic 
{
    boolean isComposite(int n) 
    {
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return true;
        return false;
    }
    boolean isMagic(int n) 
    {
        int s=0;
        s = n;
        while (s > 9) 
        {
            n = s;
            s = 0;
            while (n > 0) 
            {
                s += n % 10;
                n /= 10;
            }
        }
        if (s==1)
            return true;
        else
            return false;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        CompositeMagic ob = new CompositeMagic();
        System.out.print("m = ");
        int m = sc.nextInt();
        System.out.print("n = ");
        int n = sc.nextInt();
        if(m<n&&m>0&&n>0)
        {
            int f=0;
            for (int i = m; i <= n; i++)
                if (ob.isComposite(i) && ob.isMagic(i)) 
                    f++;
            int freq=f;
            System.out.println("THE COMPOSITE MAGIC INTEGERS ARE:");
            for (int i = m; i <= n; i++) 
                if (ob.isComposite(i) && ob.isMagic(i)) 
                {
                    if(f==1)
                        System.out.print(i);
                    else
                    {
                        System.out.print(i+", ");
                        f--;
                    }  
                }
            System.out.println("\nFREQUENCY OF COMPOSITE MAGIC INTEGERS IS: "+freq);
        }
        else
            System.out.println("INVALID INPUT");
    }
}