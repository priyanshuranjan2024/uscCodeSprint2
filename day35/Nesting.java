package day35;
import java.util.*;

public class Nesting{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] packets=new int[n];

    for(int i=0;i<n;i++){
      packets[i]=sc.nextInt();
    }

    System.out.println(minPackets(packets));
    sc.close();
  }

  private static int minPackets(int[] packets){
    Arrays.sort(packets);

    PriorityQueue<Integer> pq=new PriorityQueue<>();
    for(int packet:packets){
      if(!pq.isEmpty() && pq.peek()<packet){
        pq.poll();
      }
      pq.offer(packet);
    }

    return pq.size();
  }
}