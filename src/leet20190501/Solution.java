package leet20190501;

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 *
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 *
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 *
 * 提示：
 *
 *     1 <= S.length <= 200
 *     1 <= T.length <= 200
 *     S 和 T 只含有小写字母以及字符 '#'。
 */
public class Solution {
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();

        str2Stack(s, S);
        str2Stack(t, T);

        if (s.size() != t.size()) return false;

        while (! s.isEmpty()) {
            if (s.pop() != t.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void str2Stack(Stack target, String str) {
        for (Character ch : str.toCharArray()) {
            switch (ch) {
                case '#':
                    if (! target.isEmpty())
                        target.pop();
                    break;
                default:
                    target.push(ch);
            }
        }
    }

    public static void main(String[] args) {

        String a = "a##cb";
        String b = "#a#cc";

        System.out.println(backspaceCompare(a, b));
    }
}