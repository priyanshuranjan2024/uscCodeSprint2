import java.util.*;
//reverse the linked list and then create new nodes and take care of carry at last return after reversing it

public class TicketMachine{
  static class Node{
    int val;
    Node next;
    Node(int val){
      this.val=val;
      this.next=null;
    }
  }

  //creating the linked list
  private static Node createList(int[] arr){
    Node head=new Node(arr[0]);
    Node current=head;
    for(int i=1;i<arr.length;i++){
      current.next=new Node(arr[i]);
      current=current.next;
    }

    return head;
  }

  //reverse the linked list since i need to go from lsb to msb
  private static Node reverse(Node head){
    Node prev=null;
    while(head!=null){
      Node next=head.next;
      head.next=prev;
      prev=head;
      head=next;
    }

    return prev;
  }

  //function for doubling the linked list Number
  private static Node doubleLinkedList(Node head){
    head=reverse(head);

    Node dummy=new Node(0);
    Node current=dummy;
    int carry=0;

    while(head!=null){
      int sum=head.val*2+carry;
      carry=sum/10;
      current.next=new Node(sum%10);
      current=current.next;
      head=head.next;
    }

    //in case of carry remains
    if(carry>0){
      current.next=new Node(carry);
    }

    return reverse(dummy.next);
  }

  //function to print the linked list
  private static void printList(Node head){
    while(head!=null){
      System.out.print(head.val);
      if(head.next!=null) System.out.print(", ");
      head=head.next;
    }
    System.out.println();
  }

  //main function
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String[] values=sc.nextLine().trim().split("\\s+");
    int[] ticket=Arrays.stream(values).mapToInt(Integer::parseInt).toArray();

    Node head=createList(ticket);
    Node result=doubleLinkedList(head);
    printList(result);
    sc.close();
  }

  
}