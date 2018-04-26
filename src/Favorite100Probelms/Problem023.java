package Favorite100Probelms;

import DataStructures.ListNode;

public class Problem023 {
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

    public ListNode mergeKListsImpl(ListNode[] target,int count){
        if (count==1){
            return target[0];
        }
        else{
            int i;
            for (i=0;i<count/2;i++){
                 target[i]=(mergeTwoLists(target[2*i],target[2*i+1]));
            }
            if (count%2==1){
                target[i]=target[count-1];
                i++;
            }
            return mergeKListsImpl(target,i);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        else {
            return mergeKListsImpl(lists, lists.length);
        }
    }
    public static void main(String... args){
        Problem023 main = new Problem023();
        ListNode a1 = new ListNode(7);
        ListNode a2 = new ListNode(-6);
        ListNode a3 = new ListNode(-6);
        ListNode b1 = new ListNode(-9);
        ListNode b2 = new ListNode(-10);
        ListNode b3 = new ListNode(-5);
        ListNode[] param = new ListNode[6];
        param[0] = a1;
        param[1] = a2;
        param[2] = a3;
        param[3] = b1;
        param[4] = b2;
        param[5] = b3;
        main.mergeKLists(param);
    }
}
