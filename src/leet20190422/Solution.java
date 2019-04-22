package leet20190422;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
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

    public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode node = head;

        while(node != null){
            stack.push(node);
            node = node.next;
        }
        while (head != null){
            if(head.val != stack.pop().val){
                return false;
            }
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next;
        head.next.next.next.next = head;
        System.out.println(isPalindrome(head));
    }
}
