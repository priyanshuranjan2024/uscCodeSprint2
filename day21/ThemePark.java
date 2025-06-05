import java.util.*;

public class ThemePark{

  static class Person{
    int tickets;
    int index;

    Person(int tickets,int index){
      this.tickets=tickets;
      this.index=index;
    }
    
  }

  private static int timeRequired(int[] tickets,int k){
    Queue<Person> queue=new LinkedList<>();

    for(int i=0;i<tickets.length;i++){
      queue.offer(new Person(tickets[i],i));
    }

    int time=0;

    while(!queue.isEmpty()){
      Person current=queue.poll();
      time++;
      current.tickets--;

      if(current.tickets>0){
        //add it in last
        queue.offer(current);
      }else if(current.index==k) break;
      
    }

    return time;
  }

  
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] tickets=Arrays.stream(sc.nextLine().trim().split(" "))
      .mapToInt(Integer::parseInt).toArray();

    int k=sc.nextInt();

    int result=timeRequired(tickets,k);
    System.out.println(result);
    sc.close();
    
  }
}