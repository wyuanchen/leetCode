//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bccced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

//回溯法，DFS遍历
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
    	if(matrix==null||rows<=0||cols<=0||str==null)
            return false;
        boolean[] visited=new boolean[rows*cols];
		for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(matrix[r*cols+c]!=str[0])
                    continue;
				for(int i=0;i<visited.length;i++)
                    visited[i]=false;
                if(check(matrix,rows,cols,str,r,c,0,visited))
                    return true;
            }
        }
      	return false;
    }

    private boolean check(char[] matrix,int rows,int cols,char[] str,int r,int c,int index,boolean[] visited){
        if(r<0||r>=rows||c<0||c>=cols||visited[r*cols+c]==true||matrix[r*cols+c]!=str[index])
            return false;
        visited[r*cols+c]=true;
        if(index==str.length-1)
            return true;
        index++;
        return check(matrix,rows,cols,str,r-1,c,index,visited)
            ||check(matrix,rows,cols,str,r+1,c,index,visited)
            ||check(matrix,rows,cols,str,r,c-1,index,visited)
            ||check(matrix,rows,cols,str,r,c+1,index,visited);

    }
}
