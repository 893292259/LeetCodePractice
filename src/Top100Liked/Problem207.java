package Top100Liked;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem207 {
    Map<Integer,HashSet<Integer>> map;
    int[] isSerached;
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        for (int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if (!map.keySet().contains(a)){
                map.put(a,new HashSet<>());
            }
            if (!map.keySet().contains(b)){
                map.put(b,new HashSet<>());
            }
            map.get(b).add(a);
        }
        while (true) {
            if (map.size()==0){
                return true;
            }
            else {
                Set<Integer> targetSet = map.keySet().stream().filter(a->map.get(a).isEmpty()).collect(Collectors.toSet());
                map.keySet().removeAll(targetSet);
                if (targetSet.size()==0){
                    return false;
                }
                else{
                    for ( int key : map.keySet()) {
                            map.get(key).removeAll(targetSet);
                    }
                }
            }
        }
    }
    public boolean hasCircle(int key){
        isSerached[key]=1;
        for (int i:map.get(key)){
            if (isSerached[i]==1){
                return true;
            }
            else if(isSerached[i]==0 && hasCircle(i)){
                return true;
            }
        }
        isSerached[key]=2;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        isSerached = new int[numCourses];
        for (int i=0;i<numCourses;i++){
            map.put(i,new HashSet<>());
        }
        for (int i=0;i<prerequisites.length;i++){
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for (int i=0;i<numCourses;i++){
            if (isSerached[i]==0&&hasCircle(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String... args){
        Problem207 main = new Problem207();
        int[][] prerequisites = {{0,1}};
        System.out.println(main.canFinish(2,prerequisites));
    }
    }
