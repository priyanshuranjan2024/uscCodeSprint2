package day40;
import java.util.*;

public class BinaryGarden{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    sc.close();

    System.out.println(countBST(n));
  }

  private static int countBST(int n){
    if(n<=1) return 1;

    int total=0;
    //assuming that for each i n-1-i nodes are on the right side 
    for(int i=0;i<n;i++){
      total+=countBST(i)*countBST(n-1-i);
    }

    return total;
  }
}