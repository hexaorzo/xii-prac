import java.io.*;
public class InsertWord
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("ENTER A SENTENCE:\n");
        String s = br.readLine().toUpperCase();
        if(".?!".indexOf(s.charAt(s.length()-1))!=-1)
        {
            System.out.print("WORD TO BE INSERTED: ");
            String word = br.readLine().toUpperCase();
            System.out.print("WORD POSITION IN THE SENTENCE: ");
            int pos = Integer.parseInt(br.readLine());
            for(int i=0;i<s.length();i++)   // this loop can be replaced by s = s.replaceAll(" +"," ");
                if(s.charAt(i)==' ')
                {
                    int j = i+1;
                    while(j<s.length() && s.charAt(j)==' ')
                        j++;
                    s = s.substring(0,i+1)+s.substring(j);
                }
            StringBuffer sb = new StringBuffer(s);
            sb.insert(sb.length()-1,' ');
            int i = 0, j = 0;
            while(i<pos-1)
            {
                if(sb.charAt(j)==' ')
                    i++;
                j++;
            }
            sb.insert(j,word+" ");
            sb.deleteCharAt(sb.length()-2);
            System.out.println("NEW SENTENCE:\n"+sb);
        }
        else
            System.out.println("INVALID SENTENCE");
    }
}