package day26;
import java.util.*;

public class Calibration{

  private static int threeSum(int[] arr,int target){
    int n=arr.length;
    Arrays.sort(arr);
    //calculating initial sum
    int closet=arr[0]+arr[1]+arr[2];
    for(int i=0;i<n-2;i++){
      int left=i+1;
      int right=n-1;
      while(left<right){
        int sum=arr[i]+arr[left]+arr[right];
        if(Math.abs(sum-target)<Math.abs(closet-target)) closet=sum;
        else if(Math.abs(sum-target)==Math.abs(closet-target)){
          closet=Math.max(closet,sum);
        }

        if(sum<target) left++;
        else right--;

      }
    }

    return closet;
    
  }

  
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++) arr[i]=sc.nextInt();
    int target=sc.nextInt();

    System.out.println(threeSum(arr,target));
    sc.close();
  }
}