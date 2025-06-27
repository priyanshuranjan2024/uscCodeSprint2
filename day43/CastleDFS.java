package day43;
import java.util.*;

public class CastleDFS{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=Integer.parseInt(sc.nextLine());
    String[] input=sc.nextLine().trim().split(" ");
    List<List<Integer>> adj=new ArrayList<>();

    for(int i=0;i<n;i++){
      List<Integer> neighbors=new ArrayList<>();
      if(!input[i].isEmpty()){
        for(String s:input[i].split(",")){
          neighbors.add(Integer.parseInt(s.trim()));
        }
      }
      adj.add(neighbors);
    }

    boolean[] visited=new boolean[n];
    List<Integer> result=new ArrayList<>();
    dfs(0,adj,visited,result);

    for(int i=0;i<result.size();i++){
      System.out.print(result.get(i));
      if(i<result.size()-1) System.out.print(", ");
    }
    System.out.println();
    sc.close();
  }

    private static void dfs(int node,List<List<Integer>> adj,boolean[] visited,List<Integer> result){
      visited[node]=true;
      result.add(node);

      for(int neighbor:adj.get(node)){
        if(!visited[neighbor]) dfs(neighbor,adj,visited,result);
      }
    }
}

