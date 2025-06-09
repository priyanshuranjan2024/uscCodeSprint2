package day25;
import java.util.*;

public class ThreeSum{

  private static boolean treasureFunction(int[] arr,int target){
    int n=arr.length;
    Arrays.sort(arr);
    for(int i=0;i<n-2;i++){
      int left=i+1;
      int right=n-1;
      while(left<right){
        int sum=arr[i]+arr[left]+arr[right];
        if(sum==target) return true;
        else if(sum<target) left++;
        else right--;
      }
    }

    return false;
  }
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++) arr[i]=sc.nextInt();
    int target=sc.nextInt();

    System.out.println(treasureFunction(arr,target));
    sc.close();

    

    }
  
}