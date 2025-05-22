package day7;
import java.util.Scanner;

public class Stock{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();

    int[] prices=new int[n];
    for(int i=0;i<n;i++) prices[i]=sc.nextInt();

    int result=maxProfit(prices);
    System.out.println(result);
    sc.close();
    
  }

    private static int maxProfit(int[] prices){

      int maxMargin=0;
      int minPrice=prices[0];

      for(int i=1;i<prices.length;i++){
        int currentProfit=prices[i]-minPrice;

        maxMargin=Math.max(maxMargin,currentProfit);
        minPrice=Math.min(minPrice,prices[i]);
        
      }

      return (maxMargin>=2)?maxMargin:0;
    }
}