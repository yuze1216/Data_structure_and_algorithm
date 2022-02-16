package secondary;

import utils.ListNode;

/**
 * @author:yuze
 * @description:删除链表的倒数第N个节点
 * @data:2021/8/21
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);
        if(len==1){
            return null;
        }
        ListNode pre = new ListNode(0,head);
        ListNode l = pre;
        for (int i = 1; i <len - n +1; i++) {
            l = l.next;
        }
        l.next = l.next.next;
        return pre.next;
    }
    public static int getLength(ListNode head){
        int len =0;
        while (head!=null){
            len++;
            head=head.next;
        }
        return len;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode();
        int[] arr= {1,2,3,4,5};
        head.val = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            ListNode no = new ListNode(arr[i]);
            no.next = head;
            head = no;
        }
        System.out.println(head);
        System.out.println(removeNthFromEnd(head,1));
    }
}
