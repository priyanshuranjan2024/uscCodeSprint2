package day30;
import java.util.*;

public class Benny{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    sc.close();

    Set<String> visited=new HashSet<>();
    int x=0;
    int y=0;
    int slipCount=0;

    visited.add("0,0");

    for(char move:s.toCharArray()){
      if(move=='L') x--;
      else if(move=='R') x++;
      else if(move=='U') y++;
      else if(move=='D') y--;

      String pos=x+","+y;
      if(visited.contains(pos)) slipCount++;
      else visited.add(pos);
    }

    System.out.println(slipCount);

    
  }
}