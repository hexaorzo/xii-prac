import java.util.Scanner;
class Salary 
{
    double bs, da, ta, hra, pf, it;
    void set_details()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Basic Salary: Rs. ");
        bs = sc.nextDouble();
        System.out.print("Dearness Allowance (%age): ");
        da = bs*sc.nextDouble()/100;
        System.out.print("Travelling Allowance (%age): ");
        ta = bs*sc.nextDouble()/100;
        System.out.print("House Rent Allowance (%age): ");
        hra = bs*sc.nextDouble()/100;
        System.out.print("Provident Fund (%age): ");
        pf = bs*sc.nextDouble()/100;
        System.out.print("Income Tax (%age): ");
        it = bs*sc.nextDouble()/100;
    }
    double gross_salary()
    {
        return bs+da+ta+hra+pf;
    }
    double net_salary()
    {
        return gross_salary()+it;
    }
}
class Employee extends Salary
{
    String eno, ename, grade, post;
    void set_employee()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEmployee Number: ");
        eno = sc.nextLine();
        System.out.print("Employee Name: ");
        ename = sc.nextLine();
        System.out.print("Employee Grade: ");
        grade = sc.nextLine();
        System.out.print("Employee Post: ");
        post = sc.nextLine();
        set_details();
    }
    void print_employee()
    {
        System.out.println("\nEmployee Number: " + eno);
        System.out.println("Employee Name: " + ename);
        System.out.println("Employee Grade: " + grade);
        System.out.println("Employee Post: " + post);
    }
    void print_payslip()
    {
        System.out.println("\nEmployee Number: " + eno);
        System.out.println("Employee Name: " + ename);
        System.out.println("Basic Salary: Rs. " + bs);
        System.out.println("Dearness Allowance: Rs. " + da);
        System.out.println("Travelling Allowance: Rs. " + ta);
        System.out.println("House Rent Allowance: Rs. " + hra);
        System.out.println("Provident Fund: Rs. " + pf);
        System.out.println("Income Tax: Rs. " + it);
        System.out.println("Gross Salary: Rs." + gross_salary());
        System.out.println("Net Salary: Rs. " + net_salary());
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Employees: ");
        int n = sc.nextInt();
        Employee[] e = new Employee[n];
        for (int i = 0; i < n; i++)
        {
            e[i] = new Employee();
            e[i].set_employee();
        }
        while(true)
        {
            System.out.println("\n1. Print Employee Details");
            System.out.println("2. Print Employee Payslip");
            System.out.println("3. Print Payroll");
            System.out.print("Enter your choice: ");
            char c=sc.next().charAt(0);
            if (c == '1')
            {
                System.out.print("Enter Employee Number: ");
                String en = sc.next();
                boolean f=false;
                for (int i = 0; i < n; i++)
                    if (e[i].eno.equals(en))
                    {
                        e[i].print_employee();
                        f=true;
                    }
                if (!f)
                    System.out.println("Employee not found!");
            }
            else if (c == '2')
            {
                System.out.print("Enter Employee Number: ");
                String en = sc.next();
                boolean f=false;
                for (int i = 0; i < n; i++)
                    if (e[i].eno.equals(en))
                    {
                        e[i].print_payslip();
                        f=true;
                    }
                if (!f)
                    System.out.println("Employee not found!");
            }
            else if (c == '3')
                for (int i = 0; i < n; i++)
                {
                    e[i].print_payslip();
                    System.out.println("________________________________________________");
                }
            else
            {
                System.out.println("Exiting...");
                break;
            }
        } 
    }
}