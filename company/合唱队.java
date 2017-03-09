/*
计算最少出列多少位同学，使得剩下的同学排成合唱队形
说明：
N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。

注意：不允许改变队列元素的先后顺序
*/


//动态规划求出以每个人结尾的左边和右边的最大队列长度
//我们用left[i]表示从左边起到第i个人结束的最长上升队列的人数，那么得到最优解的结构：left[i] = max{max(left[k] + 1), 1} 0<=k<=i-1 && a[k] < a[i]
//同样的，用right[i]表示从右边起到第i个人结束的最大上升队列的人数，得到：right[i] = max{max(right[k] + 1), 1} i + 1 <= k <= n - 1 && a[k] < a[i]

import java.util.*;

public class Main{
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
        int[] a;
        int n;
        while (scan.hasNextInt()){
            n = scan.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++){
                a[i] = scan.nextInt();
            }
            System.out.println("" + count(a, n));
        }
    }


    public static int count(int[] a, int n){
        if (a == null || n > a.length){
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++){
            left[i] = 1;
            for (int k = i - 1; k >= 0; k--){
                if (a[k] < a[i] && left[i] < left[k] + 1){
                    left[i] = left[k] + 1;
                }
            }
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--){
            right[i] = 1;
            for (int k = i + 1; k < n; k++){
                if (a[k] < a[i] && right[i] < right[k] + 1){
                    right[i] = right[k] + 1;
                }
            }
        }
		int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            if (max < left[i] + right[i] - 1){
                max = left[i] + right[i] - 1;
            }
        }
        return n - max;
    }



}
