package secondary;

/**
 * @author:yuze
 * @description:两数之和
 * @data:2021/8/17
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 例：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null,tail=null;
        int carry = 0;
        while (l1!=null||l2!=null){
            int n1 = l1!=null?l1.val:0;
            int n2 = l2!=null?l2.val:0;
            int sum = n1 + n2 + carry;
            if(head==null){
                head = tail = new ListNode(sum%10);
            }else{
                int a = tail.val;
                tail.next = new ListNode(sum%10+a);
                tail = tail.next;
            }
            carry = sum/10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2=l2.next;
            }
        }
        if(carry>0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next=new ListNode(4);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        ListNode l =  addTwoNumbers(l1,l2);
//        System.out.println(l.val);
//        System.out.println(l.next.val);
//        System.out.println(l.next.next.val);
        ListNode link = null;
        int[] arr= {1,2,3,4,5};
        for (int i = 0; i <arr.length ; i++) {
            ListNode no = new ListNode(arr[i]);
            no.next = link;
            link = no;
        }
        System.out.println(link);
        ListNode p=link.next;
        ListNode q = link;
        ListNode r=null;
        link.next=null;
        while (p!=null){
         r = p.next;
         p.next = q;
         q = p;
         p = r;
        }
        link=q;
        System.out.println(link);
    }
}
