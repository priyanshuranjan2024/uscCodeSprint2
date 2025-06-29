package day45;
import java.util.*;

public class FractionFormula{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String formula=sc.nextLine();
    System.out.println(evaluateFormula(formula));
    sc.close();
  }

  private static String evaluateFormula(String formula){
    int numerator=0;
    int denominator=1;

    int i=0;
    while(i<formula.length()){
      int sign=1; //let it be positive in starting
      if(formula.charAt(i)=='+' || formula.charAt(i)=='-'){
        sign=(formula.charAt(i)=='-')?-1:1;
        i++;
      }

      int num=0;
      while(i<formula.length() && Character.isDigit(formula.charAt(i))){
        num=num*10+(formula.charAt(i++)-'0');
      }

      i++; //skipping /

      int den=0;
      while(i<formula.length() && Character.isDigit(formula.charAt(i))){
        den=den*10+(formula.charAt(i++)-'0');
      }

      numerator=numerator*den+sign*num*denominator;
      denominator=denominator*den;

      int hcf=gcd(Math.abs(numerator),denominator);
      numerator/=hcf;
      denominator/=hcf;
    }

    return numerator+"/"+denominator;

    
  }

  private static int gcd(int a,int b){
    return b==0?a:gcd(b,a%b);
  }

  
}