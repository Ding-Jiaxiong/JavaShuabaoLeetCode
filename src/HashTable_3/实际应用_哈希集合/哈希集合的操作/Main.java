package HashTable_3.实际应用_哈希集合.哈希集合的操作;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 1. 初始化哈希集合
        Set<Integer> hashSet = new HashSet<>();
        // 2. 新增键
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(1);
        // 3. 删除键
        hashSet.remove(2);
        // 4. 查询键是否包含在哈希集合中
        if (!hashSet.contains(2)) {
            System.out.println("键 2 不在哈希集合中");
        }
        // 5. 哈希集合的大小
        System.out.println("哈希集合的大小为: " + hashSet.size());
        // 6. 遍历哈希集合
        for (Integer i : hashSet) {
            System.out.print(i + " ");
        }
        System.out.println("在哈希集合中");
        // 7. 清空哈希集合
        hashSet.clear();
        // 8. 查看哈希集合是否为空
        if (hashSet.isEmpty()) {
            System.out.println("哈希集合为空！");
        }
    }
}