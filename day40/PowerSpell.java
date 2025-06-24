package day40;
import java.util.*;

public class PowerSpell{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    double x=sc.nextDouble();
    int n=sc.nextInt();
    sc.close();

    double result=power(x,n);
    System.out.printf("%.5f\n",result); //till 5 decimal points
    
  }

  private static double power(double x,int n){
    if(n==0) return 1;

    if(n<0) return 1/power(x,-n);

    double half=power(x,n/2);

    if(n%2==0) return half*half;
    else return x*half*half;
    
  }
}