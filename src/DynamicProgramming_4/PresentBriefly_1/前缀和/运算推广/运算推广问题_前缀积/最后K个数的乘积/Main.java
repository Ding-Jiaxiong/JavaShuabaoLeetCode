package DynamicProgramming_4.PresentBriefly_1.前缀和.运算推广.运算推广问题_前缀积.最后K个数的乘积;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static class ProductOfNumbers {

        List<Integer> prefixProduct;  // 前缀积列表

        public ProductOfNumbers() {

            prefixProduct = new ArrayList<>();
            prefixProduct.add(1);  // 初始化扔个 1
        }

        public void add(int num) {

            // 重置
            if (num == 0) {
                prefixProduct.clear();
                prefixProduct.add(1);
            } else {

                // 当前乘积
                prefixProduct.add(num * prefixProduct.get(prefixProduct.size() - 1));  // 加入
            }
        }

        public int getProduct(int k) {

            int size = prefixProduct.size();

            if (k >= size) {
                return 0;
            } else {

                // 当前乘积 = prefixProduct[总长度] / prefixProduct[总长度 - k]
                return prefixProduct.get(size - 1) / prefixProduct.get(size - 1 - k);
            }
        }
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);      // 当前列表: [3]
        productOfNumbers.add(0);      // 当前列表: [0] 由于 0，前缀积和列表清空
        productOfNumbers.add(2);      // 当前列表: [2]
        productOfNumbers.add(5);      // 当前列表: [2, 5]
        productOfNumbers.add(4);      // 当前列表: [2, 5, 4]
        System.out.println(productOfNumbers.getProduct(2)); // 应该输出 20 (5*4)
        System.out.println(productOfNumbers.getProduct(3)); // 应该输出 40 (2*5*4)

    }
}
