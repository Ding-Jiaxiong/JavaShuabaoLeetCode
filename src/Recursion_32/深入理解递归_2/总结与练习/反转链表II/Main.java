package Recursion_32.深入理解递归_2.总结与练习.反转链表II;

import java.util.logging.Level;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 17:03
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

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        // 虚拟头节点
        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;

        // 将curr移动到第left-1个节点位置
        for (int i = 0; i < left - 1; i++) {
            cur = cur.next;
        }

        //  pre指针用于反转链表中的节点
        ListNode pre = null;
        ListNode p1 = cur.next;

        // 翻转从 left 到 right 位置的节点
        for (int i = 0; i < right - left + 1; i++) {

            ListNode tmp = p1.next;  // 暂存
            p1.next = pre;  // 反转当前节点指向

            pre = p1;
            p1 = tmp;
        }

        // 重新链接翻转部分的头尾
        cur.next.next = p1;
        cur.next = pre;

        return dummy.next;
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

        ListNode node = reverseBetween(node1, 2, 4);

        printList(node);

    }
}
