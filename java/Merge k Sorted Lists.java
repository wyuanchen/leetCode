23. Merge k Sorted Lists

    Total Accepted: 97158
    Total Submissions: 398596
    Difficulty: Hard

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 //使用分治法，不然会超时
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) return null;
		return mergeKListsHelper(lists,0, lists.length - 1);

    }
	public ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
		int listLength = lists.length;
		if(start > listLength - 1 || start > end)
			return null;
		if(end - start == 0)
			return lists[start];

		int mid = (end + start) / 2;
		ListNode firstHalfHead = mergeKListsHelper(lists, start, mid);
		ListNode secondHalfHead = mergeKListsHelper(lists, mid+1, end);
		return mergeTwoList(firstHalfHead,secondHalfHead);
	}
	public ListNode mergeTwoList(ListNode node1, ListNode node2)
	{
		ListNode preHead = new ListNode(0);
		ListNode runningHead = preHead;

		while(node1 != null && node2 != null)
		{
			if(node1.val >= node2.val)
			{
				runningHead.next = node2;
				node2 = node2.next;
			}

			else
			{
				runningHead.next = node1;
				node1 = node1.next;
			}

			runningHead = runningHead.next;
		}

		if(node1 == null)
		{
			runningHead.next = node2;
		}
		else
			runningHead.next = node1;
		return preHead.next;
	}
}
