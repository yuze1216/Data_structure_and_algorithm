package own;

/**
 * @author:yuze
 * @description:队列demo
 * @data:2021/8/21
 */
public class Queue {//循环队列
    int[] arr = new int[10];
    public int getFlag = 0;//取出下标
    public int putFlag = 0;//插入下标
    public void push(int x ){
        arr[putFlag] = x;
        putFlag = (putFlag+1)%arr.length;
    }

    public int pop(){
        int pop = arr[getFlag];
        getFlag = (getFlag+1)%arr.length;
        return pop;
    }

    public static void main(String[] args) {
        Queue d = new Queue();
        d.push(1);
        d.push(2);
        int pop = d.pop();
        System.out.println(pop);
    }
}
