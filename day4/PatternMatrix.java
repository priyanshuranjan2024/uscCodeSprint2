import java.util.Scanner;

public class PatternMatrix{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    //use two variables and update it in the loop
    int mainD=1; //1 to n
    int antiD=n; //n to 1

    for(int i=0;i<n;i++){
      StringBuilder row=new StringBuilder();
      for(int j=0;j<n;j++){
        if(i==j) row.append(mainD);
        else if(i+j==n-1) row.append(antiD);
        else row.append("-");
        if(j<n-1) row.append(" "); //space between each element
      }
      System.out.println(row);
      mainD++;
      antiD--;
    }

    sc.close();
  }
}