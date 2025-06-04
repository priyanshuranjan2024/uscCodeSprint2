package day20;
import java.util.*;

public class Akancha{

  private static int[] greaterSmallerElement(int[] arr){
    int n=arr.length;
    int[] nextGreater=new int[n];
    int[] nextSmaller=new int[n];
    int[] result=new int[n];

    //firstly i will find the next greater element and store its index
    Stack<Integer> stack=new Stack<>();
    Arrays.fill(nextGreater,-1);

    for(int i=n-1;i>=0;i--){
      while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) stack.pop();
      if(!stack.isEmpty()) nextGreater[i]=stack.peek();
      stack.push(i);
    }

    //now same for next smaller element
    Arrays.fill(nextSmaller,-1);
    stack.clear();

    for(int i=n-1;i>=0;i--){
      while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();
      if(!stack.isEmpty()) nextSmaller[i]=stack.peek();
      stack.push(i);
    }

    //result
    for(int i=0;i<n;i++){
      int nextGIndex=nextGreater[i];
      if(nextGIndex!=-1){
        int nextSIndex=nextSmaller[nextGIndex];
        result[i]=(nextSIndex!=-1)?arr[nextSIndex]:-1;
      }else{
        result[i]=-1;
      }
    }

    return result;
    
  }


  
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++) arr[i]=sc.nextInt();

    int[] result=greaterSmallerElement(arr);
    for(int i=0;i<n;i++) System.out.print(result[i]+" ");
    System.out.println();

    sc.close();
    
    
  }
}
