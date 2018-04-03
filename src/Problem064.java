public class Problem064 {
    public int minPathSum(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        int[][] paths = new int[m][n];
        int i,j;
        paths[0][0] = grid[0][0];
        for (i=1;i<n;i++){
            paths[0][i] = paths[0][i-1]+grid[0][i];
        }
        for (j=1;j<m;j++){
            paths[j][0] = paths[j-1][0]+grid[j][0];
        }
        for (j=1;j<m;j++){
            for (i=1;i<n;i++){
                paths[j][i] = Math.min(paths[j-1][i],paths[j][i-1])+grid[j][i];
            }
        }
        return paths[m-1][n-1];
    }
    public static void main(String... args){
        Problem064 main = new Problem064();
        int[][] grid = new int[3][3];
        grid[0]= new int[]{1,3,1};
        grid[1]= new int[]{1,5,1};
        grid[2]= new int[]{4,2,1};
        System.out.println(main.minPathSum(grid));
    }
}
