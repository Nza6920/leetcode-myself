package leet20190419;


public class Solution {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode current = head.next;
        temp.next = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = temp;
            temp = current;
            current = next;
        }

        return temp;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        reverseList1(null);

    }

}