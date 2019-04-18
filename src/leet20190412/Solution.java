package leet20190412;




/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */

class Solution {
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode node = head;

        if (head == null) return null;

        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                continue;
            }

            node = node.next;
        }


        return head;
    }

    public static void main(String... args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        deleteDuplicates(head);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
        }
    }
}