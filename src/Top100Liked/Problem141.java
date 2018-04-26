package Top100Liked;

import DataStructures.ListNode;

public class Problem141 {
    public boolean hasCycle(ListNode head) {
        if (head!=null) {
            ListNode current = head;
            while (current.next != null) {
                if (current.val == Integer.MIN_VALUE) {
                    return true;
                }
                current.val = Integer.MIN_VALUE;
                current = current.next;
            }
        }
        return false;
    }
    public static void main(String... args){
        ListNode head = new ListNode(2);
        Problem141 main = new Problem141();
        System.out.println(main.hasCycle(head));
    }
}
