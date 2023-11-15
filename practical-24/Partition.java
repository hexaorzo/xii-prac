import java.util.*;
class Partition 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        part(n, n, "");
    }
    static void part(int n, int m, String p) 
    {
        if (n == 0) 
        {
            System.out.println(p);
            return;
        }
        for (int i = Math.min(m, n); i >= 1; i--) 
            part(n-i, i, p + i + " " );
    }
}