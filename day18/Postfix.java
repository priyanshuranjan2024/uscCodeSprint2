import java.util.*;

public class Postfix{

  private static int evaluatePostfix(String[] arr){
    Stack<Integer> stack=new Stack<>();

    for(String c:arr){
      if(isOperator(c)){
        int b=stack.pop();
        int a=stack.pop();
        int result=applyOperator(a,b,c);
        stack.push(result);
      }else{
        stack.push(Integer.parseInt(c));
      }
    }

    return stack.pop();
  }

  private static boolean isOperator(String c){
    return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
  }

  private static int applyOperator(int a,int b,String c){
    if(c.equals("+")) return a+b;
    else if(c.equals("-")) return a-b;
    else if(c.equals("*")) return a*b;
    else if(c.equals("/")) return a/b;
    else throw new IllegalArgumentException("Invalid operator "+c);
  }

  
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String line=sc.nextLine();
    String[] arr=line.trim().split("\\s+");

    System.out.println(evaluatePostfix(arr));
    sc.close();
    
  }
}