//一个链表中包含环，请找出该链表的环的入口结点。

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

  private ListNode getMeetingNode(ListNode head) {
      ListNode slow = head.next;
      if(slow==null)
          return null;
      ListNode fast = slow.next;
      while (slow != null && fast != null) {
          if(slow==fast){
              return fast;
          }
          slow=slow.next;
          fast=fast.next;
          if(fast!=slow){
              fast=fast.next;
          }
      }
      return null;
  }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null)
            return pHead;
        ListNode meetingNode=getMeetingNode(pHead);
        if(meetingNode==null)
            return null;
//      得到环中的节点个数
        int loopLength=1;
        ListNode p1=meetingNode.next;
        while(p1!=meetingNode){
            ++loopLength;
            p1=p1.next;
        }
//      移动p1
        p1=pHead;
        for(int i=0;i<loopLength;i++){
            p1=p1.next;
        }
//      移动p1，p2
        ListNode p2=pHead;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}
