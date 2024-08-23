package Recursion_32.深入理解递归_2.使用递归函数简化链表中穿针引线的操作.例题讲解_反转链表;

import java.util.List;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 15:53
 * */

public class Main {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {

            if (head.next != null) {
                System.out.print(head.val + " -> ");
            } else {
                System.out.print(head.val);
            }

            head = head.next;
        }

        System.out.println();
    }

    public static ListNode reverseList(ListNode head) {

        return recur(head, null);
    }

    private static ListNode recur(ListNode cur, ListNode pre) {

        if (cur == null) return pre;  // 终止

        ListNode res = recur(cur.next, cur);  // 递归后继

        cur.next = pre;  // 修改节点引用指向

        return res;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printList(node1);

        ListNode listNode = reverseList(node1);

        printList(listNode);

    }
}
