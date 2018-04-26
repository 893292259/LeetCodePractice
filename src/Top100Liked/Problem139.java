package Top100Liked;

import java.util.ArrayList;
import java.util.List;

public class Problem139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] data = new boolean[s.length()+1];
        data[0] = true;
        for (int i=1;i<=s.length();i++){
            data[i] = false;
            for (int j=0;j<i;j++){
                if (data[j]&&wordDict.contains(s.substring(j,i))){
                    data[i]=true;
                    break;
                }
            }
        }
        return data[s.length()];
    }
    public static void main(String... args){
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        Problem139 main = new Problem139();
        wordDict.add("code");
        System.out.println(main.wordBreak("leetcode",wordDict));
    }
}
