package Top100Liked;

import DataStructures.ListNode;

public class Problem206 {
    public ListNode reverseList(ListNode head) {
        if (head!=null&&head.next!=null){
            ListNode old =head;
            ListNode mid = head.next;
            head.next=null;
            ListNode cursor = mid.next;
            while (cursor!=null){
                mid.next=old;
                old=mid;
                mid = cursor;
                cursor = cursor.next;
            }
            mid.next = old;
            return mid;
        }
        else{
            return head;
        }
    }
    public static void main(String...args){
        Problem206 main = new Problem206();
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        head.next = a;
        main.reverseList(head);
    }
}
