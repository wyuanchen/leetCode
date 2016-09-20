题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空


//java,时间复制度O(n)
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
            return null;
        RandomListNode p1=null,p2=null,newHead=null;

        //先从头到尾复制一遍链表，并且把新的节点插入到原节点的后面
        for(p1=pHead;p1!=null;){
            p2=new RandomListNode(p1.label);
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
        }

        //给每个新节点的random指针进行复制
        for(p1=pHead;p1!=null;){
            p2=p1.random;
            p2=(p2==null)?null:p2.next;
            p1.next.random=p2;
            p1=p1.next.next;
        }

        //把原链表和新链表分离出来
        newHead=pHead.next;
        for(p1=pHead,p2=p1.next;;){
            p1.next=p2.next;
            p1=p1.next;
            if(p1==null)
                break;
            p2.next=p1.next;
            p2=p2.next;
        }

        return newHead;
    }
}
