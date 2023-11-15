import java.util.*;
public class Anagram {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("ENTER A WORD : ");
    String word = sc.next().toUpperCase();
    int n = word.length();
    if (n > 9) {
      System.out.println("WORD SHOULD CONTAIN MAX 9 ALPHABETS");
      System.exit(0);
    }
    char[] la = new char[n + 1];
    int t = 0, n1 = 0, n2 = 0;
    for (int i = 1; i <= n; i++) {
      la[i] = word.charAt(i - 1);
      n1 = n1 * 10 + i;
      n2 = n2 * 10 + (n - i + 1);
    }
    System.out.println("ANAGRAMS OF " + word + " ARE : ");
    for (int i = n1; i <= n2; i++) {
      boolean f = true;
      String num = Integer.toString(i);
      for (int j = 1; j <= n; j++) {
        if (num.indexOf(48 + j) == -1) {
          f = false;
          break;
        }
        if (!(num.indexOf(48 + j) == num.lastIndexOf(48 + j))) {
          f = false;
          break;
        }
      }
      if (f) {
        for (int k = 0; k < n; k++)
          System.out.print(la[(int)(num.charAt(k) - 48)]);
        System.out.print(" ");
        t++;
      }
    }
    System.out.println("\nTOTAL ANAGRAMS : " + t);
  }
}
