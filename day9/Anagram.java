package day9;
import java.util.*;

public class Anagram{
  private static List<Integer> findAnagram(String logStream,String pattern){
    //will use a sliding window approach and use freq arrays to count freq
    List<Integer> result=new ArrayList<>();
    if(logStream.length()<pattern.length()) return result;

    int[] patternFreq=new int[26];
    int[] logStreamFreq=new int[26];

    for(char c:pattern.toCharArray()) patternFreq[c-'a']++;

    int windowSize=pattern.length();

    for(int i=0;i<logStream.length();i++){
      logStreamFreq[logStream.charAt(i)-'a']++;

      if(i>=windowSize){
        logStreamFreq[logStream.charAt(i-windowSize)-'a']--;
      }

      if(Arrays.equals(logStreamFreq,patternFreq)){
        result.add(i-windowSize+1); //starting index
      }
    }

    return result;
  }

  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String logStream=sc.nextLine();
    String pattern=sc.nextLine();

    List<Integer> result=findAnagram(logStream,pattern);
    System.out.println(result);
    sc.close();
  }

}