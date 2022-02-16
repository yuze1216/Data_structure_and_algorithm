package own;

/**
 * @author:yuze
 * @description:自己仿写一个非常简单的hashmap
 * @data:2022/1/16
 */
public class MyHashMap {
    public Node[] arr;
    public int length;
    public int size;
    public MyHashMap(){
        this.length = 1024;
        this.arr = new Node[length];
    }
    public int getSize(){
        return this.size;
    }
    //存放
    public void put(Object key , Object value){
        int hash = key.hashCode() < 0 ? -key.hashCode():key.hashCode() ;
        int i  = hash % arr.length;
        if(arr[i] == null){//下标i处没有元素直接放进去就好了
            Node node = new Node(key,value);
            arr[i] = node;
        }else {//下标i处有元素
            Node cur = arr[i];
            Node head = cur;
            if(head.key == key){//头节点的key与要寸的key冲突直接覆盖掉
                head.value = value;
                return;
            }
            while (head.next!=null){//头节点没冲突
                if(head.next.key.equals(key)){//遍历下面的链表是否有冲突，有冲突覆盖
                    head.next.key = value;
                    return;
                }else {//没有冲突继续遍历
                    head = head.next;
                }
            }
//            head.next = new Node(key,value);//尾插法，1.8是尾插法
            addNode(key,value,cur);//头插法，1.7是头插法
            return;
        }
    }
    private void addNode(Object key,Object value,Node cur){//头插法
        Node node = new Node(key,value);
        node.next = cur;
        cur = node;
    }
    public Object get(Object key){
        int hash = key.hashCode() < 0 ? -key.hashCode():key.hashCode() ;
        int i  = hash % arr.length;
        if(arr[i].equals(key)){
            return arr[i].value;
        }
        Node head = arr[i];
        while (head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }

        return null;
    }
    static final int hash(Object key) {//1.8的hash值算法
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    public static void main(String[] args) {
        //new HashMap<>()
        MyHashMap map = new MyHashMap();
        map.put("yuze",22);
        System.out.println(map.get("yuze"));
    }

}

class Node{
    Object key;
    Object value;
    Node next;
    public Node(){}
    public Node(Object key,Object value){ this.key = key; this.value = value;}
    public Node(int key,Object value,Node next){this.key = key; this.value = value;this.next = next;}
    @Override
    public String toString() {
        return "key:" +key+" value:" + "->" + next;
    }
}
