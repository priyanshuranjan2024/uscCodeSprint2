package day19;
import java.util.*;

public class GiftTower{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=Integer.parseInt(sc.nextLine());

    Stack<String> tower=new Stack<>();
    Map<String,Integer> freqMap=new HashMap<>();

    boolean isFirstOutput=true;

    while(n>0){
      String[] input=sc.nextLine().split(" ");
      String command=input[0];

      if(command.equals("PUSH")){
        tower.push(input[1]);
        freqMap.put(input[1],freqMap.getOrDefault(input[1],0)+1);
      }else if(command.equals("POP")){
        if(!tower.isEmpty()){
          String removed=tower.pop();
          freqMap.put(removed,freqMap.get(removed)-1);
          if(freqMap.get(removed)==0) freqMap.remove(removed);
        }
        
        
      }else if(command.equals("COUNT")){
        if(isFirstOutput){
          System.out.println();
          isFirstOutput=false;
        }
        if(tower.isEmpty()) System.out.println("EMPTY");
        else System.out.println(freqMap.get(tower.peek()));
      }

      n--;
    }

    sc.close();
  }
}