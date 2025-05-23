import java.util.Scanner;

public class MinSubarray{
  private static int minSubArrayHelper(int[] sessions,int target){
    int n=sessions.length;
    //instead of brute force i will use sliding window with dynamic size
    int minLength=Integer.MAX_VALUE;
    int start=0;
    int sum=0;

    for(int end=0;end<n;end++){
      sum+=sessions[end];

      while(sum>=target){
        minLength=Math.min(minLength,end-start+1);
        sum-=sessions[start];
        start++;
        
      }
    }

    return (minLength==Integer.MAX_VALUE)?0:minLength;
  }

  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int target=sc.nextInt();
    int n=sc.nextInt();
    int[] sessions=new int[n];
    for(int i=0;i<n;i++) sessions[i]=sc.nextInt();

    int result=minSubArrayHelper(sessions,target);
    System.out.println(result);
    sc.close();
  }
}