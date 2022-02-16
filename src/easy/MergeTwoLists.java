package easy;

import utils.ListNode;

/**
 * @author:yuze
 * @description:合并两个有序链表
 * @data:2021/8/21
 */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);//开头哑节点
        ListNode prev = prehead;
        while (l1!=null && l2!=null){
            if(l1.val<=l2.val){
                prev.next=l1;
                l1 = l1.next;
            }else {
                prev.next=l2;
                l2 = l2.next;
            }
            prev=prev.next;
        }
        prev.next = l1==null?l2:l1;
        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        int[] arr= {4,2,1};
        l1.val = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            ListNode no = new ListNode(arr[i]);
            no.next = l1;
            l1 = no;
        }

        ListNode l2 = new ListNode();
        int[] arr2= {4,3,1};
        l2.val = arr2[0];
        for (int i = 1; i <arr2.length ; i++) {
            ListNode no = new ListNode(arr2[i]);
            no.next = l2;
            l2 = no;
        }
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(mergeTwoLists(l1,l2));
    }
}
