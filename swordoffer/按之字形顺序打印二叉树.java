//请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。


import java.util.ArrayList;
import java.util.Stack;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

//按之字形顺序打印二叉树需要两个栈。我们在打印某一行结点时，把下一层的子结点保存到相应的栈里。
//如果当前打印的是奇数层，则先保存左子结点再保存右子结点到一个栈里；如果当前打印的是偶数层，则先保存右子结点再保存左子结点到第二个栈里。
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null)
            return result;
        Stack<TreeNode> s1,s2;
        boolean left=true;
        s1=new Stack<TreeNode>();
        s2=new Stack<TreeNode>();
        ArrayList<Integer> row;
        TreeNode node;
        s1.push(pRoot);
        while(!s1.empty()||!s2.empty()){
            row=new ArrayList<Integer>();
            if(left){
                while(!s1.empty()){
                    node=s1.pop();
                    row.add(node.val);
                    if(node.left!=null)
                        s2.push(node.left);
                    if(node.right!=null)
                        s2.push(node.right);
                }
            }else{
                while(!s2.empty()){
                    node=s2.pop();
                    row.add(node.val);
                    if(node.right!=null)
                        s1.push(node.right);
                    if(node.left!=null)
                        s1.push(node.left);
                }
            }
            result.add(row);
            left=!left;
        }
        return result;
    }

}
