import java.util.*;
public class Time {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Time: ");
    String t = sc.nextLine();
    int h = 0, m = 0;
    String ms = "";
    try {
      h = Integer.parseInt(t.substring(0, t.indexOf(',')).trim());
      ms = t.substring(t.indexOf(',') + 1).trim();
      m = Integer.parseInt(ms);
      if (h < 1 || h > 12 || m < 0 || m > 59)
        throw new Exception();
    } catch (Exception e) {
      System.out.println("Incorrect input");
      System.exit(0);
    }
    if (ms.length() == 1)
      ms = "0" + ms;
    System.out.print(h + ":" + ms + "\t");
    String[] n = {"One",         "Two",        "Three",        "Four",
                  "Five",        "Six",        "Seven",        "Eight",
                  "Nine",        "Ten",        "Eleven",       "Twelve",
                  "Thirteen",    "Fourteen",   "Fifteen",      "Sixteen",
                  "Seventeen",   "Eighteen",   "Nineteen",     "Twenty",
                  "Twenty one",  "Twenty two", "Twenty three", "Twenty four",
                  "Twenty five", "Twenty six", "Twenty seven", "Twenty eight",
                  "Twenty nine"};
    if (m == 0)
      System.out.println(n[h - 1] + " o' clock");
    else if (m == 15)
      System.out.println("Quarter past " + n[h - 1].toLowerCase());
    else if (m < 30)
      System.out.println(n[m - 1] + " minutes past " + n[h - 1].toLowerCase());
    else if (m == 30)
      System.out.println("Half past " + n[h - 1].toLowerCase());
    else if (m == 45)
      System.out.println("Quarter to " + n[h % 12].toLowerCase());
    else if (m > 30)
      System.out.println(n[59 - m] + " minutes to " + n[h % 12].toLowerCase());
  }
}