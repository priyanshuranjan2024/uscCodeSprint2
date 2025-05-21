package day6;
import java.util.*;

public class Jewel{
  public static void main(String[] args){
    //using nested loop will cause O(nm) solution but space complexity is O(1)
    //but using set to store jewels string then it will have faster search time
    //O(1) so O(m+n) but space O(m)

    Scanner sc=new Scanner(System.in);
    String[] input=sc.nextLine().split(" ");
    String jewels=input[0]; //for same line input
    String stones=input[1]; //for same line input

    HashSet<Character> set=new HashSet<>();
    for(char c:jewels.toCharArray()) set.add(c);

    int count=0; //this will be the answer
    for(char c:stones.toCharArray()){
      if(set.contains(c)) count++;
    }

    System.out.println(count);
    sc.close();
    
  }
}