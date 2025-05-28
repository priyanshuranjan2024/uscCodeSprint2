package day13;
import java.util.*;

public class TaskDistribution{
  static class Node{
    int val;
    Node next;
    Node(int val){
      this.val=val;
      this.next=null;
    }
  }

    //splitting linked list into k parts
    //earlier parts should never be smaller than later parts
    private static Node[] splitList(Node head,int k){
      Node[] result=new Node[k];
      int length=0;
      Node curr=head;

      while(curr!=null){
        length++;
        curr=curr.next;
      }

      int baseSize=length/k;
      int extraNodes=length%k;

      curr=head;

      for(int i=0;i<k;i++){
        result[i]=curr;
        int size=baseSize+(i<extraNodes?1:0);
        for(int j=0;j<size-1 && curr!=null;j++) curr=curr.next;
        if(curr!=null){
          Node temp=curr.next;
          curr.next=null; //split
          curr=temp;
        }
      }

      return result;
      
    }

    private static Node createList(int[] arr){
      Node dummy=new Node(0);
      Node curr=dummy;
      for(int num:arr){
        curr.next=new Node(num);
        curr=curr.next;
      }

      return dummy.next;
    }

    //function to print in given format
    private static void printParts(Node[] parts){
      for(int i=0;i<parts.length;i++){
        Node node=parts[i];
        if(node==null){
          System.out.print("[]");
        }else{
          List<Integer> part=new ArrayList<>();
          while(node!=null){
            part.add(node.val);
            node=node.next;
          }
          System.out.print(part.toString());
        }

        //add commas between them
        if(i!=parts.length-1) System.out.print(", ");
      }
      System.out.println();
    }

    //main function
    public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      String[] values=sc.nextLine().trim().split("\\s+");
      int[] nums=Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
      int k=Integer.parseInt(sc.nextLine().trim());

      //create the list
      Node head=createList(nums);
      Node[] parts=splitList(head,k);
      printParts(parts);
      sc.close();
    }
  
}