import java.util.ArrayList;
import java.util.List;

public class Problem003 {



    public int lengthOfLongestSubstring(String s) {

        char[] data = s.toCharArray();
        int i;
        int[] flags = new int[257];
        for (i=1; i<257;i++){
            flags[i] = -1;
        }
        int maxSize = 0;
        int j = 0;
        for (i=0; i<data.length;i++)
        {
            int sample = (int) data[i];
            j = Math.max(flags[sample]+1,j);
            flags[sample] = i;  
            maxSize = Math.max(maxSize,i-j+1);
        }
        return  maxSize;
    }

    public static void main (String... args){
        Problem003 main = new Problem003();
        String s = "abcddbca";
        main.lengthOfLongestSubstring(s);
    }
}
