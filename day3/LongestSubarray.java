package day3;
import java.util.Scanner;

public class LongestSubarray{
  public static void main(String[] args){
    //brute force over each subarray will take O(n^2) time
    //hence use sliding window O(n) time
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++) arr[i]=sc.nextInt();

    int maxLen=1; 
    int start=0; //sliding window pointer

    for(int end=1;end<n;end++){
      if(arr[end]>arr[end-1]) maxLen=Math.max(maxLen,end-start+1);
      else start=end; // slide the window
    }

    System.out.println(maxLen);
    sc.close();
  }
}