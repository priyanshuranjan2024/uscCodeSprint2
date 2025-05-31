package day16;
import java.util.*;

public class MergeLinkedList{
  static class Node{
    int val;
    Node next;
    Node(int val){
      this.val=val;
    }
  }

  //logic for merging
  private static Node mergeList(Node l1,Node l2){
    Node dummy=new Node(-1);
    Node current=dummy;

    while(l1!=null && l2!=null){
      if(l1.val<=l2.val){
        current.next=l1;
        l1=l1.next;
      }else{
        current.next=l2;
        l2=l2.next;
      }
      current=current.next;
    }

    if(l1!=null){
      current.next=l1;
      l1=l1.next;
    }
    if(l2!=null){
      current.next=l2;
      l2=l2.next;
    }

    return dummy.next;
  }

  //function to print list
  private static void printList(Node head){
    List<Integer> result=new ArrayList<>();
    while(head!=null){
      result.add(head.val);
      head=head.next;
    }
    System.out.println(result);
  }

  //function to build list from array
  private static Node buildList(int[] arr){
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
    String[] l1Str=sc.nextLine().trim().split("\\s+");
    int[] l1Arr=Arrays.stream(l1Str).mapToInt(Integer::parseInt).toArray();
    String[] l2Str=sc.nextLine().trim().split("\\s+");
    int[] l2Arr=Arrays.stream(l2Str).mapToInt(Integer::parseInt).toArray();

    Node l1=buildList(l1Arr);
    Node l2=buildList(l2Arr);

    Node l3=mergeList(l1,l2);
    printList(l3);
    sc.close();
    
  }
  
}