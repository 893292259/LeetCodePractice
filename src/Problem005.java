public class Problem005{
    public String longestPalindrome(String s) {
        int[][] longest = new int[s.length()][s.length()];
        for (int i=0; i<s.length();i++){
            longest[i][i]=1;
        }
        int maxStart=0;
        int maxEnd=0;
        for (int i=0; i<s.length()-1;i++){
            if (s.charAt(i)==s.charAt(i+1)){
                longest[i][i+1]=2;
                if (maxEnd-maxStart<1) {
                    maxStart = i;
                    maxEnd = i + 1;
                }
            }
        }
        boolean flag = true;
        int i = 2;
        while (flag&&i<s.length()){
            flag = false;
            for (int j=0;j+i<s.length();j++){
                if (s.charAt(j)==s.charAt(j+i) && longest[j+1][j+i-1]==i-1){
                    longest[j][j+i] =  i+1;
                    flag = true;
                    if (maxEnd-maxStart<i){
                        maxStart = j;
                        maxEnd = j+i;
                    }
                }
            }
            i+=2;
        }
        flag = true;
        i = 3;
        while (flag&&i<s.length()){
            flag = false;
            for (int j=0;j+i<s.length();j++){
                if (s.charAt(j)==s.charAt(j+i) && longest[j+1][j+i-1]==i-1){
                    longest[j][j+i] =  i+1;
                    flag = true;
                    if (maxEnd-maxStart<i){
                        maxStart = j;
                        maxEnd = j+i;
                    }
                }
            }
            i+=2;
        }

        return s.substring(maxStart,maxEnd+1);
    }

    public static void main(String... args){
        Problem005 main = new Problem005();
        String s = "cbbd";
        String sub =  main.longestPalindrome(s);
        System.out.println(sub);
    }
}
