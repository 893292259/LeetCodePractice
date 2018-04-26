package DataStructures;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private ListNode first;
    private ListNode last;
    private Map <Integer,ListNode> pos;
    private Map<Integer,Integer> data;
    private int capacity;
    public LRUCache(int capacity) {
        data = new HashMap<>();
        pos = new HashMap<>();
        first = new ListNode(0);
        this.capacity = capacity;
    }

    public int get(int key) {
         if (data.containsKey(key)){
             refresh(key);
             return data.get(key);
         }
         else{
             return -1;
         }
    }

    public void put(int key, int value) {
        refresh (key);
        data.put(key,value);
        if (data.size()>capacity){
            delete();
        }
    }
    private void refresh (int key){
        if (!pos.containsKey(key)){
            ListNode node = new ListNode(key);
            if (last==null){
                first.next = node;
                last = node;
                pos.put(key,first);

            }
            else{
                pos.put(key,last);
                last.next = node;
                last = node;
            }

        }
        else{
            ListNode node = pos.get(key);
            if (node.next.next!=null) {
                pos.put(key, last);
                last.next = node.next;
                last = last.next;
                node.next = node.next.next;
                pos.put(node.next.val, node);
            }
        }
    }
    private void delete(){
        data.remove(first.next.val);
        pos.remove(first.next.val);
        first.next=first.next.next;
        pos.put(first.next.val,first);
    }
}
