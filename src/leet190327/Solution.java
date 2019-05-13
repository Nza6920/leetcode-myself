package leet190327;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            System.out.println(cur.val);

            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return dummyHead.next;
    }

    public static void main(String... args)
    {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(4);

        ListNode temp1 = head1;
        ListNode temp2 = head2;

        for (int i = 1; i < 10; i++) {
            temp1.next = new ListNode(i);
            temp1 = temp1.next;
        }

        for (int i = 5; i < 15; i++) {
            temp2.next = new ListNode(i);
            temp2 = temp2.next;
        }

        ListNode head = mergeTwoLists(head1, head2);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}