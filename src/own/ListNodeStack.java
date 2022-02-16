package own;

import utils.ListNode;

/**
 * @author:yuze
 * @description:用链表作栈
 * @data:2022/1/16
 */
public class ListNodeStack {
    ListNode head;//链表头节点
    int count;//栈内元素个数
    int size;//栈的大小

    public ListNodeStack() {//无参构造函数，初始化栈
        this.head = null;
        this.count = 0;
        this.size = 10;
    }
    public ListNodeStack(int size) {//构造函数指定栈大小
        head=null;
        count=0;
        this.size=size;
    }
    public boolean isFull(){//判断是否栈已满
        if(count==size){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){//判断是否栈空
        if(count==0){
            return true;
        }
        return false;
    }
    public void push(int val){//压栈函数
        if(this.isFull()){
            throw new RuntimeException("stack is full");
        }
        ListNode l = new ListNode(val,head);
        head = l;
        count++;
    }
    public int pop(){//出栈函数
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

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ListNodeStack stack = new ListNodeStack(10);
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        System.out.println(stack.peak());
        System.out.println(stack.pop());
        System.out.println(stack.peak());

    }

}
