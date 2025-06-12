package day28;
import java.util.*;

public class Festival{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    String result=validString(s);
    System.out.println(result);
    sc.close();
  }

  private static String validString(String s){
    //store the frequency and then store them in maxHeap
    int[] freq=new int[26];
    for(char c:s.toCharArray()){
      freq[c-'a']++;
    }

    PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->b[1]-a[1]);
    for(int i=0;i<26;i++){
      if(freq[i]>0) maxHeap.add(new int[]{i,freq[i]});
    }

    StringBuilder result=new StringBuilder();
    int[] prev={-1,0};

    while(!maxHeap.isEmpty()){
      int[] curr=maxHeap.poll();
      result.append((char)(curr[0]+'a'));
      curr[1]--;
      if(prev[1]>0) maxHeap.add(prev);
      prev=curr;
    }

    return result.length()==s.length()?result.toString():"";

    
  }
}