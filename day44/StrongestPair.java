package day44;
import java.util.*;

public class StrongestPair{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=Integer.parseInt(sc.nextLine());

    String[] words=new String[n];

    for(int i=0;i<n;i++){
      words[i]=sc.nextLine();
    }

    System.out.println(strongLength(words));
    sc.close();
  }

  private static int strongLength(String[] words){
    int n=words.length;
    int[] masks=new int[n];
    int[] lengths=new int[n];

    for(int i=0;i<n;i++){
      int mask=0;
      for(char c:words[i].toCharArray()){
        mask|=(1<<(c-'a'));
      }
      masks[i]=mask;
      lengths[i]=words[i].length();
    }

    int maxProduct=0;
    for(int i=0;i<n;i++){
      for(int j=i+1;j<n;j++){
        if((masks[i]&masks[j])==0){
          maxProduct=Math.max(maxProduct,lengths[i]*lengths[j]);
        }
      }
    }

    return maxProduct;
    
  }
}