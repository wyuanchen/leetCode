Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

    You may only use constant extra space.

For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL





/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummyHead=new TreeLinkNode(0);
        //dummyHead.next用来记录每一层第一个节点
        TreeLinkNode pre=dummyHead;
        while(root!=null){
            if(root.left!=null){
                pre.next=root.left;
                pre=pre.next;
            }
            if(root.right!=null){
                pre.next=root.right;
                pre=pre.next;
            }
            root=root.next;
            if(root==null){
                //dummyHead.next用来记录每一层第一个节点，这样如果第i层的节点遍历完，则可以跳到下一层去
                root=dummyHead.next;
                //跳完后记得把dummyHead.next赋值为空，防止无限循环
                dummyHead.next=null;
                //pre被赋值为dummyHead后，第一次pre.next= 操作将会设置dummyHead.next，也就是下个层次的第一个节点
                pre=dummyHead;
            }
                
        }
    }
    
}