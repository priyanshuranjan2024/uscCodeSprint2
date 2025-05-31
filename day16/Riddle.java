package day16;
import java.util.*;

public class Riddle{
  static class Node{
    String val;
    Node next;
    Node(String val){
      this.val=val;
    }
  }

  private static Node buildList(String[] arr){
    Node dummy=new Node("dummy");
    Node current=dummy;
    for(String element:arr){
      current.next=new Node(element);
      current=current.next;
    }

    return dummy.next;
  }

  private static void printList(Node head){
    List<String> result=new ArrayList<>();
    while(head!=null){
      result.add(head.val);
      head=head.next;
    }
    System.out.println(result);
  }

  private static Node reverse(Node head,int left,int right){
    Node dummy=new Node("dummy");
    dummy.next=head;
    Node prev=dummy;

    for(int i=1;i<left;i++) prev=prev.next;

    Node current=prev.next;
    Node prevNode=null;
    for(int i=0;i<=right-left;i++){
      Node nextNode=current.next;
      current.next=prevNode;
      prevNode=current;
      current=nextNode;
    }

    Node tail=prev.next; //this is the end after reversal of the sublist
    tail.next=current;
    prev.next=prevNode;

    return dummy.next;
    
  }

  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String[] arr=sc.nextLine().trim().split(" ");
    int left=sc.nextInt();
    int right=sc.nextInt();

    Node head=buildList(arr);
    Node result=reverse(head,left,right);
    printList(result);
    sc.close();
    
  }
    
}