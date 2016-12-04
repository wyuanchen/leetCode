//给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

/*
struct TreeLinkNode {
    int val;
    struct TreeLinkNode *left;
    struct TreeLinkNode *right;
    struct TreeLinkNode *next;
    TreeLinkNode(int x) :val(x), left(NULL), right(NULL), next(NULL) {

    }
};
*/
class Solution {
public:
    TreeLinkNode* GetNext(TreeLinkNode* pNode)
    {
     	  if(pNode==NULL)
            return pNode;
        //先判断有没有右子树
        if(pNode->right!=NULL){
            pNode=pNode->right;
            while(pNode->left!=NULL){
                pNode=pNode->left;
            }
            return pNode;
        }
        //如果没有右子树，则往上查找
        TreeLinkNode *pre=pNode;
        pNode=pNode->next;
        while(pNode!=NULL){
            //判断之前已访问过的节点是不是他父节点的左子树
            if(pNode->left!=NULL&&pNode->left==pre){
                return pNode;
            }else{
                //如果不是则继续往上查找
                pre=pNode;
                pNode=pNode->next;
            }
        }
        return NULL;
    }
};
