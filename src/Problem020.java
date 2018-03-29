import java.util.*;

public class Problem020 {


    class item{
        char type;
        int num;
        public item(char type, int num) {
            this.type = type;
            this.num = num;
        }
    }
    public boolean isValid(String s) {
        Stack<item> stack  = new Stack<>();
        Map<Character,Character> inStack = new HashMap<>();
        inStack.put(']','[');
        inStack.put('}','{');
        inStack.put(')','(');
        for (int i=0; i<s.length();i++){
            char current = s.charAt(i);
            if (inStack.containsValue(current)) {
                if (stack.empty()||stack.peek().type!=current){
                    stack.push(new item(current,1));
                }
                else {
                    stack.peek().num++;
                }
            }
            else{
                if (stack.empty()||stack.peek().type!=inStack.get(current)){
                    return false;
                }
                else{
                    stack.peek().num--;
                    if (stack.peek().num==0){
                        stack.pop();
                    }
                }
            }
        }
        return stack.empty();
    }
    public static void main (String... args){
        Problem020 main = new Problem020();
        String s = "{[]";
        System.out.println(main.isValid(s));
    }
}
