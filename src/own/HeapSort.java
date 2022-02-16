package own;

/**
 * @author:yuze
 * @description:堆排序，堆排序是一个完全二叉树的结构，以数组就可以实现，因为父节的数组索引可以推导出孩子节点 lChild = 2 * parent + 1
 * @data:2022/1/20
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {13,24,31,5,3,6,19,1,9};
        heapSort(arr);
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void heapSort(int[] arr){
        for (int i = (arr.length-1)/2; i >=0 ; i--) {
            //从第一个非叶子节点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //调整堆结构+交换堆顶元素和堆尾元素
        for (int i = arr.length - 1; i >0 ; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,i);//重新堆调整
            for (int j = 0; j <arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    public static void adjustHeap(int[] arr ,int parent ,int length){
        int temp = arr[parent];//记录下父节点的值
        int lChild = 2 * parent + 1;//对应父节点的左孩子
        while (lChild < length){
            int rChild = lChild + 1;//右孩子
            if(rChild < length && arr[lChild] < arr[rChild]){
                lChild++;//选取出左右孩子节点值的大值用来和父节点比较
            }
            if(temp >= arr[lChild]){
                break;
            }
            arr[parent] = arr[lChild];
            parent = lChild;//选取孩子结点的左孩子结点,继续向下筛选
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }
}

