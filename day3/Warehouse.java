package day3;
import java.util.Scanner; //for the input

public class Warehouse{
  public static void main(String[] args){
    //will use two counters
    Scanner sc=new Scanner(System.in);
    int row=sc.nextInt();
    int col=sc.nextInt();

    int total=0; //this will be the answer

    for(int i=0;i<row;i++){
      int overStock=0;
      for(int j=0;j<col;j++){
        int cell=sc.nextInt();
        if(cell>=100) overStock++;
      }
      if(overStock>=3) total++;
      
    }

    System.out.println(total);
    sc.close();
  }
}