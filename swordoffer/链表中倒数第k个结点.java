题目描述
输入一个链表，输出该链表中倒数第k个结点
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
//复杂度O(n),只需要遍历一次链表，注意k边界
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0)
            return null;
		ListNode temp=head;
        for(int i=0;i<k;i++){
            temp=temp.next;
            if(temp==null&&i<k-1)
                return null;
        }
        while(temp!=null){
            temp=temp.next;
            head=head.next;
        }
        return head;
    }
}
