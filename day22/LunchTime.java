package day22;
import java.util.*;

public class LunchTime{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    //creating a queue
    Queue<Integer> student=new LinkedList<>();
    for(int i=0;i<n;i++) student.offer(sc.nextInt());

    //creating the sandwich stack
    Stack<Integer> sandwich=new Stack<>();
    int[] sandwichArray=new int[n];
    for(int i=0;i<n;i++) sandwichArray[i]=sc.nextInt();
    for(int i=n-1;i>=0;i--) sandwich.push(sandwichArray[i]);

    int rotations=0;
    while(!student.isEmpty() && rotations<student.size()){
      if(student.peek()==sandwich.peek()){
        student.poll();
        sandwich.pop();
        rotations=0; //reset
        
      }else{
        student.offer(student.poll());
        rotations++;
      }
    }

    System.out.println(student.size());
    sc.close();

    
  }
}