package day33;
import java.util.*;

public class ScienceFair{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();

    Set<Integer> uniqueThemes=new HashSet<>();
    for(int i=0;i<n;i++){
      uniqueThemes.add(sc.nextInt());
      
    }

    if(uniqueThemes.size()>=2*k) System.out.println("YES");
    else System.out.println("NO");

    sc.close();
  }
}