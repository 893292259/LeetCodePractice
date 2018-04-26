package Top100Liked;

import java.util.*;

public class Problem076 {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<t.length();i++){
            if (!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),0);
            }
            map.put(t.charAt(i),map.get(t.charAt(i))+1);
        }
        Queue<Character> queue = new LinkedList<>();
        String result = "";
        int count = 0;
        int j = 0;
        for (int i=0; i<s.length();i++){
           if (map.keySet().contains(s.charAt(i))) {
               Integer n = map.get(s.charAt(i));
               queue.add(s.charAt(i));
               n--;
               map.put(s.charAt(i),n);
               if (n>=0){
                  count++;
               }
               else {
                   char c = queue.peek();
                   while (!map.keySet().contains(c)||map.get(c)<0){
                       queue.remove();
                       if (map.keySet().contains(c)){
                           map.put(c,map.get(c)+1);
                       }
                       j++;
                       c = queue.peek();
                   }
               }
               if (count>=t.length()){
                   String res = s.substring(j,i+1);
                   if (result.equals("")||result.length()>res.length()){
                       result = res;
                   }
               }
           }
           else {
               if (queue.isEmpty()) {
                    j++;
               }
               else {
                   queue.add(s.charAt(i));
               }
           }
        }
        return result;
    }
    public static void main(String... args){
        Problem076 main = new Problem076();
        String s ="ab";
        String t = "b";
        System.out.println(main.minWindow(s,t));
    }
}
