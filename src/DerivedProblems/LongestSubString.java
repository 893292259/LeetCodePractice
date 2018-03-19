package DerivedProblems;

public class LongestSubString {

    public String execute(String a,String b){
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
                if (datas[i][j]>max){
                    max = datas[i][j];
                    end1 = i;
                }
            }
        }
        return a.substring(end1-max+1,end1+1);
    }

    public static void main(String... args){
        LongestSubString main = new LongestSubString();
        String s1 = "dasdasfsafasf";
        String s2 = "fsafasdasdasd";
        String s = main.execute(s1,s2);
        System.out.println(s);
    }
}
