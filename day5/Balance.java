package day5;
import java.util.Scanner;

public class Balance{
  public static void main(String[] args){
    //take the input in a 26 size freq array
    //then all letters should have same freq if not then handle it
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();

    int[] freq=new int[26]; //since constant hence O(1) space
    for(char c:s.toCharArray()) freq[c-'a']++;

    int expected=0; //constant freq
    boolean isBalanced=true;

    for(int f:freq){
      if(f!=0){
        if(expected==0) expected=f;
        else if(f!=expected){
          isBalanced=false;
          break;
        }
        }
    }

    if(isBalanced){
        System.out.println("Aashriya smiles: Emotional balance found.");
    }else{
      System.out.println("Aashriya wonders: These thoughts were scattered");
    }

    sc.close();
  }
}
