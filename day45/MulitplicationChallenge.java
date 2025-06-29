package day45;
import java.util.*;

public class MulitplicationChallenge{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];

    for(int i=0;i<n;i++) arr[i]=sc.nextInt();

    long[] output=new long[n];
    long[] left=new long[n];
    long[] right=new long[n];

    left[0]=1;
    for(int i=1;i<n;i++) left[i]=left[i-1]*arr[i-1];

    right[n-1]=1;
    for(int i=n-2;i>=0;i--) right[i]=right[i+1]*arr[i+1];

    for(int i=0;i<n;i++) output[i]=left[i]*right[i];

    for(int i=0;i<n;i++){
      System.out.print(output[i]+(i<n-1?" ":""));
    }
    System.out.println();
    sc.close();
  }
}