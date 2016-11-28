Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

//空间复杂度O(N),时间复杂度O(N^2)
//编辑距离问题，动态规划
//edit[i][j] =      /    edit[i - 1][j - 1]                                                  if word1[i - 1] == word2[j - 1]
//                  \    min(edit[i - 1][j - 1], min(edit[i - 1][j], edit[i][j - 1])) + 1      else
//比较简单的是用一个2维数组才存储edit，不过再优化下就用一个一维数组来存储edit
class Solution {
public:
    int minDistance(string word1, string word2) {
        int *edit=new int[word2.size()+1];
        int len1=word1.length();
        int len2=word2.length();
        edit[0]=0;
        int temp,diag;
        for(int i=1;i<=len2;i++)
            edit[i]=i;
        for(int i=1;i<=len1;i++){
            diag=edit[0];
            edit[0]=i;
            for(int j=1;j<=len2;j++){
                if(word1[i-1]==word2[j-1]){
                    temp=edit[j];
                    edit[j]=diag;
                    diag=temp;
                }else{
                    temp=edit[j];
                    if(temp>edit[j-1])
                        temp=edit[j-1];
                    if(temp>diag)
                        temp=diag;
                    diag=edit[j];
                    edit[j]=temp+1;
                }
            }
        }
        int result=edit[len2];
        delete []edit;
        edit=NULL;
        return result;
    }
};
