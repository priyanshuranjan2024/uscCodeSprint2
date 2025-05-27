package day12;
import java.util.Scanner;

public class CountingSort{
  static class Node{
    int val;
    Node next;
    Node(int val){
      this.val=val;
      this.next=null;
    }
  }

  //use counting sort logic take the frequency of 0,1 and 2
  //then place it in the linked list

  private static Node countSort(Node head){
    if(head==null || head.next==null) return head;

    int[] count=new  int[3];
    Node temp=head;
    while(temp!=null){
      count[temp.val]++;
      temp=temp.next;
    }

    //now modify the linked list
    temp=head;
    int i=0;
    while(temp!=null){
      if(count[i]==0) i++; //if freq becomes zero
      else{
        temp.val=i;
        count[i]--;
        temp=temp.next;
      }
    }

    return head;
    
  }

  private static void printList(Node head){
    Node curr=head;
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
    //take the linked list
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
        curr=curr.next;
      }
    }

    head=countSort(head);
    printList(head);
    sc.close();
    
  }
}