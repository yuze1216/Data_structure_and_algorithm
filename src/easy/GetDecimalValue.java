package easy;

import utils.ListNode;

/**
 * @author:yuze
 * @description:力扣：1290，二进制链表转整数
 * @data:2021/8/23
 */
public class GetDecimalValue {
    public static int getDecimalValue(ListNode head) {
        ListNode curr = head;
        int ans = 0;
        while (curr!=null){
            ans = ans*2+curr.val;
            curr = curr.next;

        }
        return ans;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;
        head.next = new ListNode(0);
        head.next.next=new ListNode(1);
        System.out.println(head);
        System.out.println(getDecimalValue(head));
    }
}
