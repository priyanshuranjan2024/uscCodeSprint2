package day42;
import java.util.*;

class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val){
    this.val=val;
  }
}

public class BST{

    public static TreeNode sortedArrayToBST(int[] nums){
        return buildBST(nums,0,nums.length-1);
    }

  private static TreeNode buildBST(int[] nums,int left,int right){
    if(left>right) return null;
    int mid=left+(right-left)/2;
    TreeNode root=new TreeNode(nums[mid]);
    root.left=buildBST(nums,left,mid-1);
    root.right=buildBST(nums,mid+1,right);
    return root;
  }

  private static List<Integer> levelOrder(TreeNode root){
    List<Integer> result=new ArrayList<>();
    if(root==null) return result;
    Queue<TreeNode> queue=new LinkedList<>();
    queue.offer(root);

    while(!queue.isEmpty()){
      TreeNode node=queue.poll();
      if(node!=null){
        result.add(node.val);
        queue.offer(node.left);
        queue.offer(node.right);
      }else{
        result.add(null);
      }
    }

    int i=result.size()-1;
    while(i>=0 && result.get(i)==null){
      result.remove(i--);
    }

    return result;
  }

  
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String inputLine=sc.nextLine();
    String[] parts=inputLine.split(",");

    int[] nums=new int[parts.length];
    for(int i=0;i<parts.length;i++){
      nums[i]=Integer.parseInt(parts[i]);
    }

    TreeNode root=sortedArrayToBST(nums);
    List<Integer> result=levelOrder(root);
    System.out.println(result);
    sc.close();
  }
}