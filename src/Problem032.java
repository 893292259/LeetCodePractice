public class Problem032 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int max = 0;
        int[][] data = new int[2*len+1][2];
        for (int i=0;i<2*len+1;i++){
            data[i][0] = -1;
        }
        data[len][0]=0;
        data[len][1]=0;
        int potential = len;
        for (int i=0;i<len;i++){
            if (s.charAt(i)=='('){
                potential++;
                data[potential][0]=i+1;
                data[potential][1]=i+1;
            }
           else{
                potential--;
                if (data[potential][0]!=-1){
                    data[potential][1]=i+1;
                    max = Math.max(data[potential][1]-data[potential][0],max);
                }
                else{
                    data[potential][0]=i+1;
                    data[potential][1]=i+1;
                }
                data[potential+1][0] = -1;
            }
        }
        return max;
    }
    public static void main (String... args){
        Problem032 main = new Problem032();
        String s = ")(((((()())()()))()(()))(";
        main.longestValidParentheses(s);
    }
}
