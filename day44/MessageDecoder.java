package day44;
import java.util.*;


//will use a hashmap for this question
public class MessageDecoder{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    String t=sc.nextLine();

    if(isValid(s,t)) System.out.println("True");
    else System.out.println("False");
    sc.close();
  }

  private static boolean isValid(String s,String t){
    if(s.length()!=t.length()) return false;

    //creating two maps one from s-t and other from t-s 
    Map<Character,Character> mapST=new HashMap<>();
    Map<Character,Character> mapTS=new HashMap<>();

    for(int i=0;i<s.length();i++){
      char charS=s.charAt(i);
      char charT=t.charAt(i);

      if(mapST.containsKey(charS)){
        if(mapST.get(charS)!=charT) return false;
      }else{
        mapST.put(charS,charT);
      }

      if(mapTS.containsKey(charT)){
        if(mapTS.get(charT)!=charS) return false;
      }else{
        mapTS.put(charT,charS);
      }
      
    }

    return true;
  }
}