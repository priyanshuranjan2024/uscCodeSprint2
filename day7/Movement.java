package day7;
import java.util.Scanner;

public class Movement{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);

    String binaryLog=sc.nextLine();

    int segment=0; //this will be the answer
    boolean inMovement=false;

    for(int i=0;i<binaryLog.length();i++){
      char current=binaryLog.charAt(i);

      if(current=='1'){
        if(!inMovement){
          segment++;
          inMovement=true;
        }
      }else if(current=='0'){
        inMovement=false;
      }
    }

    System.out.println(segment);
    sc.close();
  }
}