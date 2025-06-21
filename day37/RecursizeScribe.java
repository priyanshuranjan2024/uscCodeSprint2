import java.util.*;

public class RecursizeScribe{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(numberToWords(n));
    sc.close();
  }

  //the arrays for belowTwenty, tens and thousands
  private static final String[] belowTwenty={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
  private static final String[] tens={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
  private static final String[] thousands={"","Thousand","Million","Billion"};

  private static String numberToWords(int num){
    if(num==0) return "Zero";

    int i=0; //for counting thousands
    StringBuilder word=new StringBuilder();

    while(num>0){
      if(num%1000!=0){
        String chunk=helper(num%1000);
        word.insert(0,chunk+(thousands[i].isEmpty()?"":" "+thousands[i])+" ");
      }
      num/=1000;
      i++;
    }

    return word.toString().trim(); //removing extra spaces
    
  }

  private static String helper(int num){
    if(num==0) return "";
    else if(num<20) return belowTwenty[num];
    else if(num<100){
      return tens[num/10]+(num%10!=0?" "+helper(num%10):"");
    }
    else{
      return belowTwenty[num/100]+" Hundred"+(num%100!=0?" "+helper(num%100):"");
    }
  }
 
}