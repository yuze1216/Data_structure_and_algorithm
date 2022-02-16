package own;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:yuze
 * @description:自己实现lru缓存淘汰算法，LeetCode146. LRU 缓存
 * @data:2022/2/13
 */
public class LRUCache {
    private Map<Integer, MyLinkedNode> cache = new HashMap<Integer, MyLinkedNode>();
    private int capacity;//初始化容量
    private int size;//缓存现有数量
    private MyLinkedNode head,tail;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new MyLinkedNode();
        tail = new MyLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        MyLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);//每次get就将节点放进头，表示使用多
        return node.value;
    }

    public void put(int key, int value) {
        MyLinkedNode node = cache.get(key);
        if(node == null){//不存在这个节点就创建一个添加进缓存
            MyLinkedNode newNode = new MyLinkedNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size > capacity){
                //容量超出就删除链表的尾部节点
                MyLinkedNode tail = deleteTail();
                cache.remove(tail.key);//key的作用在这了。不需要遍历链表了，直接获取key删掉
                --size;
            }
        }else {//这个key存在了的话，就修改value并且移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(MyLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private void moveToHead(MyLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    private void removeNode(MyLinkedNode node){//删除节点
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private MyLinkedNode deleteTail(){
        MyLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    class MyLinkedNode{//双向链表节点
        int key;
        int value;
        MyLinkedNode prev;
        MyLinkedNode next;
        public MyLinkedNode(){}
        public MyLinkedNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

}
