题目描述
输入一个链表，反转链表后，输出链表的所有元素。

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//时间复杂度 O(n)
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head==null)
            return head;
		ListNode pre=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
