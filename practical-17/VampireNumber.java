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
        char c[] = new char[l];             //extracting digits to array
        for(int i=0;i<l;i++)
            c[i]=s.charAt(i);
        for(int i=0;i<l;i++)                //sorting digits
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
            int j=n/i;                      //calculating factors              
            if(i*j==n && i<=j)              //checking if factors are valid and first factor is less than second
            {
                if(Integer.toString(i).length()!=l/2 || Integer.toString(j).length()!=l/2)          //checking if factors have half digits of original number
                    continue;
                String p = Integer.toString(i) + Integer.toString(j);       //combining digits of factors
                char d[] = new char[l];
                for(int k=0;k<l;k++)        //extracting digits to array
                    d[k]=p.charAt(k);
                for(int k=0;k<l;k++)        //sorting digits
                    for(int m=0;m<l-1;m++)
                        if(d[m]>d[m+1])
                        {
                            char t = d[m];
                            d[m]=d[m+1];
                            d[m+1]=t;
                        }
                for(int k=0;k<l;k++)        //comparing digits
                    if(c[k]!=d[k])          //if any digit is not same
                        break;
                    else if(k==l-1)         //if all digits are same
                    {
                        f=true;
                        combs += i+" x "+j+"\n";
                    }
            }
        }
        if(f)                               //if any combination is found
        {
            System.out.println(n+" is vampire number");
            System.out.println("Combinations :\n"+combs);
        }
        else
            System.out.println(n+" is not vampire number");
    }   
}