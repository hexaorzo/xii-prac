import java.util.*;
public class AmountWords 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Amount = ");
        double a = sc.nextDouble();
        if(a<0)
        {
            System.out.println("Amount must be positive");
            System.exit(0);
        }
        int r = (int)a;
        int p = (int)Math.round((a-r)*100);
        System.out.print("Amount = "+r+"."+p);
        if(p==0)
            System.out.print("0");
        String[] ones = {"","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
        String[] tens = {"","","TWENTY","THIRTY","FOURTY","FIFTY","SIXTY","SEVENTY","EIGHTY","NINTY"};
        String[] teens = {"TEN","ELEVEN","TWELVE","THIRTEEN","FOURTEEN","FIFTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN"};
        String[] places = {"","THOUSAND","LAKH","CRORE"};
        String[] words = new String[4];
        int i=0;
        while(r>0)
        {
            int d = r%1000;
            r/=1000;
            if(d>99)
            {
                words[i] = ones[d/100]+" HUNDRED ";
                d%=100;
            }
            if(d>9&&d<20)
            {
                words[i] += teens[d-10]+" ";
                d = 0;
            }
            if(d>19)
            {
                words[i] += tens[d/10]+" ";
                d%=10;
            }
            if(d>0)
                words[i] += ones[d]+" ";
            if(i>0&&words[i].length()>0)
                words[i] += places[i]+" ";
            i++;
        }
        String ans = "";
        for(int j=i-1;j>=0;j--)
            ans += words[j];
        if(ans.length()==0)
            ans = "ZERO ";
        String paise = "";
        String[] wordsp = new String[2];
        int k=0;
        while(p>0)
        {
            int d = p%100;
            p/=100;
            if(d>9&&d<20)
            {
                wordsp[k] += teens[d-10]+" ";
                d = 0;
            }
            if(d>19)
            {
                wordsp[k] += tens[d/10]+" ";
                d%=10;
            }
            if(d>0)
                wordsp[k] += ones[d]+" ";
            k++;
        }
        for(int j=k-1;j>=0;j--)
            paise += wordsp[j];
        if(paise.length()==0)
            paise = "ZERO ";
        ans = ans.replaceAll("null", "");
        paise = paise.replaceAll("null", "");
        System.out.println("\nRUPEES. "+ans+"AND "+paise+"PAISE ONLY");
    }
}