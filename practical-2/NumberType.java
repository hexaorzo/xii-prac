import java.util.*;
public class NumberType
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String n = sc.nextLine();
        int count = 0;
        for(int i = 0; i < n.length(); i++)
            if(n.charAt(i) >= '0' && n.charAt(i) <= '9')
                count++;
        if(count == n.length())
        {
            boolean isIncreasing = true;
            boolean isDecreasing = true;
            for(int i = 0; i < n.length() - 1; i++)
            {
                if(n.charAt(i) > n.charAt(i + 1))
                    isIncreasing = false;
                if(n.charAt(i) < n.charAt(i + 1))
                    isDecreasing = false;
            }
            if(isIncreasing)
                System.out.println(n + " IS AN INCREASING NUMBER");
            if(isDecreasing)
                System.out.println(n + " IS A DECREASING NUMBER");
            if(!isIncreasing && !isDecreasing)
                System.out.println(n + " IS A BOUNCY NUMBER");
        }
        else
            System.out.println("INVALID INPUT");
    }
}
