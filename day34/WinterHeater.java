package day34;
import java.util.*;

public class WinterHeater{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] houses=Arrays.stream(sc.nextLine().trim().split(" "))
      .mapToInt(Integer::parseInt)
      .toArray();

    int[] heaters=Arrays.stream(sc.nextLine().trim().split(" "))
      .mapToInt(Integer::parseInt)
      .toArray();

    int result=findRadius(houses,heaters);
    System.out.println(result);
    sc.close();
                               
                               
  }

  private static int findRadius(int[] houses,int[] heaters){
    Arrays.sort(houses);
    Arrays.sort(heaters);
    int radius=0;
    for(int house:houses){
      int idx=Arrays.binarySearch(heaters,house);
      if(idx<0){
        idx=-(idx+1);
      }

      int dist1=idx<heaters.length?Math.abs(heaters[idx]-house):Integer.MAX_VALUE;
      int dist2=idx>0?Math.abs(heaters[idx-1]-house):Integer.MAX_VALUE;

      int minDist=Math.min(dist1,dist2);
      radius=Math.max(radius,minDist);
    }

    return radius;
  }
}