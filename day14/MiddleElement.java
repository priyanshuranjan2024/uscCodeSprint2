import java.util.*;

public class MiddleElement{
  static class Node{
    int val;
    Node next;
    Node(int val){
      this.val=val;
      this.next=null;
    }
  }

  //function to get middle element using fast and slow two pointer
  private static List<Integer> middleToEnd(Node head){
    Node slow=head;
    Node fast=head;

    while(fast!=null && fast.next!=null){
      slow=slow.next;
      fast=fast.next.next;
    }


    List<Integer> result=new ArrayList<>();
    while(slow!=null){
      result.add(slow.val);
      slow=slow.next;
    }

    return result;
  }

  private static Node createList(int[] arr){
    if(arr.length==0) return null;
    Node head=new Node(arr[0]);
    Node current=head;
    for(int i=1;i<arr.length;i++){
      current.next=new Node(arr[i]);
      current=current.next;
    }

    return head;
  }

  //main function
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String[] values=sc.nextLine().trim().split("\\s+");
    int[] badge=Arrays.stream(values).mapToInt(Integer::parseInt).toArray();

    Node head=createList(badge);
    List<Integer> result=middleToEnd(head);
    System.out.println(result);
    sc.close();
    
  }
}