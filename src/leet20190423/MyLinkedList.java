package leet20190423;

/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 *     get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 *     addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 *     addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 *     addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 *     deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 *
 *
 * 示例：
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 *
 *
 * 提示：
 *
 *     所有值都在 [1, 1000] 之内。
 *     操作次数将在  [1, 1000] 之内。
 *     请不要使用内置的 LinkedList 库。
 */
public class MyLinkedList {
    // 节点类型
    public static class Node
    {
        public Node(int value) {
            this.value = value;
        }
        public int value;
        public Node prev;     // 上一个节点
        public Node next;     // 下一个节点
    }

    // 头结点
    public Node head = new Node(-1);

    // 尾结点
    public Node tail = new Node(-1);

    public MyLinkedList() {
        head.next = tail;     // 头结点的下一个是尾结点
        tail.prev = head;     // 尾结点的上一个是头结点
    }

    public int get(int index) {
        Node node = head.next;

        while (node != tail && index > 0) {
            node = node.next;
            index--;
        }

        return node == tail ? -1 : node.value;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    public void addAtIndex(int index, int val) {
        Node node = head.next;

        while (node != tail && index > 0) {
            node = node.next;
            index--;
        }

        if (index == 0) {
            Node newNode = new Node(val);
            node.prev.next = newNode;
            newNode.prev = node.prev;
            newNode.next = node;
            node.prev = newNode;
        }
    }

    public void deleteAtIndex(int index) {
        Node node = head.next;

        while (node != tail && index > 0) {
            node = node.next;
            index--;
        }

        if (node != tail) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtHead(2);
        linkedList.addAtHead(3);
        linkedList.addAtHead(4);
        linkedList.deleteAtIndex(3);
        linkedList.addAtIndex(3,3);
        System.out.println(linkedList.get(3));
    }
}
