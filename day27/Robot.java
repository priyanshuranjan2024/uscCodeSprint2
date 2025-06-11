package day27;
import java.util.*;

//relative ranks

public class Robot{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] score=Arrays.stream(sc.nextLine().trim().split(" "))
      .mapToInt(Integer::parseInt)
      .toArray();

    String[] rank=findRank(score);
    System.out.println(Arrays.toString(rank));
    sc.close();
  }

  private static String[] findRank(int[] score){
    int n=score.length;
    int[][] scoreIndex=new int[n][2];
    for(int i=0;i<n;i++){
      scoreIndex[i][0]=score[i];
      scoreIndex[i][1]=i;
    }

    String[] result=new String[n];

    //now sort it in decreasing order according to scores
    Arrays.sort(scoreIndex,(a,b)->b[0]-a[0]);

    for(int i=0;i<n;i++){
      int index=scoreIndex[i][1];
      
      if(i==0) result[index]="Gold Medal";
      else if(i==1) result[index]="Silver Medal";
      else if(i==2) result[index]="Bronze Medal";
      else result[index]=String.valueOf(i+1);
    }

    return result;

    
  }
}