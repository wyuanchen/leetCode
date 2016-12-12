// 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

//DFS思想,递归解决即可
public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<0||rows<=0||cols<=0)
            return 0;
        boolean[][] visited=new boolean[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
            	visited[i][j]=false;
        return movingHelp(threshold,rows,cols,0,0,visited);
    }

    private int movingHelp(int threshold,int rows,int cols,int r,int c,boolean[][] visited){
        if(r<0||r>=rows||c<0||c>=cols||visited[r][c]==true)
            return 0;
        visited[r][c]=true;
        if(!isValid(threshold,r,c))
            return 0;
        return 1
            +movingHelp(threshold,rows,cols,r-1,c,visited)
            +movingHelp(threshold,rows,cols,r+1,c,visited)
            +movingHelp(threshold,rows,cols,r,c-1,visited)
            +movingHelp(threshold,rows,cols,r,c+1,visited);
    }
    private boolean isValid(int threshold,int r,int c){
        int sum=0;
       	while(r>0){
            sum+=r%10;
            r/=10;
        }
        while(c>0){
            sum+=c%10;
            c/=10;
        }
        return sum<=threshold;
    }
}
