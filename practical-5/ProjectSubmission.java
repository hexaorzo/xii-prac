import java.util.*;
public class ProjectSubmission
{
    public static void main(String args[])
    {
        int d = 0, m = 0, y = 0;
        String days[] = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
        String months[] = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
        int daysInMonth[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER PROJECT DATE: ");
        String date = sc.nextLine().toUpperCase();
        try
        {
            d = Integer.parseInt(date.substring(0,date.indexOf('/')));
            m = Integer.parseInt(date.substring(date.indexOf('/')+1,date.lastIndexOf('/')));
            y = Integer.parseInt(date.substring(date.lastIndexOf('/')+1));
        }
        catch(Exception e)
        {
            System.out.println("INVALID DATE");
            System.exit(0);
        }
        System.out.print("DAY OF THE WEEK: ");
        String day = sc.next().toUpperCase();
        if(m==2 && y%4==0 && y%100!=0 || y%400==0)
            daysInMonth[1] = 29;
        try
        {
            if(d>daysInMonth[m-1])
            {
                System.out.println("INVALID DATE");
                System.exit(0);
            }
        }
        catch(Exception e)
        {
            System.out.println("INVALID DAY");
            System.exit(0);
        }
        d += 89;
        while(true)
        {
            if (m==2 && y%4==0 && y%100!=0 || y%400==0)
                daysInMonth[1] = 29;
            if(d<=daysInMonth[m-1])
                break;
            d -= daysInMonth[m-1];
            m++;
            if(m>12)
            {
                m = 1;
                y++;
            }
        }
        int i = 0;
        while(!day.equals(days[i]))
            i++;
        i=(i+89)%7;
        System.out.println("PROJECT SUBMISSION DATE: "+d+"/"+m+"/"+y);
        System.out.println("DAY OF THE WEEK: "+days[i]);
        if(i==0)
        {
            d++;
            if(d>daysInMonth[m-1])
            {
                d = 1;
                m++;
                if(m>12)
                {
                    m = 1;
                    y++;
                }
            }
            System.out.println("PROJECT TO BE SUBMITTED: "+d+"/"+m+"/"+y);
            System.out.println("DAY OF THE WEEK: "+days[i+1]);
        }
    }
}