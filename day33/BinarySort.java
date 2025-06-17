package day33;
import java.util.*;

public class BinarySort{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    String s=sc.next();
    char[] arr=s.toCharArray();

    int left=0;
    int right=n-1;
    int operations=0;
    while(left<right){
      while(left<n && arr[left]=='0') left++;
      while(right>=0 && arr[right]=='1') right--;
      if(left<right){
        operations++;
        left++;
        right--;
      }
    }

    System.out.println(operations);
    sc.close();
  }
}