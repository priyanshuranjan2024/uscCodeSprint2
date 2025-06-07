package day23;
import java.util.*;

public class Dota{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String senate=sc.nextLine();
    System.out.println(predictWinner(senate));
    sc.close();
  }

  private static String predictWinner(String senate){
    int n=senate.length();
    //initializing two queues
    Queue<Integer> radiant=new LinkedList<>();
    Queue<Integer> dire=new LinkedList<>();

    for(int i=0;i<n;i++){
      if(senate.charAt(i)=='R') radiant.offer(i);
      else dire.offer(i);
    }

    while(!radiant.isEmpty() && !dire.isEmpty()){
      int rIndex=radiant.poll();
      int dIndex=dire.poll();

      if(rIndex<dIndex) radiant.offer(rIndex+n);
      else dire.offer(dIndex+n);
    }

    return (radiant.isEmpty())?"Dire":"Radiant";
    
  }
}