//请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};
*/

/*思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
* 左子树的右子树和右子树的左子树相同即可，采用递归
* 非递归也可，采用栈或队列存取各级子树根节点
*/
class Solution {
public:
    bool isSymmetrical(TreeNode* pRoot)
    {
        if(pRoot==NULL)
            return true;
        return symmetricalHelp(pRoot->left,pRoot->right);
    }

    bool symmetricalHelp(TreeNode *p1,TreeNode *p2){
        if(p1==NULL&&p2==NULL)
            return true;
        else if(p1==NULL||p2==NULL)
            return false;
        else if(p1->val==p2->val)
            return symmetricalHelp(p1->left,p2->right)&&symmetricalHelp(p1->right,p2->left);
        else
            return false;
    }

};
