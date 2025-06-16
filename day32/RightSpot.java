package day32;
import java.util.*;
//will use binary search since the array is sorted
//and we have to search efficiently

public class RightSpot{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] nums=Arrays.stream(sc.nextLine().trim().split(" "))
      .mapToInt(Integer::parseInt)
      .toArray();

    int target=sc.nextInt();

    System.out.println(findRightSpot(nums,target));
    sc.close();
  }

  private static int findRightSpot(int[] nums,int target){
    int left=0;
    int right=nums.length-1;
    while(left<=right){
      int mid=left+(right-left)/2;
      if(nums[mid]==target) return mid;
      else if(nums[mid]<target) left=mid+1;
      else right=mid-1;
    }

    return left;
  }
}