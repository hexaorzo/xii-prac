import java.util.Scanner;
public class Anagram 
{
    static void anagram(String w, String a)
    {
        if(w.length() == 0)
        {
            System.out.print(a + " ");
            return;
        }
        for(int i=0; i<w.length(); i++)
        {
            char ch = w.charAt(i);
            String ls = w.substring(0, i);
            String rs = w.substring(i + 1);
            String s = ls + rs;
            anagram(s, a + ch);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER A WORD : ");
        String word = sc.next().toUpperCase();
        int n = word.length();
        System.out.println("ANAGRAMS OF " + word + " ARE : ");
        anagram(word, "");
    }
}