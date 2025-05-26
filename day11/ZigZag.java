package day11;
import java.util.*;

public class ZigZag{
  private static List<Integer> zigzagReorder(List<Integer> appointments){

    //using two pointer approach
    List<Integer> result=new ArrayList<>();
    int left=0;
    int right=appointments.size()-1;

    while(left<=right){
      result.add(appointments.get(left));
      left++;
      if(left<=right){
        result.add(appointments.get(right));
        right--;
      }
    }

    return result;
  }

  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    List<Integer> appointments=new ArrayList<>();
    for(int i=0;i<n;i++) appointments.add(sc.nextInt());

    List<Integer> result=zigzagReorder(appointments);

    System.out.println(result);
    sc.close();
  }
}