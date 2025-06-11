package day27;
import java.util.*;

public class Kavya{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] nums=Arrays.stream(sc.nextLine().trim().split(" "))
      .mapToInt(Integer::parseInt)
      .toArray();

    int[] result=findDuplicateMissing(nums);
    System.out.println(Arrays.toString(result));
    sc.close();
  }

  private static int[] findDuplicateMissing(int[] nums){
    //using a frequency map for both the thing
    int n=nums.length;
    int[] freq=new int[n+1]; //for 1 to n 

    int duplicate=-1;
    for(int num:nums){
      freq[num]++;
      if(freq[num]==2) duplicate=num;
    }

    // the number with 0 frequency is missing
    int missing=-1;
    for(int i=1;i<=n;i++){
      if(freq[i]==0) missing=i;
    }

    return new int[]{duplicate,missing};
    
  }
}