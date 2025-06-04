package day19;
import java.util.*;

public class Tamana{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=Integer.parseInt(sc.nextLine());

    //use two stacks one for minimimum and one for pushing
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();

    while(n>0){
      String[] input=sc.nextLine().split(" ");
      String command=input[0];      
      //if push
      if(command.equals("PUSH")){
        int val=Integer.parseInt(input[1]);
        stack.push(val);

        if(minStack.isEmpty() || val<=minStack.peek()){
          minStack.push(val);
        }
        
      }else if(command.equals("POP")){
        if(!stack.isEmpty()){
          int removed=stack.pop();
          if(!minStack.isEmpty() && removed==minStack.peek()) minStack.pop();
        }
      }else if(command.equals("MIN")){
        if(minStack.isEmpty()) System.out.println("EMPTY"); //since negative number may be a temperature
        else System.out.println(minStack.peek());
      }

      n--; 
      
    }

    sc.close();
  }
}