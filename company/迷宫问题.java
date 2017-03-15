/*
定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示： 

int maze[5][5] = {

        0, 1, 0, 0, 0,

        0, 1, 0, 1, 0,

        0, 0, 0, 0, 0,

        0, 1, 1, 1, 0,

        0, 0, 0, 1, 0,

};

它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
Input
一个N × M的二维数组，表示一个迷宫。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
Output
左上角到右下角的最短路径，格式如样例所示。
Sample Input
0 1 0 0 0
0 1 0 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0
Sample Output
(0, 0)
(1, 0)
(2, 0)
(2, 1)
(2, 2)
(2, 3)
(2, 4)
(3, 4)
(4, 4)
*/



//动态规划，也可以用BFS,DFS解决
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, M;
        int[][] map;
        while (sc.hasNext()){
            N = sc.nextInt();
            M = sc.nextInt();
            map = new int[N][M];
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    map[i][j] = sc.nextInt();
                    // if (map[i][j] == 1){
                        // map[i][j] = -1;
                    // }
                }
            }
            find(map, N, M);
            print(map, N - 1, M - 1);
        }
    }

    //2表示往上，3表示往左
    public static void find(int[][] map, int N, int M){
        for (int i = 1; i < N; i++){
            if (map[i][0] == 0 && (map[i - 1][0] > 1 || map[i - 1][0] == 0)){
                map[i][0] = 2;
            }else{
                map[i][0] = -1;
            }
        }
        for (int i = 1; i < M; i++){
            if (map[0][i] == 0 && (map[0][i - 1] > 1 || map[0][i - 1] == 0)){
                map[0][i] = 3;
            }else{
                map[0][i] = -1;
            }
        }
        for (int i = 1; i < N; i++){
            for (int j = 1; j < M; j++){
                if (map[i][j] == 0){
                    if (map[i - 1][j] > 1){
                        map[i][j] = 2;
                    }else if (map[i][j - 1] > 1){
                        map[i][j] = 3;
                    }else{
                        map[i][j] = -1;
                    }
                }else{
                    map[i][j] = -1;
                }
            }
        }
    }

    public static void print(int[][] map, int i, int j){
        if (map[i][j] > 0){
            if(map[i][j] == 2){
                print(map, i - 1, j);
            }else{
                print(map, i, j - 1);
            }
        }
        System.out.println("(" + i + "," + j + ")");
    }

}