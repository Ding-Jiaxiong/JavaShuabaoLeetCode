package Recursion_32.深入理解递归_2.总结与练习.移除链表元素;

import java.util.List;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 15:59
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

    public static ListNode removeElements(ListNode head, int val) {

        if (head == null) {

            return head; // 链表为空，直接返回 null
        } else {

            head.next = removeElements(head.next, val);  // 递归调用 removeElements 方法来处理链表的下一个节点（head.next）

            if (head.val == val) {  // 当前节点的值是否等于 val。如果是，则需要删除当前节点
                head = head.next;
            }

            return head;  // 返回当前节点
        }
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        printList(node1);

        int val = 6;

        ListNode removed = removeElements(node1, val);

        printList(removed);

    }
}
