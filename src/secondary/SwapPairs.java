package secondary;

import utils.ListNode;

/**
 * @author:yuze
 * @description:两两交换链表中的节点
 * @data:2021/8/29
 */
public class SwapPairs {
    public static ListNode swapPairs(ListNode node){
        ListNode head = node;
        if(head==null){
            return null;
        }
        while (head!=null){
            if(head.next!=null){
                int x = head.val;
                head.val=head.next.val;
                head.next.val=x;
                head = head.next.next;
            }else {
                return node;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode tail = null;

        int[] arr = {};
        for (int i = 0; i < arr.length; i++) {
            ListNode no =new ListNode(arr[i]);
            if(head==null){
                head=no;
                tail=head;
            }else {
                tail.next=no;
                tail=tail.next;
            }
        }
        ListNode listNode = swapPairs(head);
        System.out.println(listNode);

    }
}
