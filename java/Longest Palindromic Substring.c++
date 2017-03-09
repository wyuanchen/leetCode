/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example:
Input: "cbbd"
Output: "bb"
*/

class Solution {
public:
    string longestPalindrome(string s) {
        const int len = s.size();
        if (len <= 1){
            return s;
        }
        string str = preProcess(s);
        int n = str.size();
        //mx是目前扫描过的所有回文串中最右边的边界，而id则是该边界所属于的回文串的对称轴的下标
        int id = 0, mx = 0;
        vector<int> p(n, 0);
        for (int i = 1; i < n - 1; i++){
            p[i] = mx > i ? min(mx - i, p[2 * id - i]) : 1;
            //在这里之所以不用进行越界判断，是因为字符串首部为^，尾部为$,都是唯一的一个字符
            while (str[i + p[i]] == str[i - p[i]]){
                p[i]++;
            }
            if (i + p[i] > mx){
                mx = i + p[i];
                id = i;
            }
        }
        int pivot = 0, maxLen = 0;

        for (int i = 1; i < n - 1; i++){
            if (maxLen < p[i]){
                pivot = i;
                maxLen = p[i];
            }
        }

        return s.substr((pivot - maxLen) / 2, maxLen - 1);
    }

    string preProcess(const string& s){
        int n = s.size();
        string res;
        res.push_back('^');
        res.push_back('#');
        for (int i = 0; i < n; i++){
            res.push_back(s[i]);
            res.push_back('#');
        }
        res.push_back('$');
        return res;
    }
};
