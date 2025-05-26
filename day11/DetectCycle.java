package day11;
import java.util.*;

public class DetectCycle{
  static class Node{
    int val;
    Node next;

    Node(int val){
      this.val=val;
      this.next=null;
    }
  }

  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();

    Node head=null;
    Node current=null;
    for(int i=0;i<n;i++){
      int value=sc.nextInt();
      Node newNode=new Node(value);
      if(head==null){
        head=newNode;
        current=newNode;
      }else{
        current.next=newNode;
        current=newNode;
      }
    }

    int pos=sc.nextInt();

    createCycle(head,pos);
    boolean ans=hareAndTortoise(head);
    System.out.println(ans);
    sc.close();
  }

  private static void createCycle(Node head,int pos){
    if(pos==0) return;

    Node cycleNode=null;
    Node current=head;
    int count=1;

    while(current.next!=null){
      if(count==pos) cycleNode=current;
      current=current.next;
      count++;
    }

    current.next=cycleNode;
  }

  private static boolean hareAndTortoise(Node head){
    Node hare=head;
    Node tortoise=head;

    while(hare!=null && hare.next!=null){
      tortoise=tortoise.next;
      hare=hare.next.next;

      if(tortoise==hare){
        removeCycle(head,tortoise);
        return true;
      }
    }

    return false;
  }

  private static void removeCycle(Node head,Node tortoise){
    Node ptr1=head;
    Node ptr2=tortoise;

    if(ptr1==ptr2){
      while(ptr2.next!=ptr1) ptr2=ptr2.next;
      ptr2.next=null;
      return;
    }

    while(ptr1.next!=ptr2.next){ //till found where the cycle is present
      ptr1=ptr1.next;
      ptr2=ptr2.next;
    }

    ptr2.next=null;
  }

    
}