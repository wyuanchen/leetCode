/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/  

//KMP
public class Solution {
    public int strStr(String haystack, String needle){
 		if (haystack == null || needle == null){
 			return -1;
 		}
 		if (needle.length() == 0){
 			return 0;
 		}
 		char[] pattern = needle.toCharArray();
 		char[] str = haystack.toCharArray();
 		int[] next = getNext(pattern);
 		int sIndex = 0, pIndex = 0;
 		while (sIndex < str.length && pIndex < pattern.length){
 			if (str[sIndex] == pattern[pIndex]){
 				sIndex++;
 				pIndex++;
 			}else{
 				pIndex = next[pIndex];
 				if (pIndex == -1){
 					sIndex++;
 					pIndex++;
 				}
 			}
 		}
 		if (pIndex == pattern.length){
 			return sIndex - pIndex;
 		}else{
 			return -1;
 		}

    }


    private int[] getNext(char[] p){
   		int len = p.length;
   		int[] next = new int[len];
   		next[0] = -1;
   		int i = 0;
   		int k = -1;
   		while (i < len - 1){
   			if (k == -1 || p[i] == p[k]){
   				k++;
   				i++;
   				if (p[i] != p[k]){
   					next[i] = k;
   				}else{
   					next[i] = next[k];
   				}
   			}else{
   				k = next[k];
   			}
   		}
   		return next;
    }
}


