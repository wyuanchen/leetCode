// 145. Binary Tree Postorder Traversal
// Given a binary tree, return the postorder traversal of its nodes' values.
// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [3,2,1].

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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        TreeNode pre=null;
        TreeNode cur=root;
        TreeNode top=null;
        while(cur!=null||!stack.empty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                top=stack.peek();
                if(top.right!=null&&top.right!=pre){
                    cur=top.right;
                }else{
                    list.add(top.val);
                    pre=top;
                    stack.pop();
                }
            }
        }
        return list;
    }
}