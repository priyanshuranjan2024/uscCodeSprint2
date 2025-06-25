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

public class MirrorTrees{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String line=sc.nextLine();
    sc.close();

    Node root=buildTree(line.split(" "));
    System.out.println(isSymmetric(root));
  }

  private static Node buildTree(String[] values){
    if(values.length==0 || values[0].equals("null")) return null;

    Node root=new Node(Integer.parseInt(values[0]));
    Queue<Node> queue=new LinkedList<>();
    queue.offer(root);
    int i=1;

    while(i<values.length){
      Node current=queue.poll();

      if(i<values.length && !values[i].equals("null")){
        current.left=new Node(Integer.parseInt(values[i]));
        queue.offer(current.left);
      }
      i++;

      if(i<values.length && !values[i].equals("null")){
        current.right=new Node(Integer.parseInt(values[i]));
        queue.offer(current.right);
      }
      i++;
    }

    return root;
    
  }

  private static boolean isSymmetric(Node root){
    if(root==null) return true;
    return isMirror(root.left,root.right);
  }

  private static boolean isMirror(Node a,Node b){
    if(a==null && b==null) return true;
    if(a==null || b==null) return false;

    return (a.val==b.val) && isMirror(a.left,b.right) && isMirror(a.right,b.left);
  }
}

