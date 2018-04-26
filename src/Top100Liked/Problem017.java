package Top100Liked;

import java.util.ArrayList;
import java.util.List;

public class Problem017 {
    public void process(int position, List<String> result,String current,String digits){
        if (position==digits.length()){
            if (!current.equals("")) {
                result.add(current);
            }
            return;
        }
        else {
            char digit = digits.charAt(position);
            switch (digit){
                case '2':
                    process(position+1,result,current+"a",digits);
                    process(position+1,result,current+"b",digits);
                    process(position+1,result,current+"c",digits);
                    break;
                case '3':
                    process(position+1,result,current+"d",digits);
                    process(position+1,result,current+"e",digits);
                    process(position+1,result,current+"f",digits);
                    break;
                case '4':
                    process(position+1,result,current+"g",digits);
                    process(position+1,result,current+"h",digits);
                    process(position+1,result,current+"i",digits);
                    break;
                case '5':
                    process(position+1,result,current+"j",digits);
                    process(position+1,result,current+"k",digits);
                    process(position+1,result,current+"l",digits);
                    break;
                case '6':
                    process(position+1,result,current+"m",digits);
                    process(position+1,result,current+"n",digits);
                    process(position+1,result,current+"o",digits);
                    break;
                case '7':
                    process(position+1,result,current+"p",digits);
                    process(position+1,result,current+"q",digits);
                    process(position+1,result,current+"r",digits);
                    process(position+1,result,current+"s",digits);
                    break;
                case '8':
                    process(position+1,result,current+"t",digits);
                    process(position+1,result,current+"u",digits);
                    process(position+1,result,current+"v",digits);
                    break;
                case '9':
                    process(position+1,result,current+"w",digits);
                    process(position+1,result,current+"x",digits);
                    process(position+1,result,current+"y",digits);
                    process(position+1,result,current+"z",digits);
                    break;
                default:
                    process(position+1,result,current,digits);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result  = new ArrayList<>();
        process(0,result,"",digits);
        return result;
    }
    public static void main(String... args){
        Problem017 main = new Problem017();
        String digits = "23";
        System.out.println(main.letterCombinations(digits).toString());
    }

}
