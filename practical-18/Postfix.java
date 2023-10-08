import java.util.Scanner;
public class Postfix
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PostFix Equation : ");
        String eq = sc.nextLine();
        int l = eq.length();
        String[] sa = new String[l];
        for (int i = 0; i < l; i++)
            sa[i] = eq.substring(i, i + 1);
        System.out.println("Enter value of");
        for (int i = 0; i < l; i++)
            if (Character.isLetter(sa[i].charAt(0)))
            {
                String v = sa[i].substring(0,1);
                System.out.print(sa[i] + " : ");
                String s = sc.nextLine();
                for (int j = i; j < l; j++)
                    if (sa[j].equals(v))
                        sa[j] = s;
            }
        int[] ans = new int[l];
        int j = 0;
        for (int i = 0; i < l; i++)
        {
            if (Character.isDigit(sa[i].charAt(0)))
                ans[j] = Integer.parseInt(sa[i]);
            else
            {
                int a = ans[j - 2];
                int b = ans[j - 1];
                j -= 2;
                char c = sa[i].charAt(0);
                if (c=='+')
                    sa[i]="+";
                else if (c=='-')
                    sa[i]="-";
                else if (c=='*')
                    sa[i]="*";
                else if (c=='/')
                    sa[i]="/";
                else if (c=='%')
                    sa[i]="%";
                else if (c=='^')
                    sa[i]="^";
                else
                {
                    System.out.println("Invalid Operator");
                    System.exit(0);
                }
                ans[j+1]=0;
            }
            j++;
        }
        System.out.println("Answer : " + ans[0]);
    }
}