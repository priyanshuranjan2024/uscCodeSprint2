package day28;
import java.util.*;

public class PowerToken{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] tokens=Arrays.stream(sc.nextLine().trim().split(" "))
      .mapToInt(Integer::parseInt)
      .toArray();

    int power=sc.nextInt();

    System.out.println(maxScore(tokens,power));
    sc.close();
  }

  private static int maxScore(int[] tokens,int power){
    Arrays.sort(tokens);
    int i=0;
    int j=tokens.length-1;
    int score=0;
    int maxScore=0;

    while(i<=j){
      //face up 
      if(power>=tokens[i]){
        power-=tokens[i];
        i++;
        score++;
        maxScore=Math.max(maxScore,score);
      }else if(score>=1){
        //face down
        power+=tokens[j--];
        score--;
      }else{
        break;
      }
    }

    return maxScore;
    
  }
}