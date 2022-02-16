package own;

/**
 * @author:yuze
 * @description:我的极简布隆过滤器
 * @data:2022/2/13
 */
public class MyBloomFilter {
    private int[] bloomFilter = new int[1024];

    public void add(String key){
        int hash = key.hashCode() % bloomFilter.length > 0 ? key.hashCode() % bloomFilter.length : -key.hashCode() % bloomFilter.length;
        if (bloomFilter[hash] == 1){
            return ;
        }else {
            bloomFilter[hash] = 1;
            return;
        }
    }
    public boolean findKey(String key){
        int hash = key.hashCode() % bloomFilter.length > 0 ? key.hashCode() % bloomFilter.length : -key.hashCode() % bloomFilter.length;
        if(bloomFilter[hash] == 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "yuze";
        String s1 = "zhangsan";
        MyBloomFilter bloomFilter = new MyBloomFilter();
        bloomFilter.add(s);
        System.out.println(bloomFilter.findKey(s));
        System.out.println(bloomFilter.findKey(s1));
    }
}
