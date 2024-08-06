package HashTable_3.实际应用_哈希集合.使用哈希集合查重;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    /*
     * 使用哈希集合寻找重复元素的模板
     */
    boolean findDuplicates(List<Integer> keys) {
        // 将 type 替换为 keys 的实际类型
        Set<Integer> hashset = new HashSet<>();
        for (Integer key : keys) {
            if (hashset.contains(key)) {
                return true;
            }
            hashset.add(key);
        }
        return false;
    }
}
