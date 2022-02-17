package own;

import java.util.Map;

/**
 * @author:yuze
 * @description:自己仿写一个非常简单的hashmap
 * @data:2022/1/16
 */
public class MyHashMap<K,V> {
    /**
     *默认初始容量
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // 默认 16
    /**
     * 构造函数中未指定时使用的负载系数
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * 最大容量
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;
    /**
     * hash表的加载因子
     */
    final float loadFactor;

    /**
     * 要调整大小的下一个大小值
     */
    int threshold;
    static final Node<?,?>[] EMPTY_TABLE = {};

    private Node<K,V>[] table = (Node<K,V>[]) EMPTY_TABLE;

    public int length;
    public int size;
    public MyHashMap(){
        this(DEFAULT_INITIAL_CAPACITY,DEFAULT_LOAD_FACTOR);
//        this.length = 1024;
//        this.arr = new Node[length];
    }
    public MyHashMap(int initialCapacity, float loadFactor){
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        this.loadFactor = loadFactor;
        threshold = initialCapacity;
    }
    public int getSize(){
        return this.size;
    }
    //存放
    public void put(K key , V value){
        if (table == EMPTY_TABLE) {
            inflateTable(threshold);
        }
        if (key == null){
            table[0].value = value;
        }
        int hash = key.hashCode() < 0 ? -key.hashCode():key.hashCode() ;
        int i  = hash % table.length;
        if(table[i] == null){//下标i处没有元素直接放进去就好了
            Node node = new Node(key,value);
            table[i] = node;
        }else {//下标i处有元素
            Node cur = table[i];
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
    /**
     * 初始化容器
     */
    private void inflateTable(int toSize) {
        // Find a power of 2 >= toSize
        int capacity = roundUpToPowerOf2(toSize);
        threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
        table = new Node[capacity];
        //initHashSeedAsNeeded(capacity);
    }
    /**
     *将number变为2的次幂，如6 -> 8, 12 -> 16
     */
    private static int roundUpToPowerOf2(int number) {
        // assert number >= 0 : "number must be non-negative";
        return number >= MAXIMUM_CAPACITY
                ? MAXIMUM_CAPACITY
                : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
    }
    private void addNode(Object key,Object value,Node cur){//头插法
        Node node = new Node(key,value);
        node.next = cur;
        cur = node;
    }
    public Object get(Object key){
        int hash = key.hashCode() < 0 ? -key.hashCode():key.hashCode() ;
        int i  = hash % table.length;
        if(table[i].equals(key)){
            return table[i].value;
        }
        Node head = table[i];
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


    static  class Node<K,V> implements Map.Entry<K,V>{
        K key;
        V value;
        Node<K,V> next;
        int hash;
        public Node(){}
        public Node(K key,V value){ this.key = key; this.value = value;}
        public Node(K key,V value,Node<K,V> next){this.key = key; this.value = value;this.next = next;}
        @Override
        public String toString() {
            return "key:" +key+" value:" + "->" + next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }

    public static void main(String[] args) {
        //new HashMap<>()
        MyHashMap map = new MyHashMap();
        map.put("yuze",22);
        System.out.println(map.get("yuze"));
    }
}