import java.util.Scanner;

public class ReverseSpeech{
    private static String reverseStringHelper(String speechLine){
      //firstly remove spaces in start or end using trim
      //then split it and store it in array
      String[] words=speechLine.trim().split("\\s+");

      int left=0;
      int right=words.length-1;
      while(left<right){
        String temp=words[left];
        words[left]=words[right];
        words[right]=temp;
        left++;
        right--;
      }

      return String.join(" ",words);
    }

  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String speechLine=sc.nextLine();
    String result=reverseStringHelper(speechLine);
    System.out.println(result);
    sc.close();
  }

  
}