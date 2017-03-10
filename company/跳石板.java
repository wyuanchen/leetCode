/*
小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
例如：
N = 4，M = 24：
4->6->8->12->18->24
于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板 

输入描述:
输入为一行，有两个整数N，M，以空格隔开。
(4 ≤ N ≤ 100000)
(N ≤ M ≤ 100000)

输出描述:
输出小易最少需要跳跃的步数,如果不能到达输出-1


输入例子:
4 24

输出例子:
5
*/


//动态规划
//设dp[i]是第 N + i 个台阶，则 dp[i] = min(dp[t] + 1), 0 <= t < i, 表示小易是从第 N + t 个台阶进行一次跳跃到第 N + i个台阶，
//且设step = i - t, 则 step 必须是 N + t 的一个约数
import java.util.*;
 
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N, M, min;
        while (scan.hasNextInt()){
            N = scan.nextInt();
            M = scan.nextInt();
            min = count(N, M);
            System.out.println("" + min);
        }
    }
     
    public static int count(int N, int M){
        int len = M - N + 1;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++){
        	dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        int curFloor, step, k;
        for (int i = 0; i < len - 1; i++){
        	if (dp[i] == Integer.MAX_VALUE){
        		continue;
        	}
            curFloor = i + N;
            for (step = 2; step <= Math.sqrt(curFloor) && i + step < len; step++){
            	if (curFloor % step != 0){
            		continue;
            	}
                k = i + step;
                if (k < len && dp[i] + 1 < dp[k]){
                    dp[k] = dp[i] + 1;                       
                }

                // try the other step
                k = i + curFloor / step;
                if (k < len && dp[i] + 1 < dp[k]){
                	dp[k] = dp[i] + 1;
                }
            }
        }
        if (dp[len - 1] != Integer.MAX_VALUE){
            return dp[len - 1];
        }       
        return -1;
         
    }
}