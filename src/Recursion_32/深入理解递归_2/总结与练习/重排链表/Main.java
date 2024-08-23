package Recursion_32.深入理解递归_2.总结与练习.重排链表;

import java.time.chrono.HijrahEra;
import java.util.List;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 16:44
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

    // 链表一分为二、右边部分翻转、交叉合并
    public static void reorderList(ListNode head) {

        // 找到中间节点
        ListNode mid = findMid(head);

        // 将右边部分翻转
        ListNode curA = head;
        ListNode curB = reverse(mid.next);   // 反转右边

        mid.next = null;  // 链表一分为二

        // 合并
        merge(curA, curB);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {

        int flag = 1;  // 交叉遍历辅助

        // flag 为奇数则插入l1，偶数插 l2
        ListNode dummy = new ListNode(0);  // 辅助头

        while (l1 != null || l2 != null) {

            if (flag % 2 == 0) {

                dummy.next = l2;
                l2 = l2.next;
            } else {

                dummy.next = l1;
                l1 = l1.next;
            }

            flag++;

            dummy = dummy.next;
        }

        return dummy.next;
    }

    // 找到链表中间节点
    private static ListNode findMid(ListNode head) {

        // 辅助头
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 快慢指针
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 翻转链表
    private static ListNode reverse(ListNode head) {

        ListNode reversedList = null;  // 头结点

        while (head != null) {

            ListNode next = head.next;
            head.next = reversedList;
            reversedList = head;
            head = next;
        }

        return reversedList;
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

        reorderList(node1);

        printList(node1);
    }
}
