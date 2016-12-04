//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5



/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) :
        val(x), next(NULL) {
    }
};
*/

//时间复杂度O(N)
class Solution {
public:
    ListNode* deleteDuplication(ListNode* pHead)
    {
		if(pHead==NULL||pHead->next==NULL)
            return pHead;
        ListNode *preHead=new ListNode(0);
        ListNode *p1=NULL,*p2=NULL,*cur=preHead;
        p1=pHead;
        p2=pHead->next;
        while(p1!=NULL){
            p2=p1->next;
            if(p2!=NULL&&p1->val==p2->val){
                while(p2!=NULL){
                    if(p1->val!=p2->val)
                        break;
                    p1=p1->next;
                    p2=p2->next;
                }
                p1=p1->next;
            }else{
                cur->next=p1;
                cur=cur->next;
                p1=p1->next;
            }
        }
        cur->next=NULL;
        pHead=preHead->next;
        delete preHead;
        preHead=NULL;
        return pHead;

    }
};
