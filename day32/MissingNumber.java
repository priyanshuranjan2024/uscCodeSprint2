package day32;
import java.util.*;

public class MissingNumber{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] nums=Arrays.stream(sc.nextLine().trim().split(" "))
      .mapToInt(Integer::parseInt)
      .toArray();

    int n=nums.length;
    int expectedSum=n*(n+1)/2;
    int actualSum=0;
    for(int num:nums){
      actualSum+=num;
    }

    System.out.println(expectedSum-actualSum);
    sc.close();
  }
}