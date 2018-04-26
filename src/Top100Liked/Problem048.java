package Top100Liked;

public class Problem048 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
            for (int i=len/2-1;i>=0;i--){
                for (int j = i;j<len-i-1;j++){
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[-j+len-1][i];
                    matrix[-j+len-1][i] = matrix[-i+len-1][-j+len-1];
                    matrix[-i+len-1][-j+len-1] = matrix[j][-i+len-1];
                    matrix[j][-i+len-1] = t;
                }
            }
        return;
    }

    public static void main(String... args){
        Problem048 main = new Problem048();
        int[][] matrix = new int[3][3];
        int[] a1={1,2,3};
        int[] a2={4,5,6};
        int[] a3={7,8,9};
        matrix[0] = a1;
        matrix[1] = a2;
        matrix[2] = a3;
        main.rotate(matrix);
    }
}
