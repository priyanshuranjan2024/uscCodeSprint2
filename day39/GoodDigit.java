package day39;
import java.util.*;

public class GoodDigit{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(countGood(0,n));
    sc.close();
  }

  private static int countGood(int index,int n){
    if(index==n) return 1;

    int factor=(index%2==0)?5:4;

    return factor*countGood(index+1,n);
  }

  
}