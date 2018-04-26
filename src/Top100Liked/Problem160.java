package Top100Liked;

import DataStructures.ListNode;

public class Problem160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA!=null){
        ListNode tail = headA;
        while (tail.next!=null){
            tail=tail.next;
        }
        tail.next=headA;
        ListNode intersect = detectCycle(headB);
        tail.next=null;
        return intersect;
        }
        else{
            return null;
        }
    }
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
            Problem160 main = new Problem160();
            ListNode a = new ListNode(0);
            ListNode b = new ListNode(0);
            ListNode c = new ListNode(0);
            a.next = c;
            b.next = c;
            main.getIntersectionNode(a,b);
    }
}
