package Top100Liked;

public class Problem200 {
    boolean[][] isChecked;
    char[][] map;
    int m,n;
    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid.length>0) {
            m = grid.length;
            n = grid[0].length;
            map = grid;
            isChecked = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1' && !isChecked[i][j]) {
                        num++;
                        searchIsland(i, j);
                    }
                }
            }
        }
        return num;
    }

    public void searchIsland(int x,int y){
        isChecked[x][y] = true;
        if (x>=1 && map[x-1][y]=='1' && !isChecked[x-1][y] ){
            searchIsland(x-1,y);
        }
        if (y>=1 && map[x][y-1]=='1'&& !isChecked[x][y-1]){
            searchIsland(x,y-1);
        }
        if (x<m-1 && map[x+1][y]=='1'&& !isChecked[x+1][y]){
            searchIsland(x+1,y);
        }
        if (y<n-1 && map[x][y+1]=='1' && !isChecked[x][y+1]){
            searchIsland(x,y+1);
        }
    }
    public static void main(String... args){
        Problem200 main = new Problem200();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'},{'1','1','1','0','0'}};
        System.out.println(main.numIslands(grid));
    }
}
