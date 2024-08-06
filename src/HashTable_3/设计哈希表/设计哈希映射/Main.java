package HashTable_3.设计哈希表.设计哈希映射;

import java.util.LinkedList;
import java.util.List;

public class Main {

    static class MyHashMap {

        private class Entry {
            int key;
            int value;

            Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }

        }

        private static final int INITIAL_CAPACITY = 16;
        private LinkedList<Entry>[] buckets;

        public MyHashMap() {
            buckets = new LinkedList[INITIAL_CAPACITY];

            for (int i = 0; i < INITIAL_CAPACITY; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int getBucketIndex(int key) {
            return Integer.hashCode(key) % INITIAL_CAPACITY;   // 哈希函数
        }

        public void put(int key, int value) {

            int bucketIndex = getBucketIndex(key);

            LinkedList<Entry> bucket = buckets[bucketIndex];

            for (Entry entry : bucket) {
                if (entry.key == key) {  // 存在则更新
                    entry.value = value;
                    return;
                }
            }

            // 不存在添加
            bucket.add(new Entry(key, value));
        }

        public int get(int key) {

            int bucketIndex = getBucketIndex(key);
            LinkedList<Entry> bucket = buckets[bucketIndex];

            for (Entry entry : bucket) {
                if (entry.key == key) {  // 找到了

                    return entry.value;
                }
            }

            return -1;  // 不存在返回 -1

        }

        public void remove(int key) {

            int bucketIndex = getBucketIndex(key);
            LinkedList<Entry> bucket = buckets[bucketIndex];

            for (Entry entry : bucket) {
                if (entry.key == key) {
                    bucket.remove(entry);
                    return;
                }
            }

        }
    }

    public static void main(String[] args) {

        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        System.out.println(map.get(1)); // Outputs: 1
        System.out.println(map.get(3)); // Outputs: -1
        map.put(2, 1); // Update the existing value
        System.out.println(map.get(2)); // Outputs: 1
        map.remove(2);
        System.out.println(map.get(2)); // Outputs: -1

    }
}
