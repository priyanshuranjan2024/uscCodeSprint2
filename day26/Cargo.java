package day26;
import java.util.*;

public class Cargo{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Integer[] arr=new Integer[n];
    for(int i=0;i<n;i++) arr[i]=sc.nextInt();

    //will use custom comparator to sort the problem
    //create a map
    Map<Integer,Integer> freqMap=new HashMap<>();
    for(int num:arr){
      freqMap.put(num,freqMap.getOrDefault(num,0)+1);
    }

    //sorting
    Arrays.sort(arr,(a,b)->{
      int freqA=freqMap.get(a);
      int freqB=freqMap.get(b);
      if(freqA!=freqB){
        //descending order
        return freqB-freqA;
      }else{
        return a-b; //increasing order
      }
    });

    //printing the result
    for(int num:arr){
      System.out.print(num+" ");
    }
    System.out.println();
    sc.close();
    
  }
}