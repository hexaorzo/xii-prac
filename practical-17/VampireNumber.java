import java.util.Scanner;
class VampireNumber
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number : ");
        int n = sc.nextInt();
        String s = Integer.toString(n);
        int l = s.length();
        if(l%2!=0)
        {
            System.out.println("INVALID!! Please input even digits number");
            System.exit(0);
        }
        char c[] = new char[l];
        for(int i=0;i<l;i++)
            c[i]=s.charAt(i);
        for(int i=0;i<l;i++)
            for(int j=0;j<l-1;j++)
                if(c[j]>c[j+1])
                {
                    char t = c[j];
                    c[j]=c[j+1];
                    c[j+1]=t;
                }
        String combs = "";
        boolean f = false;
        for(int i = 2; i<=n/2;i++)
        {
            int j=n/i;
            if(i*j==n && i<=j)
            {
                if(Integer.toString(i).length()!=l/2 || Integer.toString(j).length()!=l/2)
                    continue;
                String p = Integer.toString(i) + Integer.toString(j);
                char d[] = new char[l];
                for(int k=0;k<l;k++)
                    d[k]=p.charAt(k);
                for(int k=0;k<l;k++)
                    for(int m=0;m<l-1;m++)
                        if(d[m]>d[m+1])
                        {
                            char t = d[m];
                            d[m]=d[m+1];
                            d[m+1]=t;
                        }
                for(int k=0;k<l;k++)
                    if(c[k]!=d[k])
                        break;
                    else if(k==l-1)
                    {
                        f=true;
                        combs += i+" x "+j+"\n";
                    }
            }
        }
        if(f)
        {
            System.out.println(n+" is vampire number");
            System.out.println("Combinations :\n"+combs);
        }
        else
            System.out.println(n+" is not vampire number");
    }   
}