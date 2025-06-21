import java.util.*;

public class PowerOfTwo{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(helper(n));
    sc.close();
  }

  private static boolean helper(int num){
    if(num<=0) return false;
    if(num==1) return true;

    if(num%2!=0) return false;
    return helper(num/2);
  }
}