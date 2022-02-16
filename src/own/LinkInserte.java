package own;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:yuze
 * @description:链表插入方法
 * @data:2021/8/21
 */
public class LinkInserte {


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(change(arr));
    }
    /**
     *
     * 链表尾插法
     * @author yuze
     * @date 2022/1/16 16:11
     * @param [arr]
     * @return com.java.qcby.ListNode
     */
    public static ListNode weicha(int[] arr){
        ListNode head=null,tail=null;
        for (int i = 0; i < arr.length; i++) {
            ListNode no = new ListNode(arr[i]);
            if(head==null){
                head= no;
                tail = head;
            }else {
                tail.next = no;
                tail = tail.next;
            }
        }
        return head;
    }
    /**
     *
     * 链表头插法
     * @author yuze
     * @date 2022/1/16 16:12
     * @param [arr]
     * @return com.java.qcby.ListNode
     */
    public static ListNode toucha(int[] arr){
        ListNode l1 = new ListNode(arr[0]);
        for (int i = 1; i <arr.length ; i++) {
            ListNode no = new ListNode(arr[i]);
            no.next = l1;
            l1 = no;
        }
        return l1;
    }
    /**
     * 链表反转
     * @author yuze
     * @date 2022/1/12 19:40
     * @param [list]
     * @return com.java.qcby.ListNode
     */
    public static ListNode linkedListInversion(ListNode list){
        if (list == null || list.next== null){
            return list;
        }
        ListNode preNode = null;
        ListNode curNode = list;
        ListNode nextNode = null;
        while (curNode!=null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    /**
     *
     * 判断单链表是否有环,标记法
     * @author yuze
     * @date 2022/1/12 19:50
     * @param [list]
     * @return boolean
     */
    public static boolean judgmentRing(ListNode list){
        Set<ListNode> set = new HashSet<>();
        ListNode head = list;
        while (head != null){
            if(set.contains(head)){
                return true;
            }else {
                set.add(head);
                head=head.next;
            }
        }
        return false;
    }
    /**
     *
     * 判断单链表是否有环,快慢指针法，快指针一次走两个，慢指针一次走一个，如果有环两个指针终会相遇
     * @author yuze
     * @date 2022/1/12 19:50
     * @param [list]
     * @return boolean
     */
    public static boolean judgmentRing2(ListNode list){
        ListNode fast = list;
        ListNode slow = list;
        while (fast !=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
            if(fast == slow){
                ListNode ptr = list;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return true;
            }
        }
        return false;
    }
    public static ListNode change(int[] arr){//链表反转
        ListNode head =null,tail=null;
        for (int i = 0; i < arr.length; i++) {
            ListNode no = new ListNode(arr[i]);
            if(head==null){
                head = no;
                tail = head;
            }else {
                tail.next = no;
                tail = tail.next;
            }
        }
        System.out.println(head);
        ListNode pre=null,next=null,cur=head;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static ListNode Ringaddress(ListNode list){
        Set<ListNode> set = new HashSet<>();
        ListNode head = list;
        while (head != null){
            if(set.contains(head)){
                return head;
            }else {
                set.add(head);
                head=head.next;
            }
        }
        return null;
    }
    /**
     *
     * 快慢指针法返回成环节点
     * @author yuze
     * @date 2022/1/16 17:40
     * @param [head]
     * @return com.java.qcby.ListNode
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast !=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
            if(fast == slow){
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    /**
     *
     * 返回链表的环长
     * @author yuze
     * @date 2022/2/14 9:30
     * @param [head]
     * @return int
     */
    public int getLen(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast !=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
            if(fast == slow) break;
        }
        if(fast==null||fast.next==null) return 0;
        int len = 1;
        fast = fast.next.next;
        slow=slow.next;
        while (fast != slow){
            fast = fast.next.next;
            slow=slow.next;
            len++;
        }
        return len;
    }
}
