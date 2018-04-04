public class Problem072 {
    public int minDistance(String word1, String word2) {
        int[][] min = new int[word1.length()+1][word2.length()+1];
        int i,j;
        for (i=0;i<word1.length()+1;i++){
            min[i][0]=i;
        }
        for (j=0;j<word2.length()+1;j++){
            min[0][j]=j;
        }
        for (i=1;i<word1.length()+1;i++){
            for (j=1;j<word2.length()+1;j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    min[i][j]=min[i-1][j-1];
                }
                else{
                    min[i][j]=Math.min(Math.min(min[i-1][j]+1,min[i][j-1]+1),min[i-1][j-1]+1);
                }
            }
        }
        return min[word1.length()][word2.length()];
    }
    public static void main(String... args){
        Problem072 main = new Problem072();
        String word1 = "asssds";
        String word2 = "asss";
        System.out.println(main.minDistance(word1,word2));
    }
}
