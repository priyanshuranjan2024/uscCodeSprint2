package day15;
import java.util.*;

public class Necklace{
  static class Node{
    int val;
    Node next;
    Node prev;
    Node(int val){
      this.val=val;
    }
  }

  private static Node removeTargets(Node head,int target){
    Node current=head;

    while(current!=null){
      if(current.val==target){
        Node nextNode=current.next;
        Node prevNode=current.prev;

        if(prevNode!=null) prevNode.next=nextNode;
        if(nextNode!=null) nextNode.prev=prevNode;

        if(current==head) head=nextNode;
      }
      current=current.next;
    }

    return head;
  }

  //to build linked list
  private static Node buildList(int[] arr){
    if(arr.length==0) return null;

    Node head=new Node(arr[0]);
    Node current=head;
    for(int i=1;i<arr.length;i++){
      Node newNode=new Node(arr[i]);
      current.next=newNode;
      newNode.prev=current;
      current=newNode;
    }

    return head;
  }

  //to print list
  private static  void printList(Node head){
    while(head!=null){
      System.out.print(head.val);
      if(head.next!=null) System.out.print("<->");
      head=head.next;
    }
    System.out.println();
  }

  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String[] input=sc.nextLine().trim().split("\\s+");
    int[] arr=Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
    int target=sc.nextInt();

    Node head=buildList(arr);
    head=removeTargets(head,target);
    printList(head);
    sc.close();
    
  }
  
}