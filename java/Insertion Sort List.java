147. Insertion Sort List

    Total Accepted: 78425
    Total Submissions: 257427
    Difficulty: Medium

Sort a linked list using insertion sort.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head){
        if(head==null)
            return null;
        ListNode cur=null;
        ListNode pre=null;
        ListNode preHead=new ListNode(-1);
        ListNode next;
        cur=head;
        while(cur!=null){
            pre=preHead;
            for(;pre.next!=null&&pre.next.val<cur.val;pre=pre.next);
            next=cur.next;
            cur.next=pre.next;
            pre.next=cur;
            cur=next;

        }
        return preHead.next;
    }


}
