package leet20190629;


import java.util.HashMap;

/**
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 *
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * 说明:
 *
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 */
public class WordDictionary {
    private Node root;       // 根节点

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // 判断当前所有的子节点中是否存在c
            if (! cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        // 设置为一个单词的边界
        cur.isWord = true;
    }

    public boolean search(String word) {
        return match(root, word, 0);
    }

    /**
     * 递归函数
     * @param node   根节点
     * @param word   当前的搜索的单词
     * @param index  当前的字符
     * @return boolean
     */
    private boolean match(Node node, String word, int index) {
        // 递归的终止条件
        if (index == word.length()) {
            // 判断最后一个字符是不是表示一个单词的最后一个字母
            return node.isWord;
        }

        char c = word.charAt(index);

        // 普通情况, c 不是通配符
        if (c != '.') {
            if (! node.next.containsKey(c)) {
                return false;
            } else {
                return match(node.next.get(c), word, index + 1);
            }
        } else {   // c 是通配符 (这一层每一个节点都假设是正确的)
            // 取出当前节点的所有子节点
            for (char nexChar : node.next.keySet()) {
                // 从当前节点向下继续匹配
                if (match(node.next.get(nexChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 节点
     */
    private class Node {
        public boolean isWord;                       // 是否是一个单词
        public HashMap<Character, Node> next;        // 下一个字符

        private Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    public static void main(String[] args) {
        WordDictionary word = new WordDictionary();
        word.addWord("bad");
        word.addWord("dad");
        word.addWord("mad");
        System.out.println(word.search("pad"));
        System.out.println(word.search("bad"));
        System.out.println(word.search(".ad"));
        System.out.println(word.search("b.."));
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
