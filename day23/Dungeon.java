package day23;
import java.util.*;

public class Dungeon{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] nums=Arrays.stream(sc.nextLine().trim().split(" "))
      .mapToInt(Integer::parseInt)
      .toArray();

    int k=Integer.parseInt(sc.nextLine().trim());
    System.out.println(maxScore(nums,k));
    sc.close();
  }

  private static int maxScore(int[] nums,int k){
    int n=nums.length;
    //initialize the dp array
    int[] dp=new int[n];
    dp[0]=nums[0];
    Deque<Integer> deque=new ArrayDeque<>();
    deque.add(0); //this is the index

    for(int i=1;i<n;i++){
      while(!deque.isEmpty() && deque.peekFirst()<i-k) deque.pollFirst();
      dp[i]=nums[i]+dp[deque.peekFirst()];
      while(!deque.isEmpty() && dp[deque.peekLast()]<=dp[i]) deque.pollLast();

      deque.add(i);
    }

    return dp[n-1];
  }
}
