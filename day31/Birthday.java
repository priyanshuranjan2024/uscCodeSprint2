package day31;
import java.util.*;

public class Birthday{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] cards=new int[n];
    for(int i=0;i<n;i++) cards[i]=sc.nextInt();

    //use a set to keep track of unique pairs
    Set<String> uniquePairs=new HashSet<>();

    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(i!=j && cards[i]>cards[j]){
          String pair=cards[i]+","+cards[j];
          uniquePairs.add(pair);
        }
      }
    }

    //return the size of the set 
    System.out.println(uniquePairs.size());
    sc.close();
  }
}