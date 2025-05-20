import java.util.Scanner;

public class TrainingChart{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();

    //motivational message
    if(n>10){
      System.out.println("Avik's marathon journey intensifies! Let's see his detailed zig-zag pattern:");
    }

    generateZigZagChart(n);
    System.out.println("Total numbers printed:"+(n*(n+1)/2));
    
    sc.close();
  }

  //helper function to print the chart
  private static void generateZigZagChart(int n){
    int maxLength=n+(n-1)*3; //last row

    for(int day=1;day<=n;day++){
      StringBuilder row=new StringBuilder();
      if(day%2==1){
        for(int num=1;num<=day;num++){
          row.append(num);
          if(num<day){
            row.append("   ");
          }
        }
      }else{
        for(int num=day;num>=1;num--){
          row.append(num);
          if(num>1){
            row.append("   ");
          }
        }
      }

      //center align
      int pad=(maxLength-row.length())/2;
      for(int i=0;i<pad;i++) System.out.print(" ");
      System.out.println(row.toString());
      
    }

    
  }
}