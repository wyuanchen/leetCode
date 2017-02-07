题目描述
小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。每门课由平时成绩和考试成绩组成，满分为r。现在他知道每门课的平时成绩为ai ,若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。

输入描述:
第一行三个整数n,r,avg(n大于等于1小于等于1e5，r大于等于1小于等于1e9,avg大于等于1小于等于1e6)，接下来n行，每行两个整数ai和bi，均小于等于1e6大于等于1


输出描述:
一行输出答案。

输入例子:
5 10 9
0 5
9 1
8 1
0 1
9 100

输出例子:
43





import java.util.*;

public class Main{
    public static void main(String[] args){
        int n,r,avg;
        int[] a,b;
        long time;
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            n=in.nextInt();
            r=in.nextInt();
            avg=in.nextInt();
            a=new int[n];
            b=new int[n];
            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
                b[i]=in.nextInt();
            }
            time=process(n,r,avg,a,b);
            System.out.println(time);
        }
    }
    
    public static long process(int n,int r,int avg,int[] a,int[] b){
        List<Integer> list=new ArrayList<>(n);
        for(int i=0;i<n;i++)
            list.add(i);
        final int[] bb=b;
        Collections.sort(list,new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                return bb[o1]-bb[o2];
            }           
        });
        int sum=n*avg;
        long time=0;
        int index;
        int score;
        for(int i=0;i<n;i++)
            sum-=a[i];
        for(int i=0;i<n&&sum>0;i++){
            index=list.get(i);
            score=r-a[index];
            if (score>=sum) {
                time+=sum*b[index];
                break;
            }else{
                time+=score*b[index];
                sum-=score;
            }
        }
        return time;
    }
}