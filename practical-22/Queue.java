import java.util.*;
class Queue 
{
    String Q[]; int f, r, s;
    Queue(int n)
    {
        s = n;
        Q = new String[s];
        f = r = -1;
    }
    void push(String x)
    {
        if (r == s - 1)
            System.out.println("Queue Overflow");
        else
        {
            if (f == -1)
            {
                f = r = 0;
            }
            else
                r++;
            Q[r] = x;
        }
    }
    void pop()
    {
        if (f == -1 && r == -1)
            System.out.println("Queue Underflow");
        else
        {
            System.out.println("Deleted: " + Q[f]);
            if (f == r)
                f = r = -1;
            else
                f++;
        }
    }
    void display()
    {
        if (f == -1 && r == -1)
            System.out.println("Queue is empty");
        else
        {
            System.out.println("Queue: ");
            for (int i = f; i <= r; i++)
                System.out.print(Q[i] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of queue: ");
        int n = sc.nextInt();
        Queue q = new Queue(n);
        System.out.println("1. Insert an element");
        System.out.println("2. Delete an element");
        System.out.println("3. Display the elements");
        while (true)
        {
            System.out.print("\nEnter choice: ");
            char c = sc.next().charAt(0);
            if(c=='1')
            {
                System.out.print("Enter element: ");
                String x = sc.next();
                q.push(x);
            }
            else if(c=='2')
                q.pop();
            else if(c=='3')
                q.display();
            else
                break;
        }
    }
}