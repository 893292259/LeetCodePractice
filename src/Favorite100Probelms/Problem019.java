package Favorite100Probelms;

import DataStructures.ListNode;

public class Problem019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode cursor = head;
            for (int i = 0; i < n; i++) {
                if (cursor.next==null) {
                    return head.next;
                }
                else {
                    cursor = cursor.next;
                }
            }
            ListNode target = head;
            while (cursor.next != null) {
                cursor = cursor.next;
                target = target.next;
            }
            if (target.next.next != null) {
                target.next = target.next.next;
            } else {
                target.next = null;
            }
            return head;
    }

    public static void main(String... args){
        Problem019 main = new Problem019();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        main.removeNthFromEnd(a1,2);
    }
}
