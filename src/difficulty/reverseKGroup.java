package difficulty;

import utils.ListNode;

/**
 * @author:yuze
 * @description:K个一组反转链表
 * @data:2022/2/11
 */
public class reverseKGroup {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        l1.next = l2;
//        ListNode[] reverse = reverse(l1, l2);
//        System.out.println(reverse[0] +" + " + reverse[1]);
        ListNode head = null,tail = null;
        for (int i = 0; i <arr.length ; i++) {
            ListNode no = new ListNode(arr[i]);
            if(head == null){
                head = no;
                tail = head;
            }else {
                tail.next = no;
                tail = tail.next;
            }
        }
        ListNode listNode = reverseKGroup(head, 2);
        System.out.println(listNode);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        ListNode pre = hair;
        hair.next = head;
        while (head != null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if(tail != null){
                    return hair.next;
                }
            }
            ListNode nex= tail.next;
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }
    public static ListNode[] reverse(ListNode head,ListNode tail){
//        ListNode cur = head.next;
        ListNode end = tail.next;
//        ListNode pre=head,next=null;
//        while (cur != end){
//            next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
        ListNode pre=null,next=null,cur=head;
        while (cur!=end){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail,head};
    }
}
