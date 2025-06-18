package day34;
import java.util.*;

public class SuperPrimes{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    List<Integer> primes=new ArrayList<>();

    for(int i=2;i<=n;i++){
      if(isPrime(i)) primes.add(i);
    }

    List<Integer> superPrimes=new ArrayList<>();
    for(int i=0;i<primes.size();i++){
      int index=i+1;
      if(isPrime(index)) superPrimes.add(primes.get(i));
      
    }

    //output
    for(int i=0;i<superPrimes.size();i++){
      System.out.print(superPrimes.get(i) +" ");
      
    }
    System.out.println();
    sc.close();
  }

  private static boolean isPrime(int num){
    if(num<2) return false;
    for(int i=2;i*i<=num;i++){
      if(num%i==0) return false;
    }
    return true;
  }
}