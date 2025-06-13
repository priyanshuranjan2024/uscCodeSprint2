package day29;
import java.util.*;

public class Battle{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] batch=new int[n];
    int[] patients=new int[n];

    for(int i=0;i<n;i++) batch[i]=sc.nextInt();
    for(int i=0;i<n;i++) patients[i]=sc.nextInt();

    String result=(areCured(batch,patients))?"yes":"No";
    System.out.println(result);
    sc.close();
    
  }

  private static boolean areCured(int[] batch,int[] patients){
    int n=batch.length;

    //firstly sorting the array
    Arrays.sort(batch);
    Arrays.sort(patients);

    for(int i=0;i<n;i++){
      if(batch[i]<=patients[i]) return false;
    }

    return true;
  }
}