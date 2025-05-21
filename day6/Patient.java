package day6;
import java.util.*;

public class Patient{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    sc.nextLine();

    LinkedHashSet<String> set=new LinkedHashSet<>();

    for(int i=0;i<n;i++){
      String patientName=sc.nextLine();

      char firstChar=patientName.charAt(0);
      if(isVowel(firstChar)) set.add(patientName);
      
    }

    System.out.println(set.size()); //count
    for(String patient:set) System.out.println(patient);

    sc.close();
    
  }

  private static boolean isVowel(char c){
    return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
  }
}