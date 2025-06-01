package day17;
import java.util.*;

public class Transformer{

  private static String postfixToPrefix(String postfix){
    Stack<String> stack=new Stack<>();
    for(char c:postfix.toCharArray()){
      if(Character.isLetter(c)){
        stack.push(String.valueOf(c));
      }else{
        String op2=stack.pop();
        String op1=stack.pop();
        String exp=c+op1+op2;
        stack.push(exp);
      }
    }

    return stack.pop();
    
  }

  
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String postfix=sc.nextLine();
    String prefix=postfixToPrefix(postfix);
    System.out.println(prefix);
    sc.close();
    
  }
}