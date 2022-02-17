package own;

import utils.ListNode;

/**
 * @author:yuze
 * @description:栈结构(泛型)
 * @data:2022/1/12
 */
public class StackDemo<E>{
    private E[] arr = (E[])new Object[20];
    private int index = 0;
    public void add(E x){
        if(index == arr.length){
            E[] arrx = (E[])new Object[arr.length*2];
            for (int i = 0; i < arr.length; i++) {
                arrx[i] = arr[i] ;
            }
            arr = arrx;
        }
        arr[index] = x;
        index++;
    }
    public E get(){
        if(index > 0){
            E x = arr[index -1];
            index--;
            return x;
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        StackDemo<ListNode> stack = new StackDemo<>();
        for (int i = 0; i < 100; i++) {
            stack.add(new ListNode(i));
        }
        for (int i = 0; i < 100; i++) {
            System.out.println( stack.get());
        }
    }
}
