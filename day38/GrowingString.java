package day38;
import java.util.*;

public class GrowingString{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int k=sc.nextInt();
    System.out.println(findKthChar(k));
    sc.close();
  }

  private static char findKthChar(int k){
    StringBuilder current=new StringBuilder("a");

    while(current.length()<k){
      StringBuilder next=new StringBuilder();
      for(int i=0;i<current.length();i++){
        char ch=current.charAt(i);
        char nextCh=(char)((ch-'a'+1)%26+'a');
        next.append(nextCh);
      }
      current.append(next);
    }

    return current.charAt(k-1);
  }
}