package day20;
import java.util.*;

public class Parentheses{

  private static String returnPrimitive(String s){
    StringBuilder result=new StringBuilder();
    int depth=0;

    for(char c:s.toCharArray()){
      if(c=='('){
        if(depth>0) result.append(c);
        depth++;
      }else if(c==')'){
        depth--;
        if(depth>0) result.append(c);
      }
    }

    return result.toString();
    
  }

  
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();

    System.out.println(returnPrimitive(s));
    sc.close();
  }
}