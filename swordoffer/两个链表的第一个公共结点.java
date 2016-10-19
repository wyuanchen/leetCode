  // 题目描述
  // 输入两个链表，找出它们的第一个公共结点。



//java
//时间复杂度O(n),空间复杂度O(1)
  /*
  public class ListNode {
      int val;
      ListNode next = null;

      ListNode(int val) {
          this.val = val;
      }
  }*/
  public class Solution {
      public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
          if(pHead1==null||pHead2==null)
              return null;
          int length1=getLength(pHead1);
          int length2=getLength(pHead2);
          if(length1>length2){
              while(length1>length2){
                pHead1=pHead1.next;
                length1--;
              }
          }else if(length1<length2){
              while(length1<length2){
                pHead2=pHead2.next;
                length2--;
              }
          }
          while(pHead1!=null){
              if(pHead1==pHead2)
                  return pHead1;
              pHead1=pHead1.next;
              pHead2=pHead2.next;
          }
          return null;
      }

      private int getLength(ListNode head){
          int length=0;
          while(head!=null){
              length++;
              head=head.next;
          }
          return length;
      }
  }




  //C++
  /*
struct ListNode {
	int val;
	struct ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};*/
class Solution {
public:
    ListNode* FindFirstCommonNode( ListNode *pHead1, ListNode *pHead2) {
        if(pHead1==NULL||pHead2==NULL)
            return NULL;
        int length1=getLength(pHead1);
        int length2=getLength(pHead2);
        ListNode* pLong=pHead1;
        ListNode* pShort=pHead2;
        int lengthDiff=length1-length2;
        if(lengthDiff<0){
            pLong=pHead2;
            pShort=pHead1;
            lengthDiff=-lengthDiff;
        }
        while(lengthDiff>0){
            pLong=pLong->next;
            lengthDiff--;
        }
        while(pLong!=NULL){
            if(pLong==pShort)
                return pLong;
            pLong=pLong->next;
            pShort=pShort->next;
        }
        return NULL;
    }

    int getLength(ListNode *pHead){
        int length=0;
        while(pHead!=NULL){
            length++;
            pHead=pHead->next;
        }
        return length;
    }
};
