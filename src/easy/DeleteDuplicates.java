package easy;

import utils.ListNode;

/**
 * @author:yuze
 * @description:删除排序链表中的重复元素
 * @data:2022/1/21
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,4,5,5,5,6,6,6};
        ListNode head=null,tail=null;
        for (int i = 0; i < arr.length; i++) {
            ListNode no = new ListNode(arr[i]);
            if(head == null){
                head = no;
                tail = head;
            }else {
                tail.next = no;
                tail = tail.next;
            }
        }
        System.out.println(deleteDuplicates(head));
     }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode list = head;
        while (list.next!=null){
            if(list.val == list.next.val){
                list.next = list.next.next;
            }else {
                list = list.next;
            }
        }
        return head;
    }
}
