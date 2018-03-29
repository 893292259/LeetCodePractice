import DataStructures.ListNode;

public class Problem002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode initial = new ListNode(0);
        ListNode current = initial;
        int isCarry = 0;
        while (l1!=null || l2!=null||isCarry>0 ){
            int sum = (l1==null? 0:l1.val)+(l2==null? 0:l2.val)+isCarry;
            ListNode temp = new ListNode(sum%10);
            isCarry = sum/10;
            current.next = temp;
            current = current.next;
            l1 = l1==null? l1:l1.next;
            l2 = l2==null? l2:l2.next;
        }
        return initial.next;
    }



    public static void main(String... args){
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next = b3;
        Problem002 main = new Problem002();
        main.addTwoNumbers(a1,b1);
    }
}
