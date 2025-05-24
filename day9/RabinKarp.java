package day9;
import java.util.*;

public class RabinKarp{
  private static List<Integer> rabinKarpAlgo(String text,String pattern){
    List<Integer> result=new ArrayList<>();
    int n=text.length();
    int m=pattern.length();
    if(m>n) return result; //corner case

    int base=31;
    int mod=1_000_000_007;

    long patternHash=0;
    long textHash=0;
    long basePower=1;

    //precompute
    for(int i=0;i<m;i++){
      patternHash=(patternHash*base+(pattern.charAt(i)-'a'+1))%mod;
      textHash=(textHash*base+(text.charAt(i)-'a'+1))%mod;
      if(i<m-1) basePower=(basePower*base)%mod;
    }

    //checking the first window
    if(patternHash==textHash){
      if(text.substring(0,m).equals(pattern)) result.add(0);
    }

    //roll hash for remaining positions
    for(int i=1;i<=n-m;i++){
      //removing left char
      textHash=(textHash-(text.charAt(i-1)-'a'+1)*basePower%mod+mod)%mod;
      //add the right char
      textHash=(textHash*base+(text.charAt(i+m-1)-'a'+1))%mod;

      if(patternHash==textHash){
        if(text.substring(i,i+m).equals(pattern)) result.add(i);
      }
      
      
    }

    return result;

  }

  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String text=sc.nextLine();
    String pattern=sc.nextLine();

    List<Integer> result=rabinKarpAlgo(text,pattern);
    System.out.println(result);
    sc.close();
  }
}