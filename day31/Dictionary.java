package day31;
import java.util.*;

public class Dictionary{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    sc.nextLine();

    List<String> seenWords=new ArrayList<>();
    for(int i=0;i<n;i++){
      String currentWord=sc.nextLine();
      int count=0;

      for(String word:seenWords){
        if(word.compareTo(currentWord)<0) count++;
      }

      System.out.println(count);
      seenWords.add(currentWord);
    }

    sc.close();
  }
}