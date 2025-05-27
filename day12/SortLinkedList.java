package day12;
import java.util.Scanner;

public class SortLinkedList{
  static class Node{
    int val;
    Node next;
    Node(int val){
      this.val=val;
      this.next=null;
    }
  }

  private static Node sortLinkedList(Node head){
    if(head==null || head.next==null){
      return head;
    }

    Node prev=head;
    Node curr=head.next;

    while(curr!=null){
      if(curr.val<0){
        prev.next=curr.next;
        curr.next=head;
        head=curr;
        curr=prev.next;
      }else{
        prev=curr;
        curr=curr.next;
      }
    }

    return head;
  }

  
  

  private static void printList(Node head){
    Node curr=head; //temp pointer
    
    while(curr!=null){
      System.out.print(curr.val);
      if(curr.next!=null) System.out.print("->");
      curr=curr.next;
    }

    System.out.println();
  }

  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    
    Node head=null;
    Node curr=null;
    for(int i=0;i<n;i++){
      int value=sc.nextInt();
      Node newNode=new Node(value);
      if(head==null){
        head=newNode;
        curr=newNode;
      }else{
        curr.next=newNode;
        curr=newNode;
      }
    }

    head=sortLinkedList(head);
    printList(head);
    sc.close();

    
    
    
  }
  
}