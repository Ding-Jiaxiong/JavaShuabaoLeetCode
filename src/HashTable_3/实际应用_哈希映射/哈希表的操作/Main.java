package HashTable_3.实际应用_哈希映射.哈希表的操作;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. 初始化哈希表
        Map<Integer, Integer> hashmap = new HashMap<>();
        // 2. 插入一个新的（键，值）对
        hashmap.putIfAbsent(0, 0);
        hashmap.putIfAbsent(2, 3);
        // 3. 插入一个新的（键，值）对，或者更新值
        hashmap.put(1, 1);
        hashmap.put(1, 2);
        // 4. 获得特定键对应的值
        System.out.println("键 1 对应的值为: " + hashmap.get(1));
        // 5. 删除键
        hashmap.remove(2);
        // 6. 检查键是否存在于哈希表中
        if (!hashmap.containsKey(2)) {
            System.out.println("键 2 不在哈希表中");
        }
        // 7. 哈希表的大小
        System.out.println("哈希表的大小为: " + hashmap.size());
        // 8. 遍历哈希表
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
        }
        System.out.println("在哈希表中");
        // 9. 清空哈希表
        hashmap.clear();
        // 10. 检查哈希表是否为空
        if (hashmap.isEmpty()) {
            System.out.println("哈希表为空！");
        }
    }
}