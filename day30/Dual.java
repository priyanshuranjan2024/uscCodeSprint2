package day30;
import java.util.*;

//firstly i will find the max morgana's spell power 
//then minimum required for each spell should be maxMorgana+1
//traverse over merlin's spells and for each update mana count if power less than 
//maxMorgana+1

public class Dual{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    
    int n=sc.nextInt();
    int[] merlin=new int[n];
    for(int i=0;i<n;i++) merlin[i]=sc.nextInt();

    int m=sc.nextInt();
    int[] morgana=new int[m];
    int maxMorgana=0;
    for(int i=0;i<m;i++){
      morgana[i]=sc.nextInt();
      maxMorgana=Math.max(maxMorgana,morgana[i]);
    }

    sc.close();

    int manaCount=0;
    for(int power:merlin){
      if(power<=maxMorgana) manaCount+=(maxMorgana+1-power);
    }

    System.out.println(manaCount);
  }
}

