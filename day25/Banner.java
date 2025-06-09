package day25;
//logic is to sort the the numbers after converting them into String
//using custom comparator a+b to b+a 
import java.util.*;

public class Banner{

  private static String largestNumber(int[] nums){
    //firstly convert it into String
    String[] strNums=new String[nums.length];
    for(int i=0;i<nums.length;i++){
      strNums[i]=String.valueOf(nums[i]);
    }

    //sort using custom comparator
    Arrays.sort(strNums,(a,b)->(b+a).compareTo(a+b));

    //if largest number is 0 return 0
    if(strNums[0].equals("0")) return "0";

    StringBuilder result=new StringBuilder();
    for(String str:strNums) result.append(str);
    return result.toString();
    
    
  }
  
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] num=new int[n];
    for(int i=0;i<n;i++) num[i]=sc.nextInt();
    System.out.println(largestNumber(num));
    sc.close();
    
  }
}