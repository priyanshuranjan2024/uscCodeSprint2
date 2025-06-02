import java.util.*;

public class Brackets{

  private static boolean isValid(String s){
    Stack<Character> stack=new Stack<>();
    for(char c:s.toCharArray()){
      if(c=='(' || c=='{' || c=='['){
        stack.push(c);
      }else{
        if(c==']' && stack.peek()=='[' || c=='}' && stack.peek()=='{' || c==')' && stack.peek()=='(' ) stack.pop();
        else return false;
        
      }
    }

    return stack.isEmpty();
    
  }

  
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();

    System.out.println(isValid(s));
    sc.close();
    
  }
}