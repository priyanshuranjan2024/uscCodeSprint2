import java.util.Scanner;

public class Archery{
  public static void main(String[] args){
    //will do a linear search and update the values of the two variables
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int good=0;
    int missed=0;

    //update the variables
    for(int i=0;i<n;i++){
      int score=sc.nextInt();
      if(score>=7) good++;
      else missed++;
    }

    System.out.println(good+" "+missed);
    sc.close();
    
  }
}