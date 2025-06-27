package day43;
import java.util.*;

public class CastleBFS{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=Integer.parseInt(sc.nextLine());

    String[] input=sc.nextLine().trim().split(" ");
    List<List<Integer>> adj=new ArrayList<>();

    for(int i=0;i<n;i++){
      List<Integer> neighbours=new ArrayList<>();
      if(!input[i].isEmpty()){
        for(String s:input[i].split(",")){
          neighbours.add(Integer.parseInt(s.trim()));
        } 
      }
      adj.add(neighbours);
    }

    List<Integer> result=bfs(0,n,adj);

    for(int i=0;i<result.size();i++){
      System.out.print(result.get(i));
      if(i<result.size()-1){
        System.out.print(", ");
      }
    }
    System.out.println();
    sc.close();
  }

  private static List<Integer> bfs(int start,int n,List<List<Integer>> adj){
    boolean[] visited=new boolean[n];

    Queue<Integer> queue=new LinkedList<>();
    List<Integer> order=new ArrayList<>();

    queue.offer(start);
    visited[start]=true;


    while(!queue.isEmpty()){
      int current=queue.poll();
      order.add(current);
      for(int neighbour:adj.get(current)){
        if(!visited[neighbour]){
          visited[neighbour]=true;
          queue.offer(neighbour);
        }
      }
    }

    return order;
    
  }




































  
}