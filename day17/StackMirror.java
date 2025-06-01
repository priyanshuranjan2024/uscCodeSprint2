package day17;
import java.util.*;

public class StackMirror{

  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();

    Stack<Character> stack=new Stack<>();
    for(char c:s.toCharArray()){
      stack.push(c);
    }

    while(!stack.isEmpty()){
      System.out.print(stack.pop());
    }
    System.out.println();
    sc.close();
  }
}