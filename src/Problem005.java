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

    public String longestPalindrome2(String s) {
        String a =s;
        String b = new StringBuffer(s).reverse().toString();
        int[][] datas = new int[a.length()][b.length()];
        int i,j;
        int max=0;
        int end1=-1;
        for (i=0;i<a.length();i++){
            datas[i][0] = a.charAt(i)==b.charAt(0)? 1:0;
        }
        for (j=0;j<b.length();j++){
            datas[0][j] = a.charAt(0)==b.charAt(j)? 1:0;
        }
        for (i=1;i<a.length();i++){
            for (j=1;j<b.length();j++){
                datas[i][j]=a.charAt(i)==b.charAt(j)?datas[i-1][j-1]+1:0;
            }
        }
        for (i=0;i<a.length();i++) {
            for (j = 0; j < b.length(); j++) {
                if (datas[i][j]>max&&i+j+2-datas[i][j]==s.length()){
                    max = datas[i][j];
                    end1 = i;
                }
            }
        }
        return a.substring(end1-max+1,end1+1);
    }

    public static void main(String... args){
        Problem005 main = new Problem005();
        String s = "cbbd";
        String sub =  main.longestPalindrome2(s);
        System.out.println(sub);
    }
}
