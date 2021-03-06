package leet20190628;

import java.util.HashMap;

/**
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 *
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 *
 * 示例 1:
 *
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 *
 */
public class MapSum {

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            // 判断当前子节点中是否有字符 c
            if (! cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        // 单词的最后一个字符标记权重值
        cur.value = val;
    }

    public int sum(String prefix) {

        Node cur = root;

        // 找到前缀对应的最后一个字符对应的节点
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            // 前缀不存在
            if (! cur.next.containsKey(c)) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    /**
     * 遍历 node 以及 node的所有子节点的 value 值并求和
     * @param node 根节点
     * @return int
     */
    private int sum(Node node) {
        // 递归终止条件, 是否是叶子节点
//        if (node.next.size() == 0) {
//            return node.value;
//        }

        int res = node.value;

        // 遍历当前节点的所有子节点
        for (char c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("app"));

        mapSum.insert("appp", 2);
        System.out.println(mapSum.sum("app"));

        mapSum.insert("apppccc", 3);
        System.out.println(mapSum.sum("app"));

        mapSum.insert("ad", 3);
        System.out.println(mapSum.sum("ad"));
    }

    /**
     * 节点
     */
    private class Node {
        public int value;                            // 权重值
        public HashMap<Character, Node> next;        // 下一个字符

        private Node(int value) {
            this.value = value;
            next = new HashMap<>();
        }

        private Node() {
            this(0);
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
