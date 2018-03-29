import DataStructures.ListNode;

public class Problem021 {
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

    public static void main(String... args){
        Problem021 main = new Problem021();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a3;
        a2.next = a4;
        a4.next = a5;
        main.mergeTwoLists(a1,a2);
    }
}
