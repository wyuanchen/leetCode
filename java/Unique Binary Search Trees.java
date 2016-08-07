96. Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


//思路：假如让前i个数（也就是前i大的所有数）作为左子树，则左子树的所含节点数为i个，右子树的个数则为n-1-i个，
// 所以numTrees(n)=numTrees(0)*numTrees(n-1-0)+numTrees(1)*numTrees(n-1-1)+...+numTrees(n-1)*numTrees(n-1-(n-1)),
// 这里循环调用到n/2是为了防止超时
   public class Solution {
       public int numTrees(int n) {
           if(n<2)
               return 1;
           int sum=0;
           for(int i=0;i<n/2;i++){
               sum+=numTrees(i)*numTrees(n-1-i);
           }
           if(n%2==0)
               return 2*sum;
           else
               return 2*sum+numTrees(n/2)*numTrees(n-1-n/2);
       }
   }

//将其看做dp问题
public class Solution {
    public int numTrees(int n) {
      int [] G = new int[n+1];
      G[0] = G[1] = 1;

      for(int i=2; i<=n; ++i) {
     	  for(int j=1; j<=i; ++j) {
     		   G[i] += G[j-1] * G[i-j];
     	  }
      }

      return G[n];
    }
 }
