import java.util.*;
public class DayOnDate {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] ma = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] da = {"SUNDAY",   "MONDAY", "TUESDAY", "WEDNESDAY",
                   "THURSDAY", "FRIDAY", "SATURDAY"};
    System.out.print("Date : ");
    String s = sc.nextLine();
    int d = 0, m = 0, y = 0;
    try {
      d = Integer.parseInt(s.substring(0, s.indexOf('/')));
      m = Integer.parseInt(s.substring(s.indexOf('/') + 1, s.lastIndexOf('/')));
      y = Integer.parseInt(s.substring(s.lastIndexOf('/') + 1));
    } catch (Exception e) {
      System.out.println("Invalid Date Format");
      System.exit(0);
    }
    if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0)
      ma[1] = 29;
    if (m < 1 || m > 12 || d < 1 || d > ma[m - 1]) {
      System.out.println("Invalid Date");
      System.exit(0);
    }
    System.out.print("Day on 1st January: ");
    String day = sc.next().toUpperCase();
    boolean f = false;
    int i = 0;
    for (i = 0; i < 7; i++)
      if (da[i].equals(day)) {
        f = true;
        break;
      }
    if (!f) {
      System.out.println("Invalid Day");
      System.exit(0);
    }
    for (int j = 1; j < m; j++)
      i = (i + ma[j - 1]) % 7;
    i = (i + d - 1) % 7;
    System.out.println("Day on " + s + " : " + da[i]);
  }
}