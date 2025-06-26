package day42;
import java.util.*;

class Node{
  int val;
  Node left;
  Node right;
  Node(int val){
    this.val=val;
  }
}

public class CountNode{
  private static Node buildTree(List<Integer> nodes){
    if(nodes.isEmpty() || nodes.get(0)==null) return null;

    Node root=new Node(nodes.get(0));
    Queue<Node> queue=new LinkedList<>();
    queue.offer(root);

    int i=1;
    while(i<nodes.size()){
      Node curr=queue.poll();
      if(i<nodes.size() && nodes.get(i)!=null){
        curr.left=new Node(nodes.get(i));
        queue.offer(curr.left);
      }
      i++;

      if(i<nodes.size() && nodes.get(i)!=null){
        curr.right=new Node(nodes.get(i));
        queue.offer(curr.right);
      }
      i++;
    }

    return root;
  }

  public static int countNodes(Node root){
    if(root==null) return 0;

    int leftHeight=getLeftHeight(root);
    int rightHeight=getRightHeight(root);

    if(leftHeight==rightHeight){
      return (1<<leftHeight)-1;
    }

    return 1+countNodes(root.left)+countNodes(root.right);
  }

  private static int getLeftHeight(Node node){
    int height=0;
    while(node!=null){
      height++;
      node=node.left;
    }
    return height;
  }

  private static int getRightHeight(Node node){
    int height=0;
    while(node!=null){
      height++;
      node=node.right;
    }
    return height;
  }

  
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String inputline=sc.nextLine();
    String[] parts=inputline.split(",");

    List<Integer> nodeList=new ArrayList<>();

    for(String part:parts){
      if(part.equals("null")) nodeList.add(null);
      else nodeList.add(Integer.parseInt(part));
    }

    Node root=buildTree(nodeList);
    System.out.println(countNodes(root));
    sc.close();
  }
}
