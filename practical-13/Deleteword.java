import java.util.*;
public class Deleteword
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the sentence: ");
        String str=sc.nextLine().toUpperCase().trim();
        System.out.print("Enter word to be deleted: ");
        String wrd=sc.next().toUpperCase();
        System.out.print("Enter position of word: ");
        int pos=sc.nextInt();
        int n=str.length();
        char c=str.charAt(n-1);
        if(c!='.'&&c!='?'&&c!='!')
        {
            System.out.println("Invalid input");
            System.exit(0);
        }
        for(int i=1;i<str.length()-1;i++)
        {
            char ch=str.charAt(i);
            while(ch==' '&&str.charAt(i+1)==' ')
                str=str.substring(0,i)+str.substring(i+1);
        } 
        System.out.println(str);
        String wr="";
        int ind=0;
        str = str.substring(0,str.length()-1)+" ";
        int j=0;
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch!=' ')
                wr=wr+ch;
            if((pos-1)==ind&&wr.equals(wrd)&&Character.isLetter(str.charAt(i+1))==false)
            {
                str=str.substring(0,j-1)+str.substring(i+1);
                break;
            }
            if(Character.isLetter(ch)==false)
            {
                if(ch!=' ')
                    i++;
                ind++;
                wr="";
                j=i+1;
            }
        }
        str=str.trim()+c;
        System.out.println(str);
    }
}