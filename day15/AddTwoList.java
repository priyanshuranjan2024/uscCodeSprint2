package day15;
import java.util.*;

public class AddTwoList{
  static class Node{
    int val;
    Node next;
    Node(int val){
      this.val=val;
    }
  }

  private static Node addLinkedList(Node l1,Node l2){
    Node dummy=new Node(0);
    Node current=dummy;
    int carry=0;

    while(l1!=null || l2!=null || carry!=0){
      int sum=carry;

      if(l1!=null){
        sum+=l1.val;
        l1=l1.next;
      }
      if(l2!=null){
        sum+=l2.val;
        l2=l2.next;
      }

      carry=sum/10;
      current.next=new Node(sum%10);
      current=current.next;
    }

    return dummy.next;
  }

  //for building linked list
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

  //for printing the list
  private static void printList(Node head){
    List<Integer> result=new ArrayList<>();
    while(head!=null){
      result.add(head.val);
      head=head.next;
    }
    System.out.println(result);
  }

  //main function
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);

    String[] l1Str=sc.nextLine().trim().split("\\s+");
    int[] l1Arr=Arrays.stream(l1Str).mapToInt(Integer::parseInt).toArray();
    Node l1=buildList(l1Arr);

    String[] l2Str=sc.nextLine().trim().split("\\s+");
    int[] l2Arr=Arrays.stream(l2Str).mapToInt(Integer::parseInt).toArray();
    Node l2=buildList(l2Arr);

    Node l3=addLinkedList(l1,l2);
    printList(l3);
    sc.close();
  }
  
}