//Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].



//-------------Solution-1  :  Morris Traversal------- NO RECURSION NO STACK-----------------
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur=root;
        TreeNode node=null;
        List<Integer> list=new LinkedList<>();
        while(cur!=null){
            if(cur.left==null){
                list.add(cur.val);
                cur=cur.right;
            }else{
                for(node=cur.left;node.right!=null&&node.right!=cur;node=node.right);
                if(node.right==null){
                    node.right=cur;
                    cur=cur.left;
                }else{
                    list.add(cur.val);
                    node.right=null;
                    cur=cur.right;
                }
            }
        }
        return list;
    }
}





// -----------------Solution-1  :   Use STACK-----------------------
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public List<Integer> inorderTraversal(TreeNode root){
      Stack<TreeNode> stack=new Stack<>();
      List<Integer> list=new LinkedList<>();
      while(root!=null||!stack.empty()){
          while(root!=null){
              stack.push(root);
              root=root.left;
          }
          root=stack.pop();
          list.add(root.val);
          root=root.right;
      }
      return list;
  }
    
}
