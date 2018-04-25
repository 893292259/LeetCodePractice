import DataStructures.ListNode;

public class Problem142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode slow2 = null;
        while (fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                break;
            }
        }
        return slow2;
    }
    public static void main(String... args){
        Problem142 main = new Problem142();
        ListNode head = new ListNode(2);
        main.detectCycle(head);
    }
}

