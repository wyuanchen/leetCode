/*
144. Binary Tree Preorder Traversal
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
return [1,2,3].

*/



// LeetCode, Binary Tree Preorder Traversal
// 使用栈，时间复杂度O(n)，空间复杂度O(n)

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
    public List<Integer> preorderTraversal(TreeNode node) {
     List<Integer> list = new LinkedList<Integer>();
    Stack<TreeNode> rights = new Stack<TreeNode>();
    while(node != null) {
        list.add(node.val);
        if (node.right != null) {
            rights.push(node.right);
        }
        node = node.left;
        if (node == null && !rights.isEmpty()) {
            node = rights.pop();
        }
    }
    return list;
    }
}




// LeetCode, Binary Tree Preorder Traversal
// Morris先序遍历，时间复杂度O(n)，空间复杂度O(1)
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
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> list=new LinkedList<Integer>();
        TreeNode cur=node;
        while(cur!=null){
            if(cur.left==null){
                list.add(cur.val);
                cur=cur.right;
            }else{
                for(node=cur.left;node.right!=null&&node.right!=cur;node=node.right);
                if(node.right!=cur){
                    list.add(cur.val);
                    node.right=cur;
                    cur=cur.left;
                }else{
                    node.right=null;
                    cur=cur.right;
                }
            }
        }
        return list;
    }
}