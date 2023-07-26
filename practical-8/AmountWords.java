import java.util.Scanner;
public class AmountWords 
{
    String word(int n)
    {
        String[] ones = {"","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN","ELEVEN","TWELVE","THIRTEEN","FOURTEEN","FIFTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN"};
        String[] tens = {"","","TWENTY","THIRTY","FOURTY","FIFTY","SIXTY","SEVENTY","EIGHTY","NINTY"};
        if(n<20)
            if(n==0)
                return "ZERO";
            else
                return ones[n];
        else if(n%10==0)
            return tens[n/10];
        else
            return tens[n/10]+" "+ones[n%10];
    }
    public static void main(String[] args)
    {
        AmountWords ob = new AmountWords();
        Scanner sc = new Scanner(System.in);
        System.out.print("Amount = ");
        String amt = sc.next();
        String r="",p="",rs="",ps="",rc="";
        int i=0, n;
        while(i<amt.length()&&amt.charAt(i)!='.')
        {
            r+=amt.charAt(i);
            i++;
        }
        rc=r; i++;
        if(rc.charAt(0)=='-'|| rc.length()>9)
        {
            System.out.println("Amount either negative or more than 9 digits!! Aborting!!");
            System.exit(0);
        }
        while(i<amt.length())
        {
            p+=amt.charAt(i);
            i++;
        }
        while(r.length()<9)
            r="0"+r;
        while(p.length()<2)
            p+="0";
        n = Integer.parseInt(p.substring(0,2));
        ps=ob.word(n);
        String[] place = {"CRORE","LAKH","THOUSAND","HUNDRED",""};
        for(i=0;i<5;i++)
        {
            if(i<3)
                n = Integer.parseInt(r.substring(i*2,i*2+2));
            else if(i==3)
                n = Integer.parseInt(r.substring(i*2,i*2+1));
            else
                n = Integer.parseInt(r.substring(i*2-1));
            
            if(n!=0)
                rs+=ob.word(n)+" "+place[i]+" ";
        }
        System.out.println("Amount = "+rc+"."+p.substring(0,2));
        System.out.println("RUPEES. "+rs.trim()+" AND "+ps+" PAISE ONLY");
    }
}