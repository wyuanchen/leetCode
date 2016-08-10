21. Merge Two Sorted Lists

    Total Accepted: 144938
    Total Submissions: 397263
    Difficulty: Easy

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode preRoot=new ListNode(0);
        ListNode root=preRoot;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                root.next=l1;
                l1=l1.next;
            }else{
                root.next=l2;
                l2=l2.next;
            }
            root=root.next;
        }
        if(l1!=null)
            root.next=l1;
        else
            root.next=l2;
        return preRoot.next;
    }
}
