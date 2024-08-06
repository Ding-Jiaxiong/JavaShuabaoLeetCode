package HashTable_3.设计哈希表.设计哈希集合;

import java.util.LinkedList;
import java.util.List;

public class Main {

    static class MyHashSet {

        private static final int BASE = 769;  // 基数
        private List<Integer>[] data;  // 存储链表，链表中的每个节点存储哈希表中的元素

        public MyHashSet() {
            data = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                data[i] = new LinkedList<>();
            }
        }

        private int hash(int key) {
            return key % BASE;
        }

        public void add(int key) {
            int h = hash(key);
            if (!data[h].contains(key)) {
                data[h].add(key);
            }
        }

        public void remove(int key) {
            int h = hash(key);
            data[h].remove((Integer) key);
        }

        public boolean contains(int key) {
            int h = hash(key);
            return data[h].contains(key);
        }
    }

    public static void main(String[] args) {

        MyHashSet myHashSet = new MyHashSet();

        myHashSet.add(1);
        myHashSet.add(2);

        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(2));

        System.out.println(myHashSet.contains(3));

        myHashSet.remove(1);
        System.out.println(myHashSet.contains(1));
    }

}
