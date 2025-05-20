package day5;
import java.util.Scanner;

public class Checkboard{
  public static void main(String[] args){
    //taking input and rather than storing it in and then printing
    //store each row and print it at the same time
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();

    int totalStudents=0;

    for(int i=0;i<n;i++){
      StringBuilder row=new StringBuilder();
      for(int j=0;j<n;j++){
        if((i+j)%2==0){
          row.append("1");
          totalStudents++;
        }else row.append("0");

        //add spaces
        if(j<n-1) row.append(" ");
      }

      //printing the row
      System.out.println(row);
    }

    System.out.println("Total students seated:"+totalStudents);
    sc.close();
  }
}