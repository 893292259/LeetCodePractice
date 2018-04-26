package Top100Liked;

public class Problem010 {

    public boolean isMatch(String s, String p) {
        s = "##"+s;
        p=  "##"+p;
        boolean[][] delta = new boolean[s.length()][p.length()];
        for (int i=0;i<s.length();i++){
            for (int j=0; j<p.length();j++){
                delta[i][j]=false;
            }
        }
        delta[0][0] = true;


        for (int i=1; i<s.length();i++){
            for (int j=1; j<p.length();j++){
                if (p.charAt(j)!='*'){
                    if (p.charAt(j)=='.'){
                        delta[i][j] = delta[i-1][j-1];
                    }
                    else{
                        delta[i][j] = delta[i-1][j-1]&&s.charAt(i)==p.charAt(j);
                    }
                }
                else{
                    if (s.charAt(i)==p.charAt(j-1)||p.charAt(j-1)=='.') {
                        if (s.charAt(i) == p.charAt(j - 1)) {
                            if (s.charAt(i - 1) == s.charAt(i)) {
                                delta[i][j] =  delta[i][j - 1] || delta[i - 1][j];
                            }
                            else {
                                delta[i][j] = delta[i][j - 1];
                            }
                        }
                        else{
                             delta[i][j]=delta[i-1][j]||delta[i][j-1];
                        }
                    }

                    if (j>=2){
                        delta[i][j]=delta[i][j]||delta[i][j-2];
                    }
                }
            }
        }
        return delta[s.length()-1][p.length()-1];
    }
    public static void main(String... args){
        Problem010 main = new Problem010();
        String s = "abcdede";
        String p = "ab.*de";
        boolean flag = main.isMatch(s,p);
        System.out.println(flag);
    }
}
