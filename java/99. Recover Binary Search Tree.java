Recover Binary Search Tree
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.

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
    public void recoverTree(TreeNode root) {
        TreeNode[] nodes=getNodes(root);
        int n1=-1,n2=-1;
        int i=0;
        for(;i<nodes.length-1;i++){
            if(nodes[i].val>nodes[i+1].val){
                n1=i;
                break;
            }
        }
        for(i=i+2;i<nodes.length;i++){
            if(nodes[i].val<nodes[i-1].val){
                n2=i;
                break;
            }
        }
        if(n2==-1){
            n2=n1+1;
        }
        int temp=nodes[n1].val;
        nodes[n1].val=nodes[n2].val;
        nodes[n2].val=temp;
    }
    private TreeNode[] getNodes(TreeNode root){
        List<TreeNode> list=new LinkedList<>();
        getNodesHelp(root,list);
        TreeNode[] nodes=new TreeNode[list.size()];
        for(int i=0;i<nodes.length;i++)
            nodes[i]=list.get(i);
        return nodes;
    }
    private void getNodesHelp(TreeNode root,List<TreeNode> list){
        if(root==null)
            return;
        getNodesHelp(root.left,list);
        list.add(root);
        getNodesHelp(root.right,list);
    }
}