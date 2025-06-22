package day38;
import java.util.*;

public class BinaryTree{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    System.out.println(getSymbol(n,k));
    sc.close();
  }

  private static int getSymbol(int n,int k){
    if(n==1) return 0;

    int mid=(int)Math.pow(2,n-1)/2;

    if(k<=mid) return getSymbol(n-1,k);
    else return 1-getSymbol(n-1,k-mid);
    
  }
}