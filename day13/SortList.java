package day13;
import java.util.*;

//merge sort on linked list
public class SortList{
  static class Node{
    int val;
    Node prev;
    Node next;
    Node(int val){
      this.val=val;
    }
  }

  //have to split the linked list from middle for merge short
  private static Node split(Node head){
    //using hare and tortoise algo
    Node slow=head;
    Node fast=head;
    while(fast.next!=null && fast.next.next!=null){
      slow=slow.next;
      fast=fast.next.next;
    }
    Node middle=slow.next;
    slow.next=null;
    if(middle!=null) middle.prev=null;
    return middle;
  }

  //merge function
  private static Node merge(Node first,Node second){
    if(first==null) return second;
    if(second==null) return first;

    if(first.val<=second.val){
      first.next=merge(first.next,second);
      if(first.next!=null) first.next.prev=first;
      first.prev=null;
      return first;
    }else{
      second.next=merge(first,second.next);
      if(second.next!=null) second.next.prev=second;
      second.prev=null;
      return second;
    }
  }

  //merge sort main function
  private static Node mergeSort(Node head){
    if(head==null || head.next==null) return head;
    Node second=split(head);
    head=mergeSort(head);
    second=mergeSort(second);
    return merge(head,second);
  }

  private static void printList(Node head){
    while(head!=null){
      System.out.print(head.val);
      if(head.next!=null) System.out.print(" <-> ");
      head=head.next;
    }
    System.out.println();
  }

  //main function
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();

    Node head=new Node(sc.nextInt());
    Node curr=head;

    for(int i=1;i<n;i++){
      Node newNode=new Node(sc.nextInt());
      curr.next=newNode;
      newNode.prev=curr;
      curr=newNode;
    }

    Node sorted=mergeSort(head);
    printList(sorted);
    sc.close();
  }

  
}