import DataStructures.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Problem148 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode initial = new ListNode(-1);
        ListNode cursor = initial;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                cursor.next = l1;
                cursor = cursor.next;
                l1=l1.next;
            }
            else{
                cursor.next = l2;
                cursor = cursor.next;
                l2=l2.next;
            }
        }
        cursor.next = l1==null? l2:l1;
        return initial.next;
    }
    public ListNode sortList(ListNode head) {
        if (head!=null && head.next!=null) {
            ListNode l = head;
            ListNode r = head.next;
            ListNode startl = l;
            ListNode startr = r;
            head = head.next.next;
            while (head != null && head.next != null) {
                    l.next = head;
                    l = l.next;
                    r.next = head.next;
                    r = r.next;
                    head = head.next.next;
            }
            if (head != null) {
                    l.next = head;
                    l = l.next;
            }
            l.next = null;
            r.next = null;
            l = sortList(startl);
            r = sortList(startr);
            return mergeTwoLists(l, r);
        }
        else {
            return head;
        }
    }
    public static void main(String... args){
        ListNode head = new ListNode(4);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(3);
        head.next = a;
        a.next = b;
        b.next = c;
        Problem148 main = new Problem148();
        main.sortList(head);
        return;
    }
}
