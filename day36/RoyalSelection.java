package day36;
import java.util.*;

public class RoyalSelection{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int r=sc.nextInt();

    System.out.println(nCr(n,r));
    sc.close();
  }

  private static int nCr(int n,int r){
    if(r==0 || r==n) return 1;
    return nCr(n-1,r)+nCr(n-1,r-1);
  }
}