package day2;
import java.util.Scanner; //for input

public class Jam {
    public static void main(String[] args){
        //will just traverse over the array from index 1 to n-1 last index
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int[] traffic=new int[n];
        for(int i=0;i<n;i++) traffic[i]=sc.nextInt();
    
        int critical=0;
    
        for(int i=1;i<n;i++){
          if(traffic[i]>=50 && traffic[i]>traffic[i-1]) critical++;
        }
    
        System.out.println(critical);
        sc.close();
    
        
      }
    
}
