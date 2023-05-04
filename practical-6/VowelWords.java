import java.util.Scanner;
public class VowelWords
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
        s=s.substring(0,s.length()-1)+" ";
        int f=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)==' ')
            {
                int j = i+1;
                while(j<s.length() && s.charAt(j)==' ')
                    j++;
                s = s.substring(0,i+1)+s.substring(j);
                f++;
            }
        String sen = "";
        String words[] = new String[f];
        int i=0, j=0, count=0;
        while(i<s.length())
        {
            if(s.charAt(i)==' ')
            {
                words[j++] = sen;
                sen = "";
            }
            else
                sen += s.charAt(i);
            i++;
        }
        for(i=0;i<words.length;i++)
            if("AEIOU".indexOf(words[i].charAt(0))!=-1 && "AEIOU".indexOf(words[i].charAt(words[i].length()-1))!=-1)
            {
                count++;
                sen = sen + words[i]+" ";
            }
        for(i=0;i<words.length;i++)
            if("AEIOU".indexOf(words[i].charAt(0))==-1 || "AEIOU".indexOf(words[i].charAt(words[i].length()-1))==-1)
                sen = sen + words[i]+" ";
        System.out.println("NUMBER OF WORDS BEGINNING AND ENDING WITH A VOWEL = "+count);
        System.out.println(sen.trim());
    }
}