import java.util.ArrayList;
import java.util.List;

public class Problem022 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n==0){
            result.add("");
        }
        else {
            for (int i=0;i<n;i++){
                for (String a: generateParenthesis(i)){
                    for (String b:generateParenthesis(n-i-1)){
                        result.add("("+a+")"+b);
                    }
                }
            }
        }
        return result;
    }
    public static void main(String... args){
        Problem022 main = new Problem022();
        System.out.println(main.generateParenthesis(3).toString());
    }
}
