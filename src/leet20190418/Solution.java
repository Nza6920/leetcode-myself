package leet20190418;

/**
 * 删除链表中等于给定值 val 的所有节点
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {

        ListNode node = head;

        while (node != null) {
            if (node.val == val) {
                head = node.next;
                node = head;
                continue;
            }

            if (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        removeElements(node, 1);
    }
}
