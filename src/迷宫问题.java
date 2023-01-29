import java.util.Scanner;
//5 4
//        0 0 1 0
//        0 0 0 0
//        0 0 1 0
//        0 1 0 0
//        0 0 0 1
//        1 1 4 3
public class 迷宫问题 {
    static int row,col,sum=Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] vis;
    static int start_x,start_y,end_x,end_y;
    static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        row=scanner.nextInt();
        col=scanner.nextInt();
        map = new int[row][col];
        vis = new boolean[row][col];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                map[i][j]=scanner.nextInt();
            }
        start_x= scanner.nextInt()-1;
        start_y= scanner.nextInt()-1;
        end_x = scanner.nextInt()-1;
        end_y = scanner.nextInt()-1;
        dfs(start_x, start_y, 0);
        System.out.println(sum);
    }

    private static void dfs(int startX, int startY, int i) {
        if(startX==end_x&&startY==end_y){
            if(i<=sum) sum=i;
        }
        for(int j=0;j<dir.length;j++){
            int next_x=startX+dir[j][0];
            int next_y=startY+dir[j][1];
                if(next_x>=0 && next_x<row && next_y<col &&next_y>=0){
                    if(vis[next_x][next_y]==false&&map[next_x][next_y]==0){
                        vis[next_x][next_y] = true;
                        dfs(next_x, next_y, i+1);
                        vis[next_x][next_y] = false;
                    }
                }
        }
        return;
    }
}
