package day35;
import java.util.*;

public class Packaging{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    int[] weight=new int[n];

    int maxWeight=0;
    int totalWeight=0;

    for(int i=0;i<n;i++){
      weight[i]=sc.nextInt();
      maxWeight=Math.max(maxWeight,weight[i]);
      totalWeight+=weight[i];
    }

    int left=maxWeight;
    int right=totalWeight;

    int result=right;
    while(left<=right){
      int mid=left+(right-left)/2;
      if(isPossible(weight,k,mid)){
        result=mid;
        right=mid-1;
      }else{
        left=mid+1;
      }
    }

    System.out.println(result);
    sc.close();

    
  }

  private static boolean isPossible(int[] weight,int k,int maxWeight){
    int currentWeight=0;
    int boxCount=1;

    for(int w:weight){
      if(currentWeight+w<=maxWeight){
        currentWeight+=w;
      }else{
        boxCount++;
        currentWeight=w;

        if(boxCount>k) return false;
      }
    }
    return true;

      
  }
}