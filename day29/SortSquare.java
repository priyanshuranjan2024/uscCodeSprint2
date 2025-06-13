package day29;
import java.util.*;

public class SortSquare{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] arr=Arrays.stream(sc.nextLine().trim().split(" "))
      .mapToInt(Integer::parseInt)
      .toArray();

    int n=arr.length;

    int[] result=new int[n];

    int left=0;
    int right=n-1;
    int pos=n-1;

    while(left<=right){
      int leftSq=arr[left]*arr[left];
      int rightSq=arr[right]*arr[right];

      if(leftSq>rightSq){
        result[pos--]=leftSq;
        left++;
      }else{
        result[pos--]=rightSq;
        right--;
      }
    }
    
    System.out.println(Arrays.toString(result));
    sc.close();    
  }
}