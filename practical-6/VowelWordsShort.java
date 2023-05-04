import java.util.Scanner;
public class VowelWordsShort 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER A SENTENCE: ");
        String s = sc.nextLine().toUpperCase();
        if(".?!".indexOf(s.charAt(s.length()-1))==-1)
        {
            System.out.println("INVALID INPUT");
            System.exit(0);
        }
        s = s.substring(0,s.length()-1);
        s = s.replaceAll(" +"," ");
        String words[] = s.split(" ");
        int count = 0;
        String sen = "";
        for(int i=0;i<words.length;i++)
            if("AEIOU".indexOf(words[i].charAt(0))!=-1 && "AEIOU".indexOf(words[i].charAt(words[i].length()-1))!=-1)
            {
                count++;
                sen = sen + words[i]+" ";
            }
        for(int i=0;i<words.length;i++)
            if("AEIOU".indexOf(words[i].charAt(0))==-1 || "AEIOU".indexOf(words[i].charAt(words[i].length()-1))==-1)
                sen = sen + words[i]+" ";
        System.out.println("NUMBER OF WORDS BEGINNING AND ENDING WITH A VOWEL = "+count);
        System.out.println(sen.trim());
    }
}