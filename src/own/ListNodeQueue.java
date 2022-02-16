package own;

import utils.ListNode;

/**
 * @author:yuze
 * @description:用链表作队列
 * @data:2022/1/16
 */
public class ListNodeQueue {
    ListNode head;//头节点
    ListNode tail;//尾节点
    int count;//队列元素数量
    int size;//队列大小
    public ListNodeQueue() {//无参构造函数初始化队列
        this.head = null;
        this.tail=null;
        this.count = 0;
        this.size = 10;
    }
    public ListNodeQueue(int size) {//构造函数指定队列大小
        this.head=null;
        this.tail=null;
        this.count=0;
        this.size=size;
    }
    public boolean isFull(){//判断队列是否已满
        if(count==size){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){//判断队列是否空
        if(count==0){
            return true;
        }
        return false;
    }
    public void add(int val){//给队列添加元素
        if(this.isFull()){
            throw new RuntimeException("queue is full");
        }
        ListNode l = new ListNode(val);
        if(head==null){
            head = l;
            tail = head;
        }else {
            tail.next = l;
            tail = tail.next;
        }
        count++;
    }
    public int delete(){//给队列删除元素
        if(this.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        int val = head.val;
        head = head.next;
        count--;
        return val;
    }
    public int peak(){
        if(this.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return head.val;
    }

    public static void main(String[] args) {//测试一下
        int[] arr = {1,2,3,4,5,6,7};
        ListNodeQueue queue = new ListNodeQueue(10);
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        System.out.println(queue.peak());
        System.out.println(queue.delete());
        System.out.println(queue.peak());
    }
}
