package day10;
import java.util.Scanner;

public class Deduplication{

  static class Node{
    int val;
    Node next;

    Node(int val){
      this.val=val;
      this.next=null;
    }
  }

  //removes duplicates
  private static Node deleteDuplicate(Node head){
    Node current=head;

    while(current!=null && current.next!=null){
      if(current.val==current.next.val) current.next=current.next.next;
      else current=current.next;
    }

    return head;
  }

  //for printing the list
  private static void printList(Node head){
    while(head!=null){
      System.out.print(head.val+"->");
      head=head.next;
    }

    System.out.println();
  }

  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Node head=null;
    Node current=null;

    for(int i=0;i<n;i++){
      int val=sc.nextInt();
      Node newNode=new Node(val);
      if(head==null){
        head=newNode;
        current=newNode;
      }else{
        current.next=newNode;
        current=current.next;
      }
    }

    head=deleteDuplicate(head);
    printList(head);
    sc.close();
    
    
  }
}