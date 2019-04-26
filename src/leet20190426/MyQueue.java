package leet20190426;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 *
 *     push(x) -- 将一个元素放入队列的尾部。
 *     pop() -- 从队列首部移除元素。
 *     peek() -- 返回队列首部的元素。
 *     empty() -- 返回队列是否为空。
 *
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 说明:
 *
 *     你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 *     你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *     假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class MyQueue {

    private Stack<Integer> mainStack;
    public MyQueue() {
        mainStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
    }

    public int pop() {
        Stack<Integer> tempStack = new Stack<>();
        while(!mainStack.empty()){
            tempStack.push(mainStack.pop());
        }
        int result = tempStack.pop();
        while(!tempStack.empty()){
            mainStack.push(tempStack.pop());
        }
        return result;
    }

    public int peek() {
        Stack<Integer> tempStack = new Stack<>();
        while(!mainStack.empty()){
            tempStack.push(mainStack.pop());
        }
        int result = tempStack.pop();
        tempStack.push(result);
        while(!tempStack.empty()){
            mainStack.push(tempStack.pop());
        }
        return result;
    }

    public boolean empty() {
        return mainStack.empty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.push(3);
        System.out.println(queue.peek());



    }
}
