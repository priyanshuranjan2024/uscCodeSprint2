package day41;
import java.util.*;

class Node{
  int val;
  Node left;
  Node right;
  Node(int val){
    this.val=val;
  }
}

public class DeepRoot{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String inputLine=sc.nextLine();
    sc.close();

    Node root=buildTree(inputLine.split(" "));
    int maxDepth=depth(root);
    System.out.println(maxDepth);
    
  }

  private static Node buildTree(String[] values){
    if(values.length==0 || values[0].equals("null")) return null;

    Node root=new Node(Integer.parseInt(values[0]));
    Queue<Node> queue=new LinkedList<>(); //for level order traversal
    queue.add(root);
    int i=1;

    while(i<values.length){
      Node current=queue.poll();

      if(i<values.length && !values[i].equals("null")){
        current.left=new Node(Integer.parseInt(values[i]));
        queue.add(current.left);
      }
      i++;

      if(i<values.length && !values[i].equals("null")){
        current.right=new Node(Integer.parseInt(values[i]));
        queue.add(current.right);
      }
      i++;
    }

    return root;
  }

  private static int depth(Node root){
    if(root==null) return 0;
    int left=depth(root.left);
    int right=depth(root.right);
    return Math.max(left,right)+1;
  }
}



