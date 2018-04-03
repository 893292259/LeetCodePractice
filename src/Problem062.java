public class Problem062 {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        int i,j;
        for (i=0;i<n;i++){
            paths[0][i] = 1;
        }
        for (j=1;j<m;j++){
            paths[j][0] = 1;
        }
        for (j=1;j<m;j++){
            for (i=1;i<n;i++){
                paths[j][i] = paths[j-1][i]+paths[j][i-1];
            }
        }
        return paths[m-1][n-1];
    }

    public static void main(String... args){
        Problem062 main = new Problem062();
        System.out.println(main.uniquePaths(3,7));
    }
}
