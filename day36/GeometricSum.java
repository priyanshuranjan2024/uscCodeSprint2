package day36;
import java.util.*;

public class GeometricSum{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    double result=geometricSum(n);
    System.out.printf("%.5f\n",result);
  }

  private static double geometricSum(int n){
    if(n==1) return 1.0;
    return Math.pow(1.0/3.0,n-1)+geometricSum(n-1);
  }
}