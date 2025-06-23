package day39;
import java.util.*;

public class SecretMessage{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    System.out.println(decode(s));
    sc.close();
  }

  private static int index=0;

  private static String decode(String s){
    index=0;
    return decodeHelper(s);
  }

  private static String decodeHelper(String s){
    StringBuilder result=new StringBuilder();
    int num=0;

    while(index<s.length()){
      char ch=s.charAt(index);

      if(Character.isDigit(ch)){
        num=num*10+(ch-'0');
        index++;
      }else if(ch=='['){
        index++;
        String inner=decodeHelper(s);
        for(int i=0;i<num;i++){
          result.append(inner);
        }
        num=0;
      }else if(ch==']'){
        index++;
        return result.toString();
      }else{
        result.append(ch);
        index++;
      }
    }

    return result.toString();
  }
}