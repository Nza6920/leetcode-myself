package leet20190420;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *     push(x) -- 将元素 x 推入栈中。
 *     pop() -- 删除栈顶的元素。
 *     top() -- 获取栈顶元素。
 *     getMin() -- 检索栈中的最小元素。
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack {

    private ListNode head = null;      // 存储结构
    private int min = 0;            // 最小元素

    public MinStack() {

    }

    public void push(int x) {
        ListNode node = new ListNode(x);
        if (head == null) {
            head = node;
            min = head.val;
        } else {
            node.next = head;
            head = node;
            if (head.val < min)
                min = head.val;
        }
    }

    public void pop() {
        if (head != null) {
            int temp = head.val;
            head = head.next;
            if (temp == min) {
                ListNode node = head;
                if (node != null) {
                    min = node.val;
                    while (node != null) {
                        if (node.val < min) {
                            min = node.val;
                        }
                        node = node.next;
                    }
                }else {
                    min = 0;
                }
            }
        }
    }

    public int top() {
        return head == null ? -1 : head.val;
    }

    public int getMin() {
        return min;
    }

    // 存储结构
    private  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String... args)
    {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.pop();
        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.getMin());
//        minStack.getMin();
//        minStack.pop();
//        minStack.top();
//        minStack.getMin();
    }
}
