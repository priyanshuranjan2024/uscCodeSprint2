package day2;
import java.util.Scanner; //for input


public class Magical {

    public static void main(String[] args){
        //linear search from index 1 to index n-2 since we will not consider 
        //border elements
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int[] scores=new int[n];
        for(int i=0;i<n;i++) scores[i]=sc.nextInt();
    
        int magical=0; //this will be the answer
    
        for(int i=1;i<n-1;i++){
          if(scores[i]>scores[i+1] && scores[i]>scores[i-1]) magical++;
        }
    
        System.out.println(magical);
        sc.close();
    
        
      }

    
}
