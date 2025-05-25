package day10;
import java.util.*;

public class  Keypad{

  //hashmap of digit to letters in String
  private static final Map<Character,String> keypad=Map.of(
    '2',"abc",
    '3',"def",
    '4',"ghi",
    '5',"jkl",
    '6',"mno",
    '7',"pqrs",
    '8',"tuv",
    '9',"wxyz"
  );

  //backtracking  helper function
  private static void backtrack(List<String> result,StringBuilder current,String digits,int index){
    if(index==digits.length()){
      result.add(current.toString());
      return;
    }

    String letters=keypad.get(digits.charAt(index)); //get all possible letters for that digit
    if(letters!=null){
      for(char letter:letters.toCharArray()){
        current.append(letter);
        backtrack(result,current,digits,index+1); //for the next digit
        current.deleteCharAt(current.length()-1); //backtrack
      }
    }
  }

  //main logic to return list
  private static List<String> letterCombination(String digits){
    List<String> result=new ArrayList<>();
    if(digits==null || digits.isEmpty()) return result; //for the constraint digit.length()==0
    //otherwise
    backtrack(result,new StringBuilder(),digits,0);
    return  result;
    
  }

  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String input=sc.nextLine();

    List<String> result=letterCombination(input);
    System.out.println(result);
    sc.close();
  }
}